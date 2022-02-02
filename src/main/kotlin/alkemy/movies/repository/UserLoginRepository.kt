package alkemy.movies.repository

import alkemy.movies.model.UserLogin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserLoginRepository : JpaRepository<UserLogin,Long> {
}