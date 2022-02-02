package alkemy.movies.mapper

import alkemy.movies.dto.CharacterDto
import alkemy.movies.model.Character
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import kotlin.streams.toList

@Component("characterMapper")
class CharacterMapper : AbstractMapper<CharacterDto, Character>{

    @Autowired
    val movieMapper = MovieMapper()


    override fun toEntity(dto: CharacterDto) =
        Character(
            id = dto.id,
            name = dto.name,
            age = dto.age,
            weight = dto.weight,
            story = dto.story,
            available = dto.available,
            movies = null
            )


    override fun toDto(entity: Character) =
        CharacterDto(
            id = entity.id,
            name = entity.name,
            age = entity.age,
            weight = entity.weight,
            story = entity.story,
            available = entity.available,
            movies = entity.movies!!.stream().map{ m -> "http://localhost:8090/movies_alkemy/movies/"+m.id }.toList()
        )
}


