package pl.manager.apiary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.manager.apiary.model.Family;
import pl.manager.apiary.service.family.FamilyService;
import pl.manager.apiary.service.hive.HiveService;
import pl.manager.apiary.utils.ApiaryConst;

@Controller
public class FamilyController {

	private FamilyService familyService;
	private HiveService hiveService;

	@Autowired
	@Qualifier(value = "familyService")
	public void setFamilyService(FamilyService familyService) {
		this.familyService = familyService;
	}

	@Autowired
	@Qualifier(value = "hiveService")
	public void setHiveService(HiveService hiveService) {
		this.hiveService = hiveService;
	}

	@RequestMapping(value = "families", method = RequestMethod.GET)
	public String listFamilies(HttpServletRequest request, ModelMap modelMap) {
		List<Family> families = familyService.listFamilies();
		PagedListHolder<Family> pagedListHolder = new PagedListHolder<>(families);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("listFamilies", pagedListHolder);
		return "families";
	}

	@RequestMapping(value = "family/add", method = RequestMethod.POST)
	public String addFamily(Model model) {
		Family f = new Family();
		model.addAttribute("operation", ApiaryConst.ADD);
		model.addAttribute("family", f);
		model.addAttribute("listHives", this.hiveService.listFreeHives());
		return "family";
	}

	@RequestMapping(value = "family/edit/{id}")
	public String editFamily(@PathVariable("id") int id, Model model) {
		Family f = familyService.getFamilyById(id);
		model.addAttribute("family", f);
		model.addAttribute("operation", ApiaryConst.EDIT);
		int hiveId = 0;
		if (f.getHive() != null)
			hiveId = f.getHive().getId();
		model.addAttribute("listHives", this.hiveService.listFreeAndCurrentHives(hiveId));
		return "family";
	}

	@RequestMapping(value = { "family/save", "family/edit/save" })
	public String saveFamily(@ModelAttribute("family") Family f) {
		if (f.getHive() == null || f.getHive().getId() == -1)
			f.setHive(null);
		if (f.getId() > 0)
			this.familyService.updateFamily(f);
		else
			this.familyService.addFamily(f);
		return "redirect:/families";
	}

	@RequestMapping(value = "family/remove/{id}")
	public String removeFamily(@PathVariable("id") int id) {
		this.familyService.removeFamily(id);
		return "redirect:/families";
	}

}
