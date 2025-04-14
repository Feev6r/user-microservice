package ferv.dev.UserMicroService.category.infrastructure.endpoints.res;

import ferv.dev.UserMicroService.category.application.dto.request.ClientRequest;
import ferv.dev.UserMicroService.category.application.dto.request.EmployeeRequest;
import ferv.dev.UserMicroService.category.application.dto.request.OwnerRequest;
import ferv.dev.UserMicroService.category.application.dto.request.UserAuthRequest;
import ferv.dev.UserMicroService.category.application.dto.response.AuthResponse;
import ferv.dev.UserMicroService.category.application.services.AuthApplicationService;
import ferv.dev.UserMicroService.commons.configurations.utils.constants.ApiPaths;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ApiPaths.Auth.BASE)
@RequiredArgsConstructor
public class AuthController {

    private final AuthApplicationService authApplicationService;

    @PostMapping(ApiPaths.Auth.ADMIN)
    public ResponseEntity<AuthResponse> registerAdmin(@Valid @RequestBody OwnerRequest adminRequest){
        return ResponseEntity.ok(authApplicationService.registerOwner(adminRequest));
    }

    @PostMapping(ApiPaths.Auth.OWNER)
    public ResponseEntity<AuthResponse> registerOwner(@Valid @RequestBody OwnerRequest ownerRequest){
        return ResponseEntity.ok(authApplicationService.registerOwner(ownerRequest));
    }

    @PostMapping(ApiPaths.Auth.EMPLOYEE)
    public ResponseEntity<AuthResponse> registerEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        return ResponseEntity.ok(authApplicationService.registerEmployee(employeeRequest));
    }

    @PostMapping(ApiPaths.Auth.CLIENT)
    public ResponseEntity<AuthResponse> registerClient(@Valid @RequestBody ClientRequest clientRequest){
        return ResponseEntity.ok(authApplicationService.registerClient(clientRequest));
    }

    @PostMapping(ApiPaths.Auth.AUTHENTICATE)
    public ResponseEntity<AuthResponse> authenticate(@Valid @RequestBody UserAuthRequest userAuthRequest){
        return ResponseEntity.ok(authApplicationService.authenticate(userAuthRequest));
    }
}
