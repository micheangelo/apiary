package pl.manager.apiary.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.manager.apiary.model.ItemCategory;
import pl.manager.apiary.service.ItemCategoryService;

@Component
public class StringToItemCategoryConverter implements Converter<String, ItemCategory> {

	private ItemCategoryService itemCategoryService;

	@Autowired
	@Qualifier(value = "itemCategoryService")
	public void setItemCategoryService(ItemCategoryService itemCategoryService) {
		this.itemCategoryService = itemCategoryService;
	}

	@Override
	public ItemCategory convert(final String source) {
		return itemCategoryService.getItemCategoryById(Integer.parseInt(source));
	}
}
