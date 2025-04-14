package ferv.dev.UserMicroService.category.application.mapper;

import ferv.dev.UserMicroService.category.application.dto.request.ClientRequest;
import ferv.dev.UserMicroService.category.application.dto.request.EmployeeRequest;
import ferv.dev.UserMicroService.category.application.dto.request.OwnerRequest;
import ferv.dev.UserMicroService.category.application.dto.request.UserRequest;
import ferv.dev.UserMicroService.category.application.dto.response.UserResponse;
import ferv.dev.UserMicroService.category.domain.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface
UserRequestMapper {

    User toUser(UserRequest userRequest);
    User toUser(OwnerRequest ownerRequest);
    User toUser(EmployeeRequest employeeRequest);
    User toUser(ClientRequest clientRequest);

}
