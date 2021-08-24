package com.kaizenko.vendingmachine;

public interface IPaymentProcessor {

	int getPayment();

	void processPayment(int change);

	void makePayment(int payment);

}