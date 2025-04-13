package ferv.dev.UserMicroService.category.infrastructure.endpoints.res;

import ferv.dev.UserMicroService.category.application.dto.request.ClientRequest;
import ferv.dev.UserMicroService.category.application.dto.request.EmployeeRequest;
import ferv.dev.UserMicroService.category.application.dto.request.OwnerRequest;
import ferv.dev.UserMicroService.category.application.dto.request.UserAuthRequest;
import ferv.dev.UserMicroService.category.application.dto.response.AuthResponse;
import ferv.dev.UserMicroService.category.application.services.AuthApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthApplicationService authApplicationService;

    @PostMapping("/admin")
    public ResponseEntity<AuthResponse> registerAdmin(@Valid @RequestBody OwnerRequest adminRequest){
        return ResponseEntity.ok(authApplicationService.registerOwner(adminRequest));
    }

    @PostMapping("/owner")
    public ResponseEntity<AuthResponse> registerOwner(@Valid @RequestBody OwnerRequest ownerRequest){
        return ResponseEntity.ok(authApplicationService.registerOwner(ownerRequest));
    }

    @PostMapping("/employee")
    public ResponseEntity<AuthResponse> registerEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        return ResponseEntity.ok(authApplicationService.registerEmployee(employeeRequest));
    }

    @PostMapping("/client")
    public ResponseEntity<AuthResponse> registerClient(@Valid @RequestBody ClientRequest clientRequest){
        return ResponseEntity.ok(authApplicationService.registerClient(clientRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@Valid @RequestBody UserAuthRequest userAuthRequest){
        return ResponseEntity.ok(authApplicationService.authenticate(userAuthRequest));
    }
}
