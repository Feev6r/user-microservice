package ferv.dev.UserMicroService.commons.configurations.beans.security;

import ferv.dev.UserMicroService.category.domain.models.Role;
import ferv.dev.UserMicroService.category.infrastructure.security.filters.TokenAuthenticationFilter;
import ferv.dev.UserMicroService.commons.configurations.utils.constants.ApiPaths;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private  final TokenAuthenticationFilter tokenAuthenticationFilter;
    private  final AuthenticationProvider authenticationProvider;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable
                )
                .authorizeHttpRequests(authorize -> authorize
//                         .requestMatchers(ApiPaths.Auth.BASE + ApiPaths.Auth.ADMIN).permitAll() //
                        //.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()

                        .requestMatchers(ApiPaths.Auth.BASE + ApiPaths.Auth.CLIENT).permitAll()
                        .requestMatchers(ApiPaths.Auth.BASE + ApiPaths.Auth.AUTHENTICATE).permitAll()
                        .requestMatchers(ApiPaths.User.BASE + ApiPaths.User.ALL).hasRole(Role.ADMIN.name())
                        .requestMatchers(ApiPaths.Auth.BASE + ApiPaths.Auth.OWNER).hasRole(Role.ADMIN.name())
                        .requestMatchers(ApiPaths.Auth.BASE + ApiPaths.Auth.EMPLOYEE).hasRole(Role.OWNER.name())
                        .requestMatchers(ApiPaths.User.BASE + ApiPaths.User.GET_BY_ID).hasRole(Role.OWNER.name())
                        .requestMatchers(ApiPaths.User.BASE + ApiPaths.User.GET_CONTACT).hasRole(Role.EMPLOYEE.name())
                        .anyRequest().authenticated()
                )
                .logout(LogoutConfigurer::permitAll
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider
                ).addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }

}
