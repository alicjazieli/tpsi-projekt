/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.ogloszenia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wizut.tpsi.ogloszenia.services.OffersService;

@Controller
public class HomeController {
    @Autowired
    OffersService os;

    @GetMapping("/")
    public String home(Model model) {
        
        model.addAttribute("carModel2", os.getModel(3));
        return "offersList";
    }
}
