package ferv.dev.UserMicroService.category.application.dto.response;

import ferv.dev.UserMicroService.category.domain.models.Role;
import java.time.LocalDate;

public class UserResponse {

    private Role role;
    private Long id;
    private String firstname;
    private String lastname;
    private String identityNumber;
    private String phoneNumber;
    private LocalDate birthdate;
    private String email;

}
