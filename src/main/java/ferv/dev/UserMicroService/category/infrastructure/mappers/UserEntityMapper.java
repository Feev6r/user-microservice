package ferv.dev.UserMicroService.category.infrastructure.mappers;

import ferv.dev.UserMicroService.category.domain.models.User;
import ferv.dev.UserMicroService.category.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper{

    UserEntity toEntity(User user);

}
