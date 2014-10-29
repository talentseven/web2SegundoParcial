package ar.edu.uces.progweb2.booksmov.model;

public class DeliveredState extends LoanState{

	@Override
	public boolean canRequestProductLoan() {
		return true;
	}

}
