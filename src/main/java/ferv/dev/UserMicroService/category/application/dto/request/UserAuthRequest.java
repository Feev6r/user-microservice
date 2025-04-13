package ferv.dev.UserMicroService.category.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthRequest {

    private String email;
    private String password;
}
