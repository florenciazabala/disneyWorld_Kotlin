package alkemy.movies.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Schema(name = "Character", description = "A character object")
data class CharacterDto(

    @field:Schema(
        description = "The character id",
        example = "1",
        required = false
    )
    val id: Long? = null,

    @field:Schema(
        description = "The character name",
        example = "Mike Wazowsky",
        required = false
    )
    @field:NotNull
    @field:NotEmpty
    val name: String = "",

    @field:Schema(
        description = "The character age",
        example = "34",
        required = false
    )
    @field:NotNull
    @field:NotEmpty
    val age: Int? = null,

    @field:Schema(
        description = "The character weight",
        example = "24.7",
        required = false
    )
    @field:NotNull
    @field:NotEmpty
    val weight: Double? = null,

    @field:Schema(
        description = "The character story",
        example = "He works in... His best fiends is Sullivan",
        required = false
    )
    @field:NotNull
    @field:NotEmpty
    val story: String = "",

    @field:Schema(
        description = "The character story",
        example = "Monsters. Inc",
        required = false
    )
    @field:NotNull
    @field:NotEmpty
    val movies: List<String>?= null,

    @field:Schema(
        description = "The character available",
        example = "true",
        required = false
    )
    @field:NotNull
    @field:NotEmpty
    val available: Boolean = true,

    val createDate: LocalDate? = null,
    val modificationDate: LocalDate? = null
) {
}