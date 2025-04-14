package ferv.dev.UserMicroService.category.domain.usecases;

import ferv.dev.UserMicroService.category.domain.models.User;
import ferv.dev.UserMicroService.category.domain.ports.in.UserServicePort;
import ferv.dev.UserMicroService.category.domain.ports.out.TokenServicePort;
import ferv.dev.UserMicroService.category.domain.ports.out.UserPersistencePort;

import java.util.List;

public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;
    private final TokenServicePort tokenServicePort;

    public UserUseCase(UserPersistencePort userPersistencePort, TokenServicePort tokenServicePort) {
        this.userPersistencePort = userPersistencePort;
        this.tokenServicePort = tokenServicePort;
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
    public User getUserBySecurityContext() {
        Long userId = tokenServicePort.getUserIdBySecurityContext();
        return userPersistencePort.getUser(userId);
    }

    @Override
    public User getUser(Long id) {
        return userPersistencePort.getUser(id);
    }

    @Override
    public List<User> getAllUser(Integer size, Integer page, boolean orderAsc) {
        return userPersistencePort.getAllUser(size, page, orderAsc);
    }
}
