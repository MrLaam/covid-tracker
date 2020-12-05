package com.demo.coronavirus.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.demo.coronavirus.model.Case;
import com.demo.coronavirus.model.CasesHelper;

@Controller
public class DisplayCasesController {
	private List<Case> cases;
	private Case latestCaseInfo = new Case();
	private CasesHelper casesHelper = new CasesHelper();

	/*
	 * @Bean public CommandLineRunner run(RestTemplate restTemplate) throws
	 * Exception { return args -> { ResponseEntity<List<Case>> casesResponse =
	 * restTemplate.exchange(
	 * "https://api.covid19api.com/total/dayone/country/united-kingdom/status/confirmed",
	 * HttpMethod.GET, null, new ParameterizedTypeReference<List<Case>>() { });
	 * cases = casesResponse.getBody(); latestCaseInfo = cases.get(cases.size() -
	 * 1); latestCaseInfo.setLatestDate(latestCaseInfo.getDate());
	 * latestCaseInfo.setCases(latestCaseInfo.getCases());
	 * latestCaseInfo.addCommaToCases(); latestCaseInfo.formatDate();
	 * casesHelper.defineGoogleArray(cases); }; }
	 */

	public void getCasesInfo() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Case>> casesResponse = restTemplate.exchange(
				"https://api.covid19api.com/total/dayone/country/united-kingdom/status/confirmed", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Case>>() {
				});
		cases = casesResponse.getBody();
		latestCaseInfo = cases.get(cases.size() - 1);
		latestCaseInfo.setLatestDate(latestCaseInfo.getDate());
		latestCaseInfo.setCases(latestCaseInfo.getCases());
		latestCaseInfo.addCommaToCases();
		latestCaseInfo.formatDate();
		casesHelper.defineGoogleArray(cases);
	}

	@RequestMapping("/cases")
	public ModelAndView displayCases() {
		getCasesInfo();
		ModelAndView mv = new ModelAndView();
		mv.addObject("cases", cases);
		mv.addObject("strTotalCases", latestCaseInfo.getFormattedCases());
		mv.addObject("strLatestDate", latestCaseInfo.getFormattedDate());
		mv.addObject("listCases", cases);
		mv.addObject("formattedGoogleArray", Arrays.deepToString(casesHelper.getGoogleArray()));
		mv.setViewName("cases");
		return mv;
	}

}
