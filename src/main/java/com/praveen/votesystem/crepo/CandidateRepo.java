package com.praveen.votesystem.crepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.praveen.votesystem.cmodel.Candidate;


public interface CandidateRepo extends JpaRepository<Candidate, Integer> {

	public Candidate findBycandidateName(String candidateName);

	public Candidate findByCount(int max);

//	@Query(value = "SELECT *, max(count) FROM Candidate", nativeQuery = true)
//	public Candidate findWinner();

}
