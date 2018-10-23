package pl.manager.apiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.manager.apiary.model.Family;
import pl.manager.apiary.service.family.FamilyService;
import pl.manager.apiary.utils.ApiaryConst;

@Controller
public class FamilyController {

	private FamilyService familyService;

	@Autowired
	@Qualifier(value = "familyService")
	public void setFamilyService(FamilyService familyService) {
		this.familyService = familyService;
	}

	@RequestMapping(value = "families", method = RequestMethod.GET)
	public String listFamilies(Model model) {
		model.addAttribute("listFamilies", familyService.listFamilies());
		return "families";
	}

	@RequestMapping(value = "family/add", method = RequestMethod.POST)
	public String addFamily(Model model) {
		Family f = new Family();
		model.addAttribute("operation", ApiaryConst.ADD);
		model.addAttribute("family", f);
		return "families";
	}

	@RequestMapping(value = "family/edit/{id}")
	public String editFamily(@PathVariable("id") int id, Model model) {
		model.addAttribute("family", familyService.getFamilyById(id));
		model.addAttribute("operation", ApiaryConst.EDIT);
		return "family";
	}

	@RequestMapping(value = { "family/save", "family/edit/save" })
	public String saveFamily(@ModelAttribute("family") Family f) {
		if (f.getId() > 0)
			this.familyService.updateFamily(f);
		else
			this.familyService.addFamily(f);
		return "redirect:/";
	}

	@RequestMapping(value = "family/remove/{id}")
	public String removeFamily(@PathVariable("id") int id) {
		this.familyService.removeFamily(id);
		return "redirect:/";
	}

}
