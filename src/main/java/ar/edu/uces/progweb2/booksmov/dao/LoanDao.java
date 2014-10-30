package ar.edu.uces.progweb2.booksmov.dao;

import java.util.List;

import ar.edu.uces.progweb2.booksmov.model.LoanRequest;

public interface LoanDao {
	
	List<LoanRequest> getLoanRequestsByProductAndUserId(Long productId, Long userId);
	void save(LoanRequest loan);
	List<LoanRequest> getMyRequestedLoans(Long userId);
	List<LoanRequest> getMyNotifiedLoans(Long userId);
}
