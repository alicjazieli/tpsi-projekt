/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.ogloszenia.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wizut.tpsi.ogloszenia.jpa.BodyStyle;
import wizut.tpsi.ogloszenia.jpa.CarManufacturer;
import wizut.tpsi.ogloszenia.jpa.CarModel;
import wizut.tpsi.ogloszenia.jpa.FuelType;
import wizut.tpsi.ogloszenia.jpa.Offer;
import wizut.tpsi.ogloszenia.services.OffersService;
import wizut.tpsi.ogloszenia.web.OfferFilter;

@Controller
public class HomeController {
    @Autowired
    OffersService os;

    @GetMapping("/")
    public String home(Model model, OfferFilter offerFilter) {
        
        List<CarManufacturer> carManufacturers = os.getCarManufacturers();
        List<CarModel> carModels = os.getCarModels(3);

        List<Offer> offers;

        if(offerFilter.getManufacturerId()!=0) {
            offers = os.getOffersByManufacturer(offerFilter.getManufacturerId());
        } else {
            offers = os.getOffers();
        }

        model.addAttribute("carManufacturers", carManufacturers);
        model.addAttribute("carModels", carModels);
        model.addAttribute("offers", offers);

    
        List<BodyStyle> bodyStyle = os.getBodyStyles();
        model.addAttribute("bodyStyle", bodyStyle);
        
        List<FuelType> fuelType = os.getFuelTypes();
        model.addAttribute("fuelType", fuelType);

        List<Offer> carOffer = os.getOffersByModel(10);
        model.addAttribute("carOffer", carOffer);
        
        List<Offer> carOfferManuf = os.getOffersByManufacturer(3);
        model.addAttribute("carOfferManuf", carOfferManuf);           
        
        model.addAttribute("carModel2", os.getModel(2).getManufacturer().getName());
        model.addAttribute("getManufacturer2", os.getModel(2).getName());

        Offer oneOffer = os.getOffer(1);
        model.addAttribute("oneOffer", oneOffer);
        
    return "offersList";
    }
    @GetMapping("/offer/{id}")
        public String offerDetails(Model model, @PathVariable("id") Integer id) {
            Offer offer = os.getOffer(id);
            model.addAttribute("offer", offer);
            return "offerDetails";
        }
        
    @GetMapping("/newoffer")
        public String newOfferForm(Model model, @Valid Offer offer, BindingResult binding) {
            if(binding.hasErrors()) {
                List<CarModel> carModels = os.getCarModels();
                List<BodyStyle> bodyStyles = os.getBodyStyles();
                List<FuelType> fuelTypes = os.getFuelTypes();

                model.addAttribute("carModels", carModels);
                model.addAttribute("bodyStyles", bodyStyles);
                model.addAttribute("fuelTypes", fuelTypes);
                
            return "offerForm";
        }
        offer = os.createOffer(offer);

    return "redirect:/offer/" + offer.getId();
}
}
