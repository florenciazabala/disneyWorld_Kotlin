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
@SQLDelete(sql = "UPDATE Movie m SET m.available = false WHERE m.id = ?")
class Movie(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false)
    val title: String = "",
    @Column(nullable = false)
    val creationDate: LocalDate = LocalDate.now(),
    @Column(nullable = false)
    val score: Int = 0,
    @JoinTable(name = "movies_characters",
        joinColumns = [JoinColumn(name = "FK_MOVIE")],
        inverseJoinColumns = [JoinColumn(name = "FK_CHARACTER")])
    @ManyToMany(cascade = [CascadeType.ALL])
    val characters: List<Character>? = null,
    @JoinColumn
    @ManyToOne
    val genre :Genre? = Genre(),
    @Column(nullable = false)
    val available: Boolean = true,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createDate: LocalDate? = null,
    @LastModifiedDate
    var modificationDate: LocalDate? = null
){

}