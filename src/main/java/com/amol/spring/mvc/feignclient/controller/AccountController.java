package com.amol.spring.mvc.feignclient.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amol.spring.mvc.feignclient.service.AccountService;
import com.amol.spring.mvc.feignclient.vo.AccountVO;

@Controller
public class AccountController {
	
	final static Logger logger = LogManager.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String login(@RequestParam(name="username") String userName, ModelMap model) {
		logger.debug("LoginController -> login user name=" + userName);
		accountService.getAccount(userName);
		AccountVO accountVO = new AccountVO();
		accountVO.setName(userName);
		accountVO.setBalance("1000");
		accountService.addAccount(accountVO);
		model.addAttribute("user", userName);
		return "welcome";
		
	}

}
