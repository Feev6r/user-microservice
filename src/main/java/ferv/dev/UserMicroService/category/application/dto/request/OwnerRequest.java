package ferv.dev.UserMicroService.category.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerRequest extends UserRequest{

    @NotBlank
    private String birthDate;

}
