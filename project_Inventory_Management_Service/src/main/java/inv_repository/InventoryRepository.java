package inv_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Main.Model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
