package org.pi.web;

import org.pi.business.demande.DemandeService;
import org.pi.model.Demande;
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
@RequestMapping("/demande")
public class DemandeController  {
	
    @Autowired
    private  DemandeService demandeService;

    @RequestMapping("")
    public ModelAndView showDemandePage(@RequestParam(value ="p",defaultValue = "0")  Integer page) {
        ModelAndView modelAndView = new ModelAndView("afficherDemande");
        Page<Demande> demandes = demandeService.getAllDemande(PageRequest.of(page, 8));
        modelAndView.addObject("demandes", demandes);
        modelAndView.addObject("currentPage", page);
        return modelAndView;
    }
    
    @RequestMapping(value = "/addDemande",method = RequestMethod.GET)
    public String addMaterielForm(Model model)
    {
    	Demande demande  = new Demande();
    	demande.setEtat("Non Traitee");
    	model.addAttribute("demande",demande);
    	return "addDemande";
    }
    
    @RequestMapping(value = "/addDemande",method = RequestMethod.POST)
    public String addMateriel(Demande demande)
    {
    	demandeService.ajouterDemande(demande);
    	return "redirect:/demande";
    }
    
    @RequestMapping(value = "/accepter",method = RequestMethod.GET)
    public String accepterDemande(@RequestParam(value = "q") Integer demandeId)
    {
    	Demande demande = demandeService.chercherDemande(demandeId);
    	demande.setEtat("Traitee");
    	demandeService.ajouterDemande(demande);
    	return "redirect:/demande";
    }
    
    @RequestMapping(value = "/refuser",method = RequestMethod.GET)
    public String refuserDemadne(@RequestParam(value = "q") Integer demandeId)
    {
    	Demande demande = demandeService.chercherDemande(demandeId);
    	demande.setEtat("Non Traitee");
    	demandeService.ajouterDemande(demande);
    	return "redirect:/demande";
    }
}

