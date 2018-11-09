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

import pl.manager.apiary.model.Transaction;
import pl.manager.apiary.service.transaction.TransactionService;
import pl.manager.apiary.service.transaction.type.TransactionTypeService;
import pl.manager.apiary.utils.ApiaryConst;

/**
 * Transaction controller
 */
@Controller
@RequestMapping(value="/transactions")
public class TransactionController {
	private TransactionService transactionService;
	private TransactionTypeService transactionTypeService;

	@Autowired(required = true)
	@Qualifier(value = "transactionService")
	public void setTransactionService(TransactionService cs) {
		this.transactionService = cs;
	}

	@Autowired(required = true)
	@Qualifier(value = "transactionTypeService")
	public void setTransactionTypeService(TransactionTypeService typeService) {
		this.transactionTypeService = typeService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String listTransactions(HttpServletRequest request, ModelMap modelMap) {
		List<Transaction> transactions = this.transactionService.listTransactions();
		PagedListHolder<Transaction> pagedListHolder = new PagedListHolder<>(transactions);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("listTransactions", pagedListHolder);
		return "transactions";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addTransaction(Model model) {
		Transaction t = new Transaction();
		model.addAttribute("operation", ApiaryConst.ADD);
		model.addAttribute("transaction", t);
		model.addAttribute("listTransactionTypes", this.transactionTypeService.listTransactionTypes());
		return "transaction";
	}

	@RequestMapping(value = "remove/{id}")
	public String removeTransaction(@PathVariable("id") int id) {
		this.transactionService.removeTransaction(id);
		return "redirect:/transactions";
	}

	@RequestMapping(value = "edit/{id}")
	public String editTransaction(@PathVariable("id") int id, Model model) {
		model.addAttribute("transaction", this.transactionService.getTransactionById(id));
		model.addAttribute("operation", ApiaryConst.EDIT);
		model.addAttribute("listTransactionTypes", this.transactionTypeService.listTransactionTypes());
		return "transaction";
	}

	@RequestMapping(value = { "save", "edit/save" })
	public String saveTransaction(@ModelAttribute("transaction") Transaction t) {
		if (t.getId() > 0)
			this.transactionService.updateTransaction(t);
		else
			this.transactionService.addTransaction(t);
		return "redirect:/transactions";
	}

}
