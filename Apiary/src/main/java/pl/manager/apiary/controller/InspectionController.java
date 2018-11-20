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

import pl.manager.apiary.model.Inspection;
import pl.manager.apiary.service.InspectionService;
import pl.manager.apiary.utils.ApiaryConst;
import pl.manager.apiary.utils.CustomDropDownList;

@Controller
@RequestMapping(value = "/inspections")
public class InspectionController {
	private InspectionService inspectionService;

	@Autowired(required = true)
	@Qualifier(value = "inspectionService")
	public void setService(InspectionService inspectionService) {
		this.inspectionService = inspectionService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listInspections(HttpServletRequest request, ModelMap modelMap) {
		List<Inspection> inspections = this.inspectionService.listInspections();
		PagedListHolder<Inspection> pagedListHolder = new PagedListHolder<>(inspections);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("listInspections", pagedListHolder);
		return "inspections";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addInspection(Model model) {
		Inspection inspection = new Inspection();
		model.addAttribute("operation", ApiaryConst.ADD);
		model.addAttribute("inspection", inspection);	
		model.addAttribute("openBroodList",  CustomDropDownList.getList());
		model.addAttribute("closedBroodList",  CustomDropDownList.getList());
		model.addAttribute("queenPresentList",  CustomDropDownList.getList());
		model.addAttribute("swarmMoodList",  CustomDropDownList.getList());
		return "inspection";
	}
	
	@RequestMapping(value = "remove/{id}")
	public String removeInspection(@PathVariable("id") int id) {
		this.inspectionService.removeInspection(id);
		return "redirect:/inspections";
	}
	
	@RequestMapping(value = "edit/{id}")
	public String editInspection(@PathVariable("id") int id, Model model) {
		model.addAttribute("inspection", this.inspectionService.getInspectionById(id));
		model.addAttribute("operation", ApiaryConst.EDIT);
		model.addAttribute("openBroodList",  CustomDropDownList.getList());
		model.addAttribute("closedBroodList",  CustomDropDownList.getList());
		model.addAttribute("queenPresentList",  CustomDropDownList.getList());
		model.addAttribute("swarmMoodList",  CustomDropDownList.getList());
		return "inspection";
	}

	@RequestMapping(value = { "save", "edit/save" })
	public String saveInspection(@ModelAttribute("inspection") Inspection inspection) {
		if (inspection.getId() > 0)
			this.inspectionService.updateInspection(inspection);
		else
			this.inspectionService.addInspection(inspection);
		return "redirect:/inspections";
	}
}
