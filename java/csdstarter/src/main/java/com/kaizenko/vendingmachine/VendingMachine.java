package com.kaizenko.vendingmachine;

public class VendingMachine {

	int cents=0;
	public int releaseChange() {	
		int change = cents;
		cents = 0;
		return change;
	}

	public void insertCoin() {
		cents+=25;		
	}

	public Product buyProduct() {
		if (cents>=50) {
			cents = cents - 50;
			return new Product();
		}
		else {
			return null;
		}
	}

}
