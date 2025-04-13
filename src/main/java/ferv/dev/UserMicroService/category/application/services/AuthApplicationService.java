package ferv.dev.UserMicroService.category.application.services;

import ferv.dev.UserMicroService.category.application.dto.request.ClientRequest;
import ferv.dev.UserMicroService.category.application.dto.request.EmployeeRequest;
import ferv.dev.UserMicroService.category.application.dto.request.OwnerRequest;
import ferv.dev.UserMicroService.category.application.dto.request.UserAuthRequest;
import ferv.dev.UserMicroService.category.application.dto.response.AuthResponse;

public interface AuthApplicationService {

    AuthResponse registerOwner(OwnerRequest ownerRequest);
    AuthResponse registerClient(ClientRequest clientRequest);
    AuthResponse registerEmployee(EmployeeRequest employeeRequest);
    AuthResponse authenticate(UserAuthRequest userAuthRequest);

}
