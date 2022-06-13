package Car_dealership.Cars.Repositories;

import Car_dealership.Cars.Models.Cars_dealership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cars_dealership_Repository extends JpaRepository<Cars_dealership, Long> {
}
