package org.pi.web;

import org.pi.business.service.ServiceService;
import org.pi.model.Service;
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
@RequestMapping("/service")
public class ServiceController {
	
    @Autowired
    private  ServiceService serviceService;

    @RequestMapping("")
    public ModelAndView showServicePage(@RequestParam(value ="p",defaultValue = "0")  Integer page) {
        ModelAndView modelAndView = new ModelAndView("afficherService");

        Page<Service> services = serviceService.getAllService(PageRequest.of(page, 8));
        modelAndView.addObject("services", services);
        modelAndView.addObject("currentPage", page);
        return modelAndView;
    }
    
    @RequestMapping(value = "/addService",method = RequestMethod.GET)
    public String addServiceForm(Model model)
    {
    	Service service = new Service();
    	model.addAttribute("service",service);
    	return "addService";
    }
    
    @RequestMapping(value = "/addService",method = RequestMethod.POST)
    public String addService(Service service)
    {
    	serviceService.ajouterService(service);
    	return "redirect:/service";
    }
    
    @RequestMapping(value = "/refuser",method = RequestMethod.GET)
    public String supprimerService(@RequestParam(value = "q") Integer serviceId)
    {
    	Service service = serviceService.chercherService(serviceId);
    	service.setEtat("Refuser");
    	serviceService.ajouterService(service);
    	return "redirect:/service";
    }
    
    @RequestMapping(value = "/accepter",method = RequestMethod.GET)
    public String editerMateriel(@RequestParam(value = "q") Integer serviceId)
    {
    	Service service = serviceService.chercherService(serviceId);
    	service.setEtat("Accepte");
    	serviceService.ajouterService(service);
    	return "redirect:/service";
    }
}
