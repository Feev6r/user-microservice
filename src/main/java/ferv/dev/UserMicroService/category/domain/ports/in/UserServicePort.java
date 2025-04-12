package ferv.dev.UserMicroService.category.domain.ports.in;

import ferv.dev.UserMicroService.category.domain.models.User;

import java.util.List;

public interface UserServicePort {
    User getUserByEmail(String email);
    void saveUser(User user);
    User getUser(Long userId);
    List<User> getAllUser(Integer page, Integer size, boolean orderAsc); //todo los usuarios - solo admin


}
