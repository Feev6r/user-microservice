package ferv.dev.UserMicroService.category.domain.usecases;

import ferv.dev.UserMicroService.category.domain.models.User;
import ferv.dev.UserMicroService.category.domain.ports.in.UserServicePort;
import ferv.dev.UserMicroService.category.domain.ports.out.UserPersistencePort;

import java.util.List;

public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public User getUserByEmail(String email) {
        return userPersistencePort.getUserByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        userPersistencePort.saveUser(user);
    }

    @Override
    public User getUser(Long userId) {
        return userPersistencePort.getUser(userId);
    }

    @Override
    public List<User> getAllUser(Integer size, Integer page, boolean orderAsc) {
        return userPersistencePort.getAllUser(size, page, orderAsc);
    }
}
