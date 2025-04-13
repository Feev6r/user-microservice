package ferv.dev.UserMicroService.category.domain.ports.in;

import ferv.dev.UserMicroService.category.domain.models.Role;
import ferv.dev.UserMicroService.category.domain.models.User;

//se consume seguridad desde afuera
public interface AuthServicePort {

    String register(User user);
    String authenticate(User user);
}
