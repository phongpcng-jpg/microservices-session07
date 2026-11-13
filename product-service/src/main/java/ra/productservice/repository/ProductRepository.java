package ra.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
