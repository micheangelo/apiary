package pl.manager.apiary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.manager.apiary.model.Transaction;
import pl.manager.apiary.service.TransactionService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private TransactionService transactionService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired(required = true)
	@Qualifier(value = "transactionService")
	public void setTransactionService(TransactionService cs) {
		this.transactionService = cs;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * home(Locale locale, Model model) {
	 * logger.info("Welcome home! The client locale is {}.", locale);
	 * 
	 * Date date = new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * 
	 * String formattedDate = dateFormat.format(date);// + newCost.getDescription();
	 * 
	 * model.addAttribute("serverTime", formattedDate);
	 * 
	 * return "home"; }
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listTransactions(Model model) {
		model.addAttribute("transaction", new Transaction());
		model.addAttribute("listTransactions", this.transactionService.listTransactions());
		return "transactions";
	}
	
	@RequestMapping(value = "/transaction/add", method = RequestMethod.POST)
	public String addTransaction(@ModelAttribute("transaction")Transaction t) {
		this.transactionService.addTransaction(t);
		
		return "redirect:/transactions";
		
	}
}
