package ottua.cdckafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ottua.cdckafka.entity.SeatByDateInventory;

import java.util.UUID;

@Repository
public interface SeatRepository extends JpaRepository<SeatByDateInventory, UUID> {
}
