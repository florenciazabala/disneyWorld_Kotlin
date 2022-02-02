package alkemy.movies.mapper

import alkemy.movies.dto.GenreDto
import alkemy.movies.model.Genre
import org.springframework.stereotype.Component

@Component("genreMapper")
class GenreMapper : AbstractMapper<GenreDto, Genre>{
    override fun toEntity(dto: GenreDto) =
        Genre(
            id = dto.id,
            name = dto.name,
            available = dto.available,
            movies = null
        )

    override fun toDto(entity: Genre) =
        GenreDto(
            id = entity.id,
            name = entity.name,
            available = entity.available,
            movies = null
        )
}