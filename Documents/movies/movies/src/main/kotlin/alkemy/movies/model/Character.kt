package alkemy.movies.model

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
@SQLDelete(sql = "UPDATE Character c SET c.available = true WHERE c.id = ?")
class Character (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    @Column(length = 30,nullable = false)
    private var name: String,
    private var age: Int?,
    private var weight: Double?,
    @Column(length = 30,nullable = false)
    private var story: String,
    @ManyToMany(mappedBy = "characters")
    @JsonIgnoreProperties("characters")
    private var movies: List<Movie>? = null,
    @Column(nullable = false)
    private var available: Boolean,

    @CreatedDate
    private var createDate: LocalDate,
    @LastModifiedDate
    private var modificationDate: LocalDate
    ){
}