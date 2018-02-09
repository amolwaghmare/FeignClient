package com.amol.spring.mvc.feignclient.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amol.spring.mvc.feignclient.vo.AccountVO;

/**
 * @author Amol Waghmare
 *
 */

@FeignClient("spring-cloud-account-service")
public interface AccountService {
	
	

//	@RequestMapping("/account", method=Reques)
//	public AccountVO addAccount(AccountVO accountVO) ;
	
	@RequestMapping(path="/services/account", method=RequestMethod.GET)
	public AccountVO getAccount(@RequestParam("name") String name);
}
