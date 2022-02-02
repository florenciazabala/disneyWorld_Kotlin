package alkemy.movies.dto

import alkemy.movies.model.Character
import alkemy.movies.model.Genre
import java.time.LocalDate

data class MovieDto (

    val id: Long? = null,
    val title: String = "",
    val creationDate: LocalDate = LocalDate.now(),
    val score: Int = 0,
    val characters: List<CharacterDto>? = null,
    val genre : GenreDto? = GenreDto(),
    val available: Boolean = true,

    ) {}