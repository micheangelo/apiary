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

import pl.manager.apiary.model.Hive;
import pl.manager.apiary.service.hive.HiveService;
import pl.manager.apiary.utils.ApiaryConst;

/**
 * Hive controller
 */
@Controller
@RequestMapping(value = "/hives")
public class HiveController {
	private HiveService hiveService;

	@Autowired(required = true)
	@Qualifier(value = "hiveService")
	public void setHiveService(HiveService hiveService) {
		this.hiveService = hiveService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listHives(HttpServletRequest request, ModelMap modelMap) {
		List<Hive> hives = hiveService.listHives();
		PagedListHolder<Hive> pagedListHolder = new PagedListHolder<>(hives);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("listHives", pagedListHolder);
		return "hives";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addHive(Model model) {
		Hive h = new Hive();
		model.addAttribute("operation", ApiaryConst.ADD);
		model.addAttribute("hive", h);
		return "hive";
	}

	@RequestMapping(value = "edit/{id}")
	public String editHive(@PathVariable("id") int id, Model model) {
		model.addAttribute("operation", ApiaryConst.EDIT);
		model.addAttribute("hive", hiveService.getHiveById(id));
		return "hive";
	}

	@RequestMapping(value = { "save", "edit/save" })
	public String saveHive(@ModelAttribute("hive") Hive h) {
		if (h.getId() > 0)
			hiveService.updateHive(h);
		else
			hiveService.addHive(h);
		return "redirect:/hives";
	}

	@RequestMapping(value = { "remove/{id}" })
	public String removeHive(@PathVariable("id") int id) {
		this.hiveService.removeHive(id);
		return "redirect:/hives";
	}

}
