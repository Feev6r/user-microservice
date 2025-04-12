package ferv.dev.UserMicroService.category.domain.usecases;

import ferv.dev.UserMicroService.category.domain.models.User;
import ferv.dev.UserMicroService.category.domain.ports.in.UserServicePort;
import ferv.dev.UserMicroService.category.domain.ports.out.UserPersistancePort;

import java.util.List;

public class UserUseCase implements UserServicePort {

    private final UserPersistancePort userPersistancePort;

    public UserUseCase(UserPersistancePort userPersistancePort) {
        this.userPersistancePort = userPersistancePort;
    }

    @Override
    public User getUserByEmail(String email) {
        return userPersistancePort.getUserByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        userPersistancePort.saveUser(user);
    }

    @Override
    public User getUser(Long userId) {
        return userPersistancePort.getUser(userId);
    }

    @Override
    public List<User> getAllUser(Integer size, Integer page, boolean orderAsc) {
        return userPersistancePort.getAllUser(size, page, orderAsc);
    }
}
