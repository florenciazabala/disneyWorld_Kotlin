package alkemy.movies.service

import alkemy.movies.dto.MovieDto
import alkemy.movies.mapper.MovieMapper
import alkemy.movies.model.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service("movieService")
class MovieService(
    repository: JpaRepository<Movie, Long>,
    mapper: MovieMapper
) : AbstractService<MovieDto,Movie,Long>(repository,mapper){
}