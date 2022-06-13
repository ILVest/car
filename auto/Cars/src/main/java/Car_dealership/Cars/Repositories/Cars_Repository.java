package Car_dealership.Cars.Repositories;

import Car_dealership.Cars.Models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cars_Repository extends JpaRepository<Cars, Long> {
}