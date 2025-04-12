package ferv.dev.UserMicroService.category.domain.ports.out;

import ferv.dev.UserMicroService.category.domain.models.User;

//consume codigo de jwt en general
public interface TokenServicePort {

    String extractUsername(String token);
    String getUserEmailBySecurityContext();
    String generateToken(User user);
    boolean isTokenValid(String token, String username);

}
