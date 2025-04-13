package ferv.dev.UserMicroService.category.domain.ports.out;

import ferv.dev.UserMicroService.category.domain.models.User;

import java.util.List;

public interface UserPersistencePort {

    User getUserByEmail(String email);
    void saveUser(User user);
    User getUser(Long userId); //usuario personal
    List<User> getAllUser(Integer page, Integer size, boolean orderAsc); //todo los usuarios - solo admin

}
