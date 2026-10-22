package tw.sungo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import tw.sungo.model.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {
 java.util.List<Product> findAllByOrderBySortOrderAscIdDesc();
}
