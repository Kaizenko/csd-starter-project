package com.kaizenko.vendingmachine;

public class VendingMachine {

	IPaymentProcessor paymentProcessor;
	
	public VendingMachine(IPaymentProcessor paymentProcessor) {
		this.paymentProcessor = paymentProcessor;
	}
	
	public int releaseChange() {	
		int change = paymentProcessor.getPayment();
		paymentProcessor.processPayment(change);
		return change;
	}

	public void insertCoin() {
		paymentProcessor.makePayment(25);	
	}

	public Product buyProduct() {
		if (paymentProcessor.getPayment()>=50) {
			paymentProcessor.processPayment(50);
			return new Product();
		}
		else {
			return null;
		}
	}

}
