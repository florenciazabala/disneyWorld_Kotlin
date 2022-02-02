package alkemy.movies.service

import alkemy.movies.dto.UserLoginDto
import alkemy.movies.mapper.UserLoginMapper
import alkemy.movies.model.UserLogin
import alkemy.movies.repository.UserLoginRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service("userLoginService")
class UserLoginService (
    repository: JpaRepository<UserLogin,Long>,
    mapper: UserLoginMapper
        ) : AbstractService<UserLoginDto,UserLogin,Long>(repository,mapper){
}