package com.kaizenko.vendingmachine;

public class PaymentProcessor implements IPaymentProcessor {

	int cents = 0;
	
	@Override
	public int getPayment() {		
		return cents;
	}

	@Override
	public void processPayment(int change) {		
		cents = cents - change; 
	}

	@Override
	public void makePayment(int payment) {
		cents = cents+ payment;
		
	}

}
