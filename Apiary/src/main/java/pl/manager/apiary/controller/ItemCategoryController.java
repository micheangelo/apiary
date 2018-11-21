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

import pl.manager.apiary.model.ItemCategory;
import pl.manager.apiary.service.ItemCategoryService;
import pl.manager.apiary.utils.ApiaryConst;

@Controller
@RequestMapping(value = "item-categories")
public class ItemCategoryController {

	private ItemCategoryService itemCategoryService;

	@Autowired
	@Qualifier(value = "itemCategoryService")
	public void setItemCategoryService(ItemCategoryService itemCategoryService) {
		this.itemCategoryService = itemCategoryService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String listItemCategories(HttpServletRequest request, ModelMap modelMap) {
		List<ItemCategory> itemCategories = this.itemCategoryService.listItemCategories();
		PagedListHolder<ItemCategory> pagedListHolder = new PagedListHolder<>(itemCategories);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("listItemCategories", pagedListHolder);
		return "item-categories";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addItemCategory(Model model) {
		ItemCategory itemCategory = new ItemCategory();
		model.addAttribute("operation", ApiaryConst.ADD);
		model.addAttribute("itemCategory", itemCategory);
		return "item-category";
	}
	
	@RequestMapping(value = "edit/{id}")
	public String editItemCategory(@PathVariable("id") int id, Model model) {
		model.addAttribute("itemCategory", this.itemCategoryService.getItemCategoryById(id));
		model.addAttribute("operation", ApiaryConst.EDIT);
		return "item-category";
	}

	@RequestMapping(value = { "save", "edit/save" })
	public String saveItemCategory(@ModelAttribute("itemCategory") ItemCategory itemCategory) {
		if (itemCategory.getId() > 0)
			this.itemCategoryService.updateItemCategory(itemCategory);			
		else
			this.itemCategoryService.addItemCategory(itemCategory);			
		return "redirect:/item-categories";
	}

}
