package ferv.dev.UserMicroService.category.infrastructure.adapters.persistance;

import ferv.dev.UserMicroService.category.domain.models.User;
import ferv.dev.UserMicroService.category.domain.ports.out.UserPersistencePort;
import ferv.dev.UserMicroService.category.infrastructure.exeptionshandler.exeptions.UserNotFound;
import ferv.dev.UserMicroService.category.infrastructure.mappers.UserEntityMapper;
import ferv.dev.UserMicroService.category.infrastructure.repositories.mysql.UserRepository;
import ferv.dev.UserMicroService.commons.configurations.utils.constants.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User getUserByEmail(String email) {
        return userEntityMapper.toUser(userRepository.findByEmail(email)
                .orElseThrow(UserNotFound::new));
    }

    @Override
    public User getUser(Long userId) {
        return userEntityMapper.toUser(userRepository.findById(userId)
                .orElseThrow(UserNotFound::new));
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public List<User> getAllUser(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;
        if (orderAsc) pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_FIRSTNAME).ascending());
        else pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_FIRSTNAME).descending());
        return userEntityMapper.toUserList(userRepository.findAll(pagination).getContent());
    }
}
