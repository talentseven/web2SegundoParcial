package ar.edu.uces.progweb2.booksmov.service;

import java.util.List;

import ar.edu.uces.progweb2.booksmov.dto.LoanRequestDto;
import ar.edu.uces.progweb2.booksmov.model.LoanRequest;

public interface LoanService {
	
	List<LoanRequestDto> getLoanRequestsByProductAndUserId(Long productId, Long userId);
	boolean canRequestLoan(List<LoanRequestDto> loans);
	void requestLoan(LoanRequest loan);
	List<LoanRequest> getMyRequestedLoans(Long userId);
	List<LoanRequest> getMyNotifiedLoans(Long userId);
}
