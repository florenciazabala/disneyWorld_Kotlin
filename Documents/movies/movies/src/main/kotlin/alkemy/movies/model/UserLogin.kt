package alkemy.movies.model

import org.hibernate.annotations.SQLDelete
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "users",schema = "movies_disney")
@SQLDelete(sql = "UPDATE User u SET u.available = true WHERE u.id = ?")
class UserLogin (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    @Column(nullable = false)
    private var mail: String,
    @Column(nullable = false)
    private var username: String,
    @Column(nullable = false)
    private var password: String,

    @CreatedDate
    private var createDate: LocalDate,
    @LastModifiedDate
    private var modificationDate: LocalDate
){}