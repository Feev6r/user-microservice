package ferv.dev.UserMicroService.category.application.mapper;

import ferv.dev.UserMicroService.category.application.dto.response.UserContactInfoResponse;
import ferv.dev.UserMicroService.category.application.dto.response.UserResponse;
import ferv.dev.UserMicroService.category.domain.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    UserResponse toUserResponse(User user);
    List<UserResponse> toUserResponseList(List<User> userList);
    UserContactInfoResponse toUserContact(User user);
}
