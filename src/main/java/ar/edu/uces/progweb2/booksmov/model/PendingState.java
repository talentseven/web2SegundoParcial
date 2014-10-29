package ar.edu.uces.progweb2.booksmov.model;

public class PendingState extends LoanState{

	@Override
	public boolean canRequestProductLoan() {
		return false;
	}

}
