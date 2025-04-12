package ferv.dev.UserMicroService.commons.configurations.beans.security;

import ferv.dev.UserMicroService.category.domain.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private  final  AuthenticationFilter authenticationFilter;
    private  final AuthenticationProvider authenticationProvider;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable
                )
                .authorizeHttpRequests(authorize -> authorize
                        // .requestMatchers("/auth/registerAdmin").permitAll() //no esta es necesario estar autenticado porque es para testeo
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()

                        .requestMatchers("/auth/registerClient").permitAll()
                        .requestMatchers("/auth/authenticate").permitAll()
                        .requestMatchers("/user/getAll").hasRole(Role.ADMIN.name())
                        .requestMatchers("/auth/registerOwner").hasRole(Role.ADMIN.name())
                        .requestMatchers("/auth/registerEmployee").hasRole(Role.OWNER.name())
                        .requestMatchers("/user/get/{id}").hasRole(Role.OWNER.name())
                        .requestMatchers("/user/getContact/{id}").hasRole(Role.EMPLOYEE.name())
                        .anyRequest().authenticated()
                )
                .logout(LogoutConfigurer::permitAll
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider
                ).addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }

}
