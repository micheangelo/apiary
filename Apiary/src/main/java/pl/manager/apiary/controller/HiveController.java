package pl.manager.apiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.manager.apiary.model.Hive;
import pl.manager.apiary.service.hive.HiveService;
import pl.manager.apiary.utils.ApiaryConst;

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

	@RequestMapping(value = "hive/add", method = RequestMethod.POST)
	public String addHive(Model model) {
		Hive h = new Hive();
		model.addAttribute("operation", ApiaryConst.ADD);
		model.addAttribute("hive", h);
		return "hives";
	}

	@RequestMapping(value = "hive/edit/{id}")
	public String editHive(@PathVariable("id") int id, Model model) {
		model.addAttribute("operation", ApiaryConst.EDIT);
		model.addAttribute("hive", hiveService.getHiveById(id));
		return "hive";
	}

	@RequestMapping(value = { "hive/save", "hive/edit/save" })
	public String saveHive(@ModelAttribute("hive") Hive h) {
		if(h.getId() >0)
			hiveService.updateHive(h);
		else
			hiveService.addHive(h);
		return "redirect:/";
	}
	
	@RequestMapping(value= {"hive/remove/{id}"})
	public String removeHive(@PathVariable("id") int id) {
		hiveService.removeHive(id);
		return "redirect:/";
	}

}
