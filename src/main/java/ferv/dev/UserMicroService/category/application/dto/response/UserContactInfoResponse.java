package ferv.dev.UserMicroService.category.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserContactInfoResponse {

    private String firstname;
    private String phoneNumber;
    private String email;

}
