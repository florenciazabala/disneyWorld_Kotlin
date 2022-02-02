package alkemy.movies.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.SQLDelete
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "genres",schema = "movies_disney")
@SQLDelete(sql = "UPDATE Genre g SET g.available = true WHERE g.id = ?")
class Genre(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(length= 30, nullable = false)
    val name: String = "",
    @OneToMany(mappedBy = "genre")
    val movies: List<Movie>? = null,
    @Column(nullable = false)
    val available: Boolean = true,

    @JsonIgnore
    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createDate: LocalDateTime? = null,
    @JsonIgnore
    @LastModifiedDate
    var modificationDate: LocalDateTime ? = null
){}