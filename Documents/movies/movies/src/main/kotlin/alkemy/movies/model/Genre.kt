package alkemy.movies.model

import org.hibernate.annotations.SQLDelete
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "genres",schema = "movies_disney")
@SQLDelete(sql = "UPDATE Genre g SET g.available = true WHERE g.id = ?")
class Genre(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    @Column(length= 30, nullable = false)
    private var title: String,
    @OneToMany(mappedBy = "genre")
    private var movies: List<Movie>? = null,
    @Column(nullable = false)
    private var available: Boolean,

    @CreatedDate
    private var createDate: LocalDate,
    @LastModifiedDate
    private var modificationDate: LocalDate
){}