package ferv.dev.UserMicroService.commons.configurations.beans.ports;

import ferv.dev.UserMicroService.category.domain.ports.in.AuthServicePort;
import ferv.dev.UserMicroService.category.domain.ports.out.AuthManagerPort;
import ferv.dev.UserMicroService.category.domain.ports.out.TokenServicePort;
import ferv.dev.UserMicroService.category.domain.ports.out.UserPersistencePort;
import ferv.dev.UserMicroService.category.domain.usecases.AuthUseCase;
import ferv.dev.UserMicroService.category.domain.usecases.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PortsConfiguration {

    private  final TokenServicePort tokenServicePort;
    private  final UserPersistencePort userPersistencePort;
    private  final AuthManagerPort authManagerPort;

    @Bean
    public AuthServicePort authServicePort(){
        return new AuthUseCase(tokenServicePort, userPersistencePort, authManagerPort);
    }


    @Bean
    public UserUseCase userUseCase(){
        return new UserUseCase(userPersistencePort, tokenServicePort);
    }


}
