package ferv.dev.UserMicroService.repositories.mysql;

import ferv.dev.UserMicroService.category.infrastructure.entities.UserEntity;
import ferv.dev.UserMicroService.category.infrastructure.repositories.mysql.UserRepository;
import ferv.dev.UserMicroService.commons.configurations.utils.constants.Constants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositorieTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserRepository_findAll_ReturnAll(){

        //ARRANGE
        UserEntity user1 = UserEntity.builder()
                .firstname("Fernando")
                .lastname("Villegas")
                .identityNumber("1112041434")
                .phoneNumber("3127598294")
                .birthdate(LocalDate.of(2005, 12, 15))
                .email("Fernandovillegas000@gmail.com")
                .password("contraseña").build();

        UserEntity user2 = UserEntity.builder()
                .firstname("María")
                .lastname("González")
                .identityNumber("0987654321")
                .phoneNumber("3001234567")
                .birthdate(LocalDate.of(1990, 5, 22))
                .email("maria.gonzalez@example.com")
                .password("securePassword123").build();


        //ACT

        int PgSize = 2;

        userRepository.save(user1);
        userRepository.save(user2);
        Pageable pagination = PageRequest.of(0, PgSize, Sort.by(Constants.PAGEABLE_FIELD_FIRSTNAME).descending());
        Page<UserEntity> users = userRepository.findAll(pagination);


        //ASSERT
        Assertions.assertThat(users).isNotNull();
        Assertions.assertThat(users).hasSize(PgSize);


    }

}
