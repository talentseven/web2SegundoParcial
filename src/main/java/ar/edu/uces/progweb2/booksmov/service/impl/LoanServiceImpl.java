package ar.edu.uces.progweb2.booksmov.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import ar.edu.uces.progweb2.booksmov.dao.LoanDao;
import ar.edu.uces.progweb2.booksmov.dto.LoanRequestDto;
import ar.edu.uces.progweb2.booksmov.model.LoanRequest;
import ar.edu.uces.progweb2.booksmov.service.LoanConverterService;
import ar.edu.uces.progweb2.booksmov.service.LoanService;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private LoanDao loanDao;
	@Autowired
	private LoanConverterService loanConverter;
	
	@Override
	public List<LoanRequestDto> getLoanRequestsByProductAndUserId(Long productId, Long userId) {
		List<LoanRequest> loans = loanDao.getLoanRequestsByProductAndUserId(productId, userId);
		return transform(loans);
	}

	private List<LoanRequestDto> transform(List<LoanRequest> loans) {
		List<LoanRequestDto> loanDtos = new ArrayList<LoanRequestDto>();
		for (LoanRequest loanRequest : loans) {
			loanDtos.add(loanConverter.toDto(loanRequest));
		}
		return loanDtos;
	}

	@Override
	public boolean canRequestLoan(List<LoanRequestDto> loans) {
		
		if(CollectionUtils.isEmpty(loans)){
			return true;
		}
		for (LoanRequestDto loanRequestDto : loans) {
			if(!loanRequestDto.getState().canRequestProductLoan()){
				return false;
			}
		}
		return true;
	}

	@Override
	public void requestLoan(LoanRequest loan) {
		loanDao.save(loan);
	}

	@Override
	public List<LoanRequest> getMyRequestedLoans(Long userId) {
		return loanDao.getMyRequestedLoans(userId);
	}

	@Override
	public List<LoanRequest> getMyNotifiedLoans(Long userId) {
		return loanDao.getMyNotifiedLoans(userId);
	}
	
	
}
