package ar.edu.uces.progweb2.booksmov.model;

public class AcceptedState extends LoanState{

	@Override
	public boolean canRequestProductLoan() {
		return true;
	}

}
