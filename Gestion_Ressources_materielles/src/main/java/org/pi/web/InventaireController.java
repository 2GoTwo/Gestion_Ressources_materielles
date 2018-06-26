package org.pi.web;

import org.pi.business.inventaire.InventaireService;
import org.pi.model.Inventaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/inventaire")
public class InventaireController {
	
    @Autowired
    private  InventaireService inventaireService;

    @RequestMapping("")
    public ModelAndView showPersonsPage(@RequestParam(value ="p",defaultValue = "0")  Integer page) {
        ModelAndView modelAndView = new ModelAndView("afficherInventaire");

        Page<Inventaire> inventaire = inventaireService.getAllInventaire(PageRequest.of(page, 8));
        modelAndView.addObject("inventaire", inventaire);
        modelAndView.addObject("currentPage", page);
        return modelAndView;
    }
    
    @RequestMapping(value = "/addMateriel",method = RequestMethod.GET)
    public String addMaterielForm(Model model)
    {
    	Inventaire inventaire = new Inventaire();
    	model.addAttribute("inventaire",inventaire);
    	return "addMateriel";
    }
    
    @RequestMapping(value = "/addMateriel",method = RequestMethod.POST)
    public String addMateriel(Inventaire inventaire)
    {
    	inventaireService.ajouterInventaire(inventaire);
    	return "redirect:/inventaire";
    }
    
    @RequestMapping(value = "/supprimer",method = RequestMethod.GET)
    public String supprimerMateriel(@RequestParam(value = "q") Integer inventaireId)
    {
    	inventaireService.supprimerInventaire(inventaireId);
    	return "redirect:/inventaire";
    }
    
    @RequestMapping(value = "/editer",method = RequestMethod.GET)
    public String editerMateriel(@RequestParam(value = "q") Integer inventaireId)
    {
    	return "redirect:/inventaire";
    }
}
