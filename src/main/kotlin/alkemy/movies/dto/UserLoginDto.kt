package alkemy.movies.dto


data class UserLoginDto (
    val id: Long? = null,
    val mail: String = "",
    val username: String = "",
    val password: String = "",

        ){
}