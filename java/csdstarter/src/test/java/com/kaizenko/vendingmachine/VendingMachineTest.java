package com.kaizenko.vendingmachine;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
 

class VendingMachineTest {	
	
	VendingMachine vendingMachine;
	IPaymentProcessor mockPaymentProcessor;
	
	@BeforeEach
	void Setup() {
		IPaymentProcessor paymentProcessor = new PaymentProcessor();
		 mockPaymentProcessor = mock(IPaymentProcessor.class);
		 vendingMachine = new VendingMachine(mockPaymentProcessor);
	}
	
	@Test
	void releaseChange_WhenNoMoneyIsInserted_Expect0Change() {
		 
		
		int change = vendingMachine.releaseChange();
		
		assertThat(change).isEqualTo(0);
	}
	
	@Test
	void releaseChange_WhenAQuarterIsInserted_Expect25C() {
		 
		vendingMachine.insertCoin();
		
		int change = vendingMachine.releaseChange();
		
		assertThat(change).isEqualTo(25);
	}
	
	@Test
	void releaseChange_When2QuartersAreInserted_Expect50C() {
		 
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		
		int change = vendingMachine.releaseChange();
		
		assertThat(change).isEqualTo(50);
	}
	
	@Test
	void releaseChange_When10QuartersAreInserted_Expect250C() {
		 
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
		 
		vendingMachine.insertCoin();
		vendingMachine.releaseChange();		
		
		int change = vendingMachine.releaseChange();
		
		assertThat(change).isEqualTo(0);
	}
	
	@Test
	void buyProduct_WhenNoMoneyInserted_ExpectNoProduct() {
		 
		
		Product product = vendingMachine.buyProduct();		
		
		assertThat(product).isNull();
	}
	
	@Test
	void buyProduct_WhenExactMoneyInserted_ExpectProduct() {
		 
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		
		Product product = vendingMachine.buyProduct();		
		
		assertThat(product).isNotNull();
	}
	
	@Test
	void buyProduct_WhenMoreMoneyInserted_ExpectProduct() {
		 
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		
		Product product = vendingMachine.buyProduct();		
		
		assertThat(product).isNotNull();
	}
	
	@Test
	void buyProduct_WhenNotEnoughMoneyInserted_ExpectNoProduct() {
		 
		vendingMachine.insertCoin();
				
		Product product = vendingMachine.buyProduct();		
		
		assertThat(product).isNull();
	}
	
	@Test
	void buyProduct_WhenProductAlreadyPurchaseWithExactMoney_ExpectNoProduct() {
		 
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.buyProduct();		
				
		Product product = vendingMachine.buyProduct();		
		
		assertThat(product).isNull();
	}
	
	@Test
	void releaseChange_WhenProductAlreadyPurchaseWith75c_Expect25c() {
		 
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.buyProduct();		
				
		int change = vendingMachine.releaseChange();		
		
		assertThat(change).isEqualTo(25);
	}
	
	@Test
	void buyProduct_WhenPayment_ExpectProduct() {
		//vendingMachine.insertCoin();
		//vendingMachine.insertCoin();
		 
		when(mockPaymentProcessor.getPayment()).thenReturn(50);	
				
		Product product = vendingMachine.buyProduct();		
		
		assertThat(product).isNotNull();
	}
	
	@Test
	void buyProduct_WhenNoPayment_ExpectNoProduct() {
		 
		when(mockPaymentProcessor.getPayment()).thenReturn(49);	
				
		Product product = vendingMachine.buyProduct();		
		
		assertThat(product).isNull();
	}
	
	@Test
	void insertCoin_WhenPayment_ExpectPaymentOf25IsMade() {
		
		vendingMachine.insertCoin();
		verify(mockPaymentProcessor).makePayment(50);
		
	}
	

}
