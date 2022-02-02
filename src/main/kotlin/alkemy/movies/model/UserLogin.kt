package alkemy.movies.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.SQLDelete
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "users",schema = "movies_disney")
@SQLDelete(sql = "UPDATE UserLogin u SET u.available = false WHERE u.id = ?")
class UserLogin (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false)
    val mail: String = "",
    @Column(nullable = false)
    val username: String = "",
    @Column(nullable = false)
    val password: String = "",

    @JsonIgnore
    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createDate: LocalDate? = null,
    @JsonIgnore
    @LastModifiedDate
    var modificationDate: LocalDate? = null
){}