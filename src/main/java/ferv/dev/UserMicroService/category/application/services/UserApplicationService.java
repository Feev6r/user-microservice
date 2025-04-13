package ferv.dev.UserMicroService.category.application.services;

import ferv.dev.UserMicroService.category.application.dto.response.UserContactInfoResponse;
import ferv.dev.UserMicroService.category.application.dto.response.UserResponse;

import java.util.List;

public interface UserApplicationService {

    UserResponse getUser(); //personal info
    List<UserResponse> getAllUser(); //all users - only admin
    UserResponse getUserById(Long id);
    UserContactInfoResponse getUserContact(Long id); //Specific info from user

}
