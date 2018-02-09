package com.amol.spring.mvc.feignclient.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amol.spring.mvc.feignclient.vo.AccountVO;

/**
 * @author Amol Waghmare
 * 
 * Service interfacee representing the micro service you need to call.
 *  The underlying framework of the miroservice could be different. 
 * E.g. The microservice represented by  GET "services/account" is implemented using CXF implementation of Jax-rs.
 * However this interface uses spring framework annotation for REST. 
 * Issue?(?): When jax-rs annotations are used, the framework complains about GET method not being defined for the service.
 *
 */

@FeignClient("spring-cloud-account-service")
public interface AccountService {

	
	@RequestMapping(path="/services/account", method=RequestMethod.GET)
	public AccountVO getAccount(@RequestParam("name") String name);
}
