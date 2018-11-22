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

import pl.manager.apiary.model.Item;
import pl.manager.apiary.service.ItemCategoryService;
import pl.manager.apiary.service.ItemService;
import pl.manager.apiary.utils.ApiaryConst;

@Controller
@RequestMapping(value = "/items")
public class ItemController {
	private ItemService itemService;
	private ItemCategoryService itemCategoryService;

	@Autowired
	@Qualifier(value = "itemService")
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	@Autowired
	@Qualifier(value = "itemCategoryService")
	public void setItemCategoryService(ItemCategoryService itemCategoryService) {
		this.itemCategoryService = itemCategoryService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listItems(HttpServletRequest request, ModelMap modelMap) {
		List<Item> items = this.itemService.listItems();
		PagedListHolder<Item> pagedListHolder = new PagedListHolder<>(items);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("listItems", pagedListHolder);
		return "items";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addItem(Model model) {
		Item item = new Item();
		model.addAttribute("operation", ApiaryConst.ADD);
		model.addAttribute("item", item);
		model.addAttribute("listItemCategories", this.itemCategoryService.listItemCategories());
		return "item";
	}

	@RequestMapping(value = "remove/{id}")
	public String removeItem(@PathVariable("id") int id) {
		this.itemService.removeItem(id);
		return "redirect:/items";
	}

	@RequestMapping(value = "edit/{id}")
	public String editItem(@PathVariable("id") int id, Model model) {
		model.addAttribute("item", this.itemService.getItemById(id));
		model.addAttribute("operation", ApiaryConst.EDIT);
		model.addAttribute("listItemCategories", this.itemCategoryService.listItemCategories());
		return "item";
	}

	@RequestMapping(value = { "save", "edit/save" })
	public String saveItem(@ModelAttribute("item") Item item) {
		if (item.getId() > 0)
			this.itemService.updateItem(item);
		else
			this.itemService.addItem(item);

		return "redirect:/items";
	}

}
