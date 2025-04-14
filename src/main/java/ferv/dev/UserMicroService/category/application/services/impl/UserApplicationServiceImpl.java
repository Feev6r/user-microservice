package ferv.dev.UserMicroService.category.application.services.impl;

import ferv.dev.UserMicroService.category.application.dto.response.UserContactInfoResponse;
import ferv.dev.UserMicroService.category.application.dto.response.UserResponse;
import ferv.dev.UserMicroService.category.application.mapper.UserResponseMapper;
import ferv.dev.UserMicroService.category.application.services.UserApplicationService;
import ferv.dev.UserMicroService.category.domain.ports.in.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService {

    private UserServicePort userServicePort;
    private UserResponseMapper userResponseMapper;

    @Override
    public UserResponse getUser() {
        return userResponseMapper.toUserResponse(userServicePort.getUserBySecurityContext());
    }

    @Override
    public List<UserResponse> getAllUser(Integer size, Integer page, boolean orderAsc) {
        return userResponseMapper.toUserResponseList(userServicePort.getAllUser(page, size, orderAsc));
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userResponseMapper.toUserResponse(userServicePort.getUser(id));
    }

    @Override
    public UserContactInfoResponse getUserContact(Long id) {
        return userResponseMapper.toUserContact(userServicePort.getUser(id));
    }
}
