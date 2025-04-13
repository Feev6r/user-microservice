package ferv.dev.UserMicroService.category.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public class OwnerRequest extends UserRequest{

    @NotBlank
    private String birthDate;

}
