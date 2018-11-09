package pl.manager.apiary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.manager.apiary.model.TransactionType;
import pl.manager.apiary.service.TransactionTypeService;
import pl.manager.apiary.utils.ApiaryConst;

@Controller
@RequestMapping(value = "/transaction-types")
public class TransactionTypeController {
	private TransactionTypeService transactionTypeService;

	@Autowired
	public void setTransactionTypeService(TransactionTypeService transactionTypeService) {
		this.transactionTypeService = transactionTypeService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listTransactionTypes(HttpServletRequest request, ModelMap modelMap) {
		List<TransactionType> transactionTypes = this.transactionTypeService.listTransactionTypes();
		PagedListHolder<TransactionType> pagedListHolder = new PagedListHolder<>(transactionTypes);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("listTransactionTypes", pagedListHolder);
		return "transaction-types";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addTransactionType(Model model) {
		TransactionType transactionType = new TransactionType();
		model.addAttribute("operation", ApiaryConst.ADD);
		model.addAttribute("transactionType", transactionType);
		return "transaction-type";
	}
	
	@RequestMapping(value = "edit/{id}")
	public String editTransactionType(@PathVariable("id") int id, Model model) {
		model.addAttribute("transactionType", this.transactionTypeService.getTransactionTypeById(id));
		model.addAttribute("operation", ApiaryConst.EDIT);
		return "transaction-type";
	}

	@RequestMapping(value = { "save", "edit/save" })
	public String saveTransaction(@ModelAttribute("transactionType") TransactionType t) {
		if (t.getId() > 0)
			this.transactionTypeService.updateTransactionType(t);
		else
			this.transactionTypeService.addTransactionType(t);
		return "redirect:/transaction-types";
	}

}
