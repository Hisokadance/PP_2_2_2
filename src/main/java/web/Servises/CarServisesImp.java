package web.Servises;

import org.springframework.stereotype.Service;
import web.Model.Car;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CarServisesImp implements CarServises {

    private static final Logger logger = Logger.getLogger(CarServisesImp.class.getName());

    private final List<Car> carList = List.of(new Car("Tesla", "Model X", 2020), new Car("Lada", "Vesta", 2021), new Car("Volga", "Gaz-21", 1956), new Car("Hyundai", "Tucson", 2019), new Car("Toyota", "Corolla", 2015));

    @Override
    public List<Car> getCarList(int count) {
        try {
            logger.log(Level.INFO, "Trying to get car list with count: " + count);
            return carList.stream().limit(count).collect(Collectors.toList());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred while getting car list", e);
            return null;
        }
    }
}