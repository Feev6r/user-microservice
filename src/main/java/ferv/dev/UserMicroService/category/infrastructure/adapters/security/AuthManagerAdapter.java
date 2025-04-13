package ferv.dev.UserMicroService.category.infrastructure.adapters.security;

import ferv.dev.UserMicroService.category.domain.models.User;
import ferv.dev.UserMicroService.category.domain.ports.out.AuthManagerPort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class AuthManagerAdapter implements AuthManagerPort {

    private final AuthenticationManager authenticationManager;

    public AuthManagerAdapter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void authenticate(User user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getId(),
                user.getPassword()
        ));
    }

}
