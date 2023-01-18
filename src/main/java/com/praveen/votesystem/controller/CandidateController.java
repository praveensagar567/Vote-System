package com.praveen.votesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.praveen.votesystem.cmodel.Candidate;
import com.praveen.votesystem.cservice.CandidateService;


@Controller
@ResponseBody
public class CandidateController {

	@Autowired
CandidateService service;
	
	@PostMapping("/entercandidate")
	public String save(@RequestParam String candidateName)
	{
		return service.saveService(candidateName);
	}

@PostMapping("/castvote")
	public String castvote(@RequestParam String candidateName)
	{
		return service.castvoteService(candidateName);
	}
	
	@GetMapping("/listvote")
	public List<Candidate> listvote()
	{
		return service.listvoteService();
	}
	

	
	@GetMapping("/getwinner")
	public Candidate getwinner()
	{
		return service.getwinnerService();
	}
	
	
}
