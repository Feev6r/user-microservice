package ferv.dev.UserMicroService.category.infrastructure.endpoints.res;


import ferv.dev.UserMicroService.category.application.dto.response.UserContactInfoResponse;
import ferv.dev.UserMicroService.category.application.dto.response.UserResponse;
import ferv.dev.UserMicroService.category.application.services.UserApplicationService;
import ferv.dev.UserMicroService.commons.configurations.utils.constants.ApiPaths;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(ApiPaths.User.BASE)
@RequiredArgsConstructor
public class UserController {

    private final UserApplicationService userApplicationService;

    @GetMapping(ApiPaths.User.GET)
    public ResponseEntity<UserResponse> getUser(){
        return ResponseEntity.ok(userApplicationService.getUser());
    }

    @GetMapping(ApiPaths.User.GET_BY_ID)
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userApplicationService.getUserById(id));
    }

    @GetMapping(ApiPaths.User.GET_CONTACT)
    public ResponseEntity<UserContactInfoResponse> getContactUserById(@PathVariable Long id){
        return ResponseEntity.ok(userApplicationService.getUserContact(id));
    }

    @GetMapping(ApiPaths.User.ALL)
    public ResponseEntity<List<UserResponse>> getAll(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "5") @Min(1) int size,
            @RequestParam(defaultValue = "false") boolean orderAsc) {

        return ResponseEntity.ok(userApplicationService.getAllUser(size, page, orderAsc));
    }



}
