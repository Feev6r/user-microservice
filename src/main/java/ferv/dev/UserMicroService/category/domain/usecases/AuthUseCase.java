package ferv.dev.UserMicroService.category.domain.usecases;

import ferv.dev.UserMicroService.category.domain.exeptions.NotValidAgeExeption;
import ferv.dev.UserMicroService.category.domain.models.Role;
import ferv.dev.UserMicroService.category.domain.models.User;
import ferv.dev.UserMicroService.category.domain.ports.in.AuthServicePort;
import ferv.dev.UserMicroService.category.domain.ports.out.AuthManagerPort;
import ferv.dev.UserMicroService.category.domain.ports.out.TokenServicePort;
import ferv.dev.UserMicroService.category.domain.ports.out.UserPersistencePort;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDate;

public class AuthUseCase  implements AuthServicePort {

    private  final TokenServicePort tokenServicePort;
    private  final UserPersistencePort userPersistencePort;
    private  final AuthManagerPort authManagerPort;

    public AuthUseCase(TokenServicePort tokenServicePort, UserPersistencePort userPersistencePort, AuthManagerPort authManagerPort) {
        this.tokenServicePort = tokenServicePort;
        this.userPersistencePort = userPersistencePort;
        this.authManagerPort = authManagerPort;
    }

    @Override
    public String register(User user) {
        if(user.getRole() == Role.OWNER){
            LocalDate birthDate = user.getBirthdate();
            LocalDate minDate = LocalDate.now().minusYears(18);

            if (!birthDate.isBefore(minDate) && !birthDate.isEqual(minDate)) {
                throw new NotValidAgeExeption();
            }
        }

        userPersistencePort.saveUser(user);
        User newUser = userPersistencePort.getUserByEmail(user.getEmail());

        return tokenServicePort.generateToken(newUser);
    }

    @Override
    public String authenticate(User user) {
        authManagerPort.authenticate(user);
        return tokenServicePort.generateToken(user);
    }
}
