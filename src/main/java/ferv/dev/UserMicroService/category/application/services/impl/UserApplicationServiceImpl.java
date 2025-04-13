package ferv.dev.UserMicroService.category.application.services.impl;

import ferv.dev.UserMicroService.category.application.dto.response.UserContactInfoResponse;
import ferv.dev.UserMicroService.category.application.dto.response.UserResponse;
import ferv.dev.UserMicroService.category.application.services.UserApplicationService;
import ferv.dev.UserMicroService.category.domain.ports.in.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService {

    private UserServicePort userServicePort;

    @Override
    public UserResponse getUser() {
        return null;
    }

    @Override
    public List<UserResponse> getAllUser() {
        return List.of();
    }

    @Override
    public UserResponse getUserById(Long id) {
        return null;
    }

    @Override
    public UserContactInfoResponse getUserContact(Long id) {
        return null;
    }
}
