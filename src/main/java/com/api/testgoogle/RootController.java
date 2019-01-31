package com.api.testgoogle;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class RootController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HttpServletRequest request;


	@Autowired
	Config applicationConfiguration;

	@RequestMapping("/")
	public String helloWorld(Model model) {
		String firstName = request.getParameter("searchStr");
		System.err.println(firstName);
		model.addAttribute("getall", getall(firstName).getBody());
		System.err.println(model.asMap());
		return "hello";
	}

	@ResponseBody
	@GetMapping(value = "/getall")
	public ResponseEntity<Object> getall(@PathVariable String searchStr) {
		String url = "https://www.googleapis.com/customsearch/v1?key=AIzaSyD-nrY8JABhiGClrC8VgRLj7CLVMecTVY8&cx=017576662512468239146:omuauf_lfve";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
		        // Add query parameter
		        .queryParam("q", searchStr);
		System.out.println(builder.buildAndExpand().toUri());
		HttpEntity<Object> request = new HttpEntity<Object>(applicationConfiguration.getHeadersInfo());
		ResponseEntity<LinkedHashMap> response = restTemplate.exchange(
				builder.buildAndExpand().toUri(),
				 HttpMethod.GET, request, LinkedHashMap.class);
		return new ResponseEntity<Object> (response.getBody(),HttpStatus.OK);
	}

}
