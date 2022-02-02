package alkemy.movies.mapper

import alkemy.movies.dto.UserLoginDto
import alkemy.movies.model.UserLogin
import org.springframework.stereotype.Component

@Component("userLoginMapper")
class UserLoginMapper: AbstractMapper<UserLoginDto, UserLogin> {
    override fun toEntity(dto: UserLoginDto) =
        UserLogin(
            id = dto.id,
            mail = dto.mail,
            username = dto.username,
            password = dto.password
        )

    override fun toDto(entity: UserLogin) =
        UserLoginDto(
            id = entity.id,
            mail = entity.mail,
            username = entity.username,
            password = entity.password
        )
}