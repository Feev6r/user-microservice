package ferv.dev.UserMicroService.usecases;

import ferv.dev.UserMicroService.category.domain.models.Role;
import ferv.dev.UserMicroService.category.domain.models.User;
import ferv.dev.UserMicroService.category.domain.ports.out.TokenServicePort;
import ferv.dev.UserMicroService.category.domain.ports.out.UserPersistencePort;
import ferv.dev.UserMicroService.category.domain.usecases.UserUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserUseCaseTest {

    @Mock
    UserPersistencePort userPersistencePort;

    @Mock
    TokenServicePort tokenServicePort;

    @InjectMocks
    UserUseCase userUseCase;

    @Test
    void getUserBySecurityContext_shouldReturnUser_whenTokenServiceAndPersistenceWork() {

        User user1 = new User(
                1L,
                Role.OWNER,
                "Fernando",
                "Villegas",
                "1112041434",
                "3127598294",
                LocalDate.of(2010, 12, 15),
                "Fernandovillegas000@gmail.com",
                "contraseña");


        Long userId = 1L;
        when(tokenServicePort.getUserIdBySecurityContext()).thenReturn(userId);
        when(userPersistencePort.getUser(Mockito.anyLong())).thenReturn(user1);

        User user = userUseCase.getUserBySecurityContext();

        assertThat(user).isEqualTo(user1);
    }

}
