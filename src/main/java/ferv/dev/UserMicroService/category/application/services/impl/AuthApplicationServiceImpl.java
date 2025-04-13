package ferv.dev.UserMicroService.category.application.services.impl;

import ferv.dev.UserMicroService.category.application.dto.request.ClientRequest;
import ferv.dev.UserMicroService.category.application.dto.request.EmployeeRequest;
import ferv.dev.UserMicroService.category.application.dto.request.OwnerRequest;
import ferv.dev.UserMicroService.category.application.dto.request.UserAuthRequest;
import ferv.dev.UserMicroService.category.application.dto.response.AuthResponse;
import ferv.dev.UserMicroService.category.application.mapper.UserRequestMapper;
import ferv.dev.UserMicroService.category.application.services.AuthApplicationService;
import ferv.dev.UserMicroService.category.domain.models.User;
import ferv.dev.UserMicroService.category.domain.ports.in.AuthServicePort;
import ferv.dev.UserMicroService.category.domain.ports.in.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthApplicationServiceImpl implements AuthApplicationService {

    private final AuthServicePort authServicePort;
    private final UserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;

    @Override
    public AuthResponse registerOwner(OwnerRequest ownerRequest) {

        String jwt = authServicePort.register(userRequestMapper.toUser(ownerRequest));
        return AuthResponse.builder()
                .token(jwt)
                .build();
    }

    @Override
    public AuthResponse registerClient(ClientRequest clientRequest) {
        String jwt = authServicePort.register(userRequestMapper.toUser(clientRequest));
        return AuthResponse.builder()
                .token(jwt)
                .build();
    }

    @Override
    public AuthResponse registerEmployee(EmployeeRequest employeeRequest) {
        String jwt = authServicePort.register(userRequestMapper.toUser(employeeRequest));
        return AuthResponse.builder()
                .token(jwt)
                .build();
    }

    @Override
    public AuthResponse authenticate(UserAuthRequest userAuthRequest) {

        User user = userServicePort.getUserByEmail(userAuthRequest.getEmail());
        String jwt = authServicePort.authenticate(user);

        return AuthResponse.builder()
                .token(jwt)
                .build();
    }
}
