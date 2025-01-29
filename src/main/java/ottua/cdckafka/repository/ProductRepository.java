package ottua.cdckafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ottua.cdckafka.entity.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
