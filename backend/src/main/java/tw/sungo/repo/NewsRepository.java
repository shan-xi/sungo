package tw.sungo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import tw.sungo.model.NewsArticle;
public interface NewsRepository extends JpaRepository<NewsArticle, Long> {
 java.util.List<NewsArticle> findAllByOrderByPublishedDateDescIdDesc();
}
