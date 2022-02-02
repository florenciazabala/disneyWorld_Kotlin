package alkemy.movies.mapper

import alkemy.movies.dto.MovieDto
import alkemy.movies.model.Movie
import org.springframework.stereotype.Component

@Component("movieMapper")
class MovieMapper : AbstractMapper<MovieDto, Movie>{
    override fun toEntity(dto: MovieDto) =
        Movie(
            id = dto.id,
            title = dto.title,
            creationDate = dto.creationDate,
            score = dto.score,
            characters = null,
            genre = null,
            available = dto.available
        )

    override fun toDto(entity: Movie) =
        MovieDto(
            id = entity.id,
            title = entity.title,
            creationDate = entity.creationDate,
            score = entity.score,
            characters = null,
            genre = null,
            available = entity.available
        )
}