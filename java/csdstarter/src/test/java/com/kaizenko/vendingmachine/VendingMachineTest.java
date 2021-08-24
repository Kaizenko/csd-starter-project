package com.kaizenko.vendingmachine;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
 

class VendingMachineTest {	
	
	@Test
	void releaseChange_WhenNoMoneyIsInserted_Expect0Change() {
		VendingMachine vendingMachine = new VendingMachine();
		
		int change = vendingMachine.releaseChange();
		
		assertThat(change).isEqualTo(0);
	}
	
	@Test
	void releaseChange_WhenAQuarterIsInserted_Expect25C() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insertCoin();
		
		int change = vendingMachine.releaseChange();
		
		assertThat(change).isEqualTo(25);
	}
	
	@Test
	void releaseChange_When2QuartersAreInserted_Expect50C() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		
		int change = vendingMachine.releaseChange();
		
		assertThat(change).isEqualTo(50);
	}
	
	@Test
	void releaseChange_When10QuartersAreInserted_Expect250C() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		
		int change = vendingMachine.releaseChange();
		
		assertThat(change).isEqualTo(250);
	}
	
	@Test
	void releaseChange_WhenChangeIsAlreadyReleased_Expect0c() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insertCoin();
		vendingMachine.releaseChange();		
		
		int change = vendingMachine.releaseChange();
		
		assertThat(change).isEqualTo(0);
	}
	
	@Test
	void buyProduct_WhenNoMoneyInserted_ExpectNoProduct() {
		VendingMachine vendingMachine = new VendingMachine();
		
		Product product = vendingMachine.buyProduct();		
		
		assertThat(product).isNull();
	}
	
	@Test
	void buyProduct_WhenExactMoneyInserted_ExpectProduct() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		
		Product product = vendingMachine.buyProduct();		
		
		assertThat(product).isNotNull();
	}
	
	@Test
	void buyProduct_WhenMoreMoneyInserted_ExpectProduct() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		
		Product product = vendingMachine.buyProduct();		
		
		assertThat(product).isNotNull();
	}
	
	@Test
	void buyProduct_WhenNotEnoughMoneyInserted_ExpectNoProduct() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insertCoin();
				
		Product product = vendingMachine.buyProduct();		
		
		assertThat(product).isNull();
	}
	
	@Test
	void buyProduct_WhenProductAlreadyPurchaseWithExactMoney_ExpectNoProduct() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.buyProduct();		
				
		Product product = vendingMachine.buyProduct();		
		
		assertThat(product).isNull();
	}
	
	@Test
	void releaseChange_WhenProductAlreadyPurchaseWith75c_Expect25c() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.buyProduct();		
				
		int change = vendingMachine.releaseChange();		
		
		assertThat(change).isEqualTo(25);
	}
	

}
