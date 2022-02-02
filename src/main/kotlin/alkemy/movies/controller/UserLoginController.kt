package alkemy.movies.controller

import alkemy.movies.dto.UserLoginDto
import alkemy.movies.model.UserLogin
import alkemy.movies.service.UserLoginService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController("userController")
@RequestMapping("users")
@Tag(name = "Users", description = "Users API")
class UserLoginController (service: UserLoginService) :CrudController<UserLoginDto, UserLogin,Long>(service){
}