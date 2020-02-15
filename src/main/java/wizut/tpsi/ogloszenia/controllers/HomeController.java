/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.ogloszenia.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wizut.tpsi.ogloszenia.jpa.BodyStyle;
import wizut.tpsi.ogloszenia.jpa.CarManufacturer;
import wizut.tpsi.ogloszenia.jpa.CarModel;
import wizut.tpsi.ogloszenia.jpa.FuelType;
import wizut.tpsi.ogloszenia.services.OffersService;

@Controller
public class HomeController {
    @Autowired
    OffersService os;

    @GetMapping("/")
    public String home(Model model) {
        
        List<CarManufacturer> carManufacturers = os.getCarManufacturers();
        model.addAttribute("carManufacturers", carManufacturers);
    
        List<BodyStyle> bodyStyle = os.getBodyStyles();
        model.addAttribute("bodyStyle", bodyStyle);
        
        List<FuelType> fuelType = os.getFuelTypes();
        model.addAttribute("fuelType", fuelType);
        
        List<CarModel> carModel = os.getCarModels(3);
        model.addAttribute("carModel", carModel);     
        
        model.addAttribute("carModel2", os.getModel(2).getManufacturer().getName());
        model.addAttribute("getManufacturer2", os.getModel(2).getName());
        
        return "offersList";
    }
}
