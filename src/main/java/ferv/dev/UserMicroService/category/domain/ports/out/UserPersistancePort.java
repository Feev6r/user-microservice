package ferv.dev.UserMicroService.category.domain.ports.out;

import ferv.dev.UserMicroService.category.domain.models.User;

import java.util.List;

public interface UserPersistancePort {

    User getUserByEmail(String email);
    void saveUser(User user);
    User getUser(Long userId); //usuario personal
    List<User> getAllUser(); //todo los usuarios - solo admin

}
