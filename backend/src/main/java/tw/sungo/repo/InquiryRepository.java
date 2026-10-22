package tw.sungo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import tw.sungo.model.Inquiry;
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
}
