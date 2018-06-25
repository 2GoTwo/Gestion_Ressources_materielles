package org.pi.web;

import java.util.Optional;

import org.pi.business.inventaire.InventaireService;
import org.pi.model.Inventaire;
import org.pi.utils.Pager;
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
	private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = {5, 10, 20};

    @Autowired
    private  InventaireService inventaireService;

    

    /**
     * Handles all requests
     *
     * @param pageSize
     * @param page
     * @return model and view
     */
    @RequestMapping("")
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("afficherInventaire");

        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Inventaire> inventaire = inventaireService.getAllInventaire(PageRequest.of(evalPage, evalPageSize));
        Pager pager = new Pager(inventaire.getTotalPages(), inventaire.getNumber(), BUTTONS_TO_SHOW);

        modelAndView.addObject("inventaire", inventaire);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
    
    @RequestMapping(value = "/addMateriel",method = RequestMethod.GET)
    public String addMateriel(Model model)
    {
    	return "addMateriel";
    }
}
