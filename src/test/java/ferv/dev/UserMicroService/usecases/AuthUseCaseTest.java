package ferv.dev.UserMicroService.usecases;

import ferv.dev.UserMicroService.category.domain.exeptions.NotValidAgeExeption;
import ferv.dev.UserMicroService.category.domain.models.Role;
import ferv.dev.UserMicroService.category.domain.models.User;
import ferv.dev.UserMicroService.category.domain.ports.out.TokenServicePort;
import ferv.dev.UserMicroService.category.domain.ports.out.UserPersistencePort;
import ferv.dev.UserMicroService.category.domain.usecases.AuthUseCase;
import ferv.dev.UserMicroService.category.infrastructure.entities.UserEntity;
import jakarta.validation.constraints.Null;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthUseCaseTest {

    @Mock
    private TokenServicePort tokenServicePort;

    @Mock
    private UserPersistencePort userPersistencePort;


    @InjectMocks
    private AuthUseCase authUseCase;

    @Test
    public void AuthUseCase_Register_ReturnsInvalidAgeException(){

        User user1 = new User(
                null,
                Role.OWNER,
                "Fernando",
                "Villegas",
                "1112041434",
                "3127598294",
                LocalDate.of(2010, 12, 15),
                "Fernandovillegas000@gmail.com",
                "contraseña");

        //ASSERT
        Assertions.assertThatThrownBy(() -> authUseCase.register(user1))
                .isInstanceOf(NotValidAgeExeption.class);
    }


    @Test
    public void AuthUseCase_Register_ReturnsToken(){

        User user1 = new User(
                1L,
                Role.OWNER,
                "Fernando",
                "Villegas",
                "1112041434",
                "3127598294",
                LocalDate.of(2005, 12, 15),
                "Fernandovillegas000@gmail.com",
                "contraseña");


        User user2 = new User(
                null,
                Role.OWNER,
                "Fernando",
                "Villegas",
                "1112041434",
                "3127598294",
                LocalDate.of(2005, 12, 15),
                "Fernandovillegas000@gmail.com",
                "contraseña");


        String jwt = "Generated token";
        when(userPersistencePort.getUserByEmail(Mockito.any(String.class))).thenReturn(user1);
        when(tokenServicePort.generateToken(Mockito.any(User.class))).thenReturn(jwt);

        String GeneratedJwt = authUseCase.register(user2);

        //ASSERT
        Assertions.assertThat(GeneratedJwt).isEqualTo(jwt);
    }

}
