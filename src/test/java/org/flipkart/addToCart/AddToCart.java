package org.flipkart.addToCart;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class AddToCart extends BaseClass {
	@Test
	public void validateProduct() {
		home.search(prdct);
		home.clickSearchBtn();
		product.clickOnProduct();
		String pid = driverUtility.parentWindowId();
		driverUtility.switchWindow(pid);
		String exp=productpage.product();
		productpage.clickOnAddToCartBtn();
		String act =cart.productName();
		asert.assertEquals(act, exp);
		System.out.println("validation passed");
		
	}

}
