package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Servises.CarServises;

@Controller
public class CarController {

    private CarServises carServises;

    @Autowired
    public CarController(CarServises carServises) {
        this.carServises = carServises;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        model.addAttribute("cars", carServises.getCarList(count));
        return "cars";
    }
}
