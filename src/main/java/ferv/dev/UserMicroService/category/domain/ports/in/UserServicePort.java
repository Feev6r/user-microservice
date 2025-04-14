package ferv.dev.UserMicroService.category.domain.ports.in;

import ferv.dev.UserMicroService.category.domain.models.User;

import java.util.List;

public interface UserServicePort {
    User getUserByEmail(String email);
    void saveUser(User user);
    User getUserBySecurityContext();
    User getUser(Long id);
    List<User> getAllUser(Integer size, Integer page,  boolean orderAsc); //todo los usuarios - solo admin


}
