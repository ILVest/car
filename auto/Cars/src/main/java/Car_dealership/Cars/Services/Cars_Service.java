package Car_dealership.Cars.Services;

import Car_dealership.Cars.Models.Cars;
import Car_dealership.Cars.Repositories.Cars_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cars_Service {
    @Autowired
    private Cars_Repository cars_repository;
    public Cars saveCars(Cars cars){
        return cars_repository.save(cars);
    }
    public void deleteCars(Long id){
        cars_repository.deleteById(id);
    }
    public Cars searchCars(Long id){
        return cars_repository.findById(id).get();
    }
    public List<Cars> getCars(){
        return cars_repository.findAll();
    }

}
