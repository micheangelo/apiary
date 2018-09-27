package pl.manager.apiary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.manager.apiary.model.Cost;
import pl.manager.apiary.service.CostService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/*@Autowired
	private Cost newCost;*/
	private CostService costService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired(required=true)
	@Qualifier(value="costService")
	public void setCostService(CostService cs){
		this.costService = cs;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);// + newCost.getDescription();

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCosts(Model model) {
		model.addAttribute("cost", new Cost());
		model.addAttribute("listCosts", this.costService.listCosts());
		return "costs";
	}
}
