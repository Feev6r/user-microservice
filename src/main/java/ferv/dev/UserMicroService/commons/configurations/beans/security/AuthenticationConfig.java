package ferv.dev.UserMicroService.commons.configurations.beans.security;


import ferv.dev.UserMicroService.category.infrastructure.repositories.mysql.UserRepository;
import ferv.dev.UserMicroService.commons.configurations.utils.constants.ErrorMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@RequiredArgsConstructor
public class AuthenticationConfig {

    private final UserRepository userRepository;

    @Bean
    UserDetailsService userDetailService() {
        return username -> {
            try {
                Long userId = Long.parseLong(username);
                return userRepository.findById(userId)
                        .orElseThrow(() -> new UsernameNotFoundException(ErrorMessages.USERNAME_MESSAGE_EXEPTION));
            } catch (NumberFormatException e) {
                throw new UsernameNotFoundException(ErrorMessages.USERNAME_FORMAT_MESSAGE_EXEPTION);
            }
        };
    }

    @Bean
    AuthenticationProvider authenticationProvider(){ //fetch the user details and hash the password

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(); //data access object = dao
        authProvider.setUserDetailsService(userDetailService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
