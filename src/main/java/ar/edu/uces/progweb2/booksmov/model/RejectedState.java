package ar.edu.uces.progweb2.booksmov.model;

public class RejectedState extends LoanState{

	@Override
	public boolean canRequestProductLoan() {
		return false;
	}

}
