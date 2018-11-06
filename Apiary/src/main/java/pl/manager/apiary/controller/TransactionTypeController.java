package pl.manager.apiary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.manager.apiary.model.TransactionType;
import pl.manager.apiary.service.transaction.type.TransactionTypeService;

@Controller
public class TransactionTypeController {
	private TransactionTypeService transactionTypeService;

	@Autowired
	public void setTransactionTypeService(TransactionTypeService transactionTypeService) {
		this.transactionTypeService = transactionTypeService;
	}
	
	@RequestMapping(value = "/transaction-types", method = RequestMethod.GET)
	public String listTransactionTypes(HttpServletRequest request, ModelMap modelMap) {
		List<TransactionType> transactionTypes = this.transactionTypeService.listTransactionTypes();
		PagedListHolder<TransactionType> pagedListHolder = new PagedListHolder<>(transactionTypes);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("listTransactionTypes", pagedListHolder);
		return "transaction-types";
	}
	
	
}
