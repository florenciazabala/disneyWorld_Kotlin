package alkemy.movies.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.SQLDelete
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "characteres",schema = "movies_disney")
@SQLDelete(sql = "UPDATE Character c SET c.available = false WHERE c.id = ?")
class Character(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(length = 30,nullable = false)
    val name: String = "",
    val age: Int? = null,
    val weight: Double? = null,
    @Column(length = 30,nullable = false)
    val story: String = "",
    @ManyToMany(mappedBy = "characters")
    @JsonIgnoreProperties("characters")
    val movies: MutableList<Movie>? =  null,
    @Column(nullable = false)
    val available: Boolean = true,

    @JsonIgnore
    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createDate: LocalDate? = null,
    @LastModifiedDate
    var modificationDate: LocalDate? = null
    ){

}