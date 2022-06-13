package Car_dealership.Cars.Services;

import Car_dealership.Cars.Models.Cars_dealership;
import Car_dealership.Cars.Repositories.Cars_dealership_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cars_dealership_Service {
    @Autowired
    private Cars_dealership_Repository cars_dealership_repository;
    public Cars_dealership saveCars_dealership(Cars_dealership cars_dealership){
        return cars_dealership_repository.save(cars_dealership);
    }
    public void deleteCars_dealership(Long id){
        cars_dealership_repository.deleteById(id);
    }
    public Cars_dealership searchCars_dealership(Long id){
        return cars_dealership_repository.findById(id).get();
    }
    public List<Cars_dealership> getCars_dealership(){
        return cars_dealership_repository.findAll();
    }
}
