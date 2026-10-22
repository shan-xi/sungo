package tw.sungo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import tw.sungo.model.SiteSetting;
public interface SettingRepository extends JpaRepository<SiteSetting, String> {
}
