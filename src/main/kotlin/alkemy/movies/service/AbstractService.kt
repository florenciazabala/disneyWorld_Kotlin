package alkemy.movies.service

import alkemy.movies.exceptions.ResourceNotFoundException
import alkemy.movies.mapper.AbstractMapper
import com.fasterxml.jackson.databind.util.Converter
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.findByIdOrNull

abstract class AbstractService<D, E :Any, ID: Any> (
    private val repository: PagingAndSortingRepository<E,ID>,
    private val mapper: AbstractMapper<D, E>
        ){


    //  .findAll(pageable)
    fun findAll(pageable: Pageable) =
        repository
            .findAll(pageable)
          //  .findAll(pageable).content.map { e -> mapper.toDto(e) }
          //  .findAll(pageable).content.map {e -> Converter<e,> }

    /*fun findAll(pageable: Pageable)  =
        repository.findAll(pageable).map(Converter<E,D>())*/




    fun findById(id : ID) =
        repository
            .findByIdOrNull(id)
            ?: throw ResourceNotFoundException("Resource with id $id not found")

    fun save(dto : D) =
        mapper
            .toEntity(dto)
            .persist()

    fun deleteById(id: ID) =
        repository
            .deleteById(id)

    private fun E.persist() =
        repository
            .save(this)
}