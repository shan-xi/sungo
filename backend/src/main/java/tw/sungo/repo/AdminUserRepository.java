package tw.sungo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import tw.sungo.model.AdminUser;
import java.util.Optional;
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
 Optional<AdminUser> findByUsername(String username);
}
