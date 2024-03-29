package ar.edu.uces.progweb2.booksmov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.uces.progweb2.booksmov.dto.LoanRequestDto;
import ar.edu.uces.progweb2.booksmov.dto.ProductDto;
import ar.edu.uces.progweb2.booksmov.model.LoanRequest;
import ar.edu.uces.progweb2.booksmov.service.LoanConverterService;
import ar.edu.uces.progweb2.booksmov.service.ProductConverterService;

@Service
public class LoanConverterServiceImpl implements LoanConverterService {
	
	@Autowired
	private ProductConverterService productConverter;
	
	@Override
	public LoanRequestDto toDto(LoanRequest loanRequest) {
		
		ProductDto productDto = productConverter.toDto(loanRequest.getProduct());
		LoanRequestDto loanDto = new LoanRequestDto(productDto.getId(), loanRequest.getRequestDescription(),
				loanRequest.getState(), loanRequest.getRequester().getId(), loanRequest.getConsignee().getId(), loanRequest.getRequestDate(), loanRequest.getResponseDate());
		loanDto.setId(loanRequest.getId());
		return loanDto;
	}

}
