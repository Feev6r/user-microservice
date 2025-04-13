package ferv.dev.UserMicroService.category.domain.ports.out;

import ferv.dev.UserMicroService.category.domain.models.User;

public interface AuthManagerPort {
    void authenticate(User user);
}
