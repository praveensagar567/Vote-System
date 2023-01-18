package com.praveen.votesystem.cservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.praveen.votesystem.cmodel.Candidate;

@Service
public interface CandidateService {

public	String saveService(String candidateName);

public String castvoteService(String candidateName);

public List<Candidate> listvoteService();

public Candidate getwinnerService();

}
