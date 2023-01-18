package com.praveen.votesystem.cserviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.votesystem.cmodel.Candidate;
import com.praveen.votesystem.crepo.CandidateRepo;
import com.praveen.votesystem.cservice.CandidateService;


@Service
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	CandidateRepo repo;
	@Autowired
	Candidate candidate;
	
	@Override
	public String saveService(String candidateName) {
		Candidate findifExist = repo.findBycandidateName(candidateName);
		if(findifExist!=null) {
			return "Candidate already added";
		}
		candidate.setCandidateName(candidateName);
		candidate.setCount(0);
		repo.save(candidate);
		return "saved successfully";
	}

	@Override
	public String castvoteService(String candidateName) {
		Candidate findifExist = repo.findBycandidateName(candidateName);
		if(findifExist==null) {
			return "Invalid Candidate";
		}
		findifExist.setCount(findifExist.getCount()+1);
	repo.save(findifExist);
		return "vote casted successfully";
	}

	@Override
	public List<Candidate> listvoteService() {
		return repo.findAll();
	}

	@Override
	public Candidate getwinnerService() {
	List<Candidate> findAll = repo.findAll();
	int max=0;
	for(Candidate obj:findAll)
	{
		if(obj.getCount()>max)
		{
			max=obj.getCount();
		}
	}
	return repo.findByCount(max);
	}

}
