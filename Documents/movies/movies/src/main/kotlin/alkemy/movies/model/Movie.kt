package alkemy.movies.model

import org.hibernate.annotations.SQLDelete
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "movies",schema = "movies_disney")
@SQLDelete(sql = "UPDATE Movie m SET m.available = true WHERE m.id = ?")
class Movie(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    @Column(nullable = false)
    private var title: String,
    @Column(nullable = false)
    private var creationDate: LocalDate,
    @Column(nullable = false)
    private var score: Int,
    @JoinTable(name = "movies_characters",
        joinColumns = [JoinColumn(name = "FK_MOVIE")],
        inverseJoinColumns = [JoinColumn(name = "FK_CHARACTER")])
    @ManyToMany(cascade = arrayOf(CascadeType.ALL))
    private var characters: List<Character>? = null,
    @JoinColumn
    @ManyToOne
    private var genre :Genre,
    @Column(nullable = false)
    private var available: Boolean,

    @CreatedDate
    private var createDate: LocalDate,
    @LastModifiedDate
    private var modificationDate: LocalDate
){

}