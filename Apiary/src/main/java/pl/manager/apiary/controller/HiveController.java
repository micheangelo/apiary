package pl.manager.apiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.manager.apiary.model.Family;
import pl.manager.apiary.service.hive.HiveService;

/**
 * Hive and family controller
 */
@Controller
public class HiveController {
	private HiveService hiveService;

	@Autowired(required = true)
	@Qualifier(value = "hiveService")
	public void setHiveService(HiveService hiveService) {
		this.hiveService = hiveService;
	}

	@RequestMapping(value = "hives", method = RequestMethod.GET)
	public String listHives(Model model) {
		model.addAttribute("listHives", hiveService.listHives());
		return "hives";
	}

	@RequestMapping(value = "hive/family", method = RequestMethod.GET)
	public String getHiveFamily(@ModelAttribute("family") Family f) {
		return "family";
	}

}
