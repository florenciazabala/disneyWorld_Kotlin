package alkemy.movies.service

import alkemy.movies.dto.CharacterDto
import alkemy.movies.mapper.CharacterMapper
import alkemy.movies.model.Character
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service("characterService")
class CharacterService (
    repository: JpaRepository<Character, Long>,
    mapper: CharacterMapper
) : AbstractService<CharacterDto,Character,Long>(repository,mapper){
}