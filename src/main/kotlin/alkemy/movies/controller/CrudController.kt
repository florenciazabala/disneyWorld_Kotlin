package alkemy.movies.controller

import alkemy.movies.service.AbstractService
import com.prisma.api.controller.operation.Get
import com.prisma.api.controller.operation.GetById
import com.prisma.api.controller.operation.Post
import com.prisma.api.controller.operation.Put
import alkemy.movies.controller.operation.Delete


open class CrudController <D, E : Any, ID : Any>(
    override val service: AbstractService<D, E, ID>,
) : GetById<D, E, ID>,
    Get<D, E, ID>,
    Post<D, E, ID>,
    Put<D, E, ID>,
    Delete<D, E, ID>