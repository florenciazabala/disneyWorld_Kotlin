package alkemy.movies.dto


data class GenreDto(

    val id: Long? = null,
    val name: String = "",
    val movies: List<MovieDto>? = null,
    val available: Boolean = true,

) {
}