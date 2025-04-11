package ferv.dev.UserMicroService.category.infrastructure.adapters.persistance;

import ferv.dev.UserMicroService.category.domain.models.User;
import ferv.dev.UserMicroService.category.domain.ports.out.UserPersistancePort;
import ferv.dev.UserMicroService.category.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserAdapter implements UserPersistancePort {

    private final UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUser(Long userId) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return List.of();
    }

//    @Override
//    public User getUserByEmail(String email) {
//        return userEntityMapper.toUser(userRepository.findByEmail(email).orElse(null));
//    }
//
//    @Override
//    public User getUser(Long userId) {
//        return userEntityMapper.toUser(userRepository.findById(userId).orElse(null));
//    }
//
//    @Override
//    public void saveUser(User user) {
//        userRepository.save(userEntityMapper.toEntity(user));
//    }
//
//    @Override
//    public List<User> getAllUser() {
//        return userEntityMapper.toUserList(userRepository.findAll());
//    }
}
