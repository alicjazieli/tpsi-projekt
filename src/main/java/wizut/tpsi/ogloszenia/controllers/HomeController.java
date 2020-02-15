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
import org.springframework.web.bind.annotation.PathVariable;
import wizut.tpsi.ogloszenia.jpa.BodyStyle;
import wizut.tpsi.ogloszenia.jpa.CarManufacturer;
import wizut.tpsi.ogloszenia.jpa.CarModel;
import wizut.tpsi.ogloszenia.jpa.FuelType;
import wizut.tpsi.ogloszenia.jpa.Offer;
import wizut.tpsi.ogloszenia.services.OffersService;

@Controller
public class HomeController {
    @Autowired
    OffersService os;

    @GetMapping("/")
    public String home(Model model) {
        
        List<CarManufacturer> carManufacturers = os.getCarManufacturers();
        List<CarModel> carModels = os.getCarModels(3);

        List<Offer> offers = os.getOffers();

        model.addAttribute("carManufacturers", carManufacturers);
        model.addAttribute("carModels", carModels);
        model.addAttribute("offers", offers);

        return "offersList";
    
//        List<BodyStyle> bodyStyle = os.getBodyStyles();
//        model.addAttribute("bodyStyle", bodyStyle);
//        
//        List<FuelType> fuelType = os.getFuelTypes();
//        model.addAttribute("fuelType", fuelType);
//
//        List<Offer> carOffer = os.getOffersByModel(10);
//        model.addAttribute("carOffer", carOffer);
//        
//        List<Offer> carOfferMan = os.getOffersByManufacturer(2);
//        model.addAttribute("carOfferMan", carOfferMan);           
//        
//        model.addAttribute("carModel2", os.getModel(2).getManufacturer().getName());
//        model.addAttribute("getManufacturer2", os.getModel(2).getName());

    }
    @GetMapping("/offer/{id}")
        public String offerDetails(Model model, @PathVariable("id") Integer id) {
            Offer offer = os.getOffer(id);
            model.addAttribute("offer", offer);
            return "offerDetails";
        }
}
