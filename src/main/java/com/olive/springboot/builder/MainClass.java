package com.olive.springboot.builder;

import java.math.BigDecimal;

public class MainClass {

	public static void main(String[] args) {
		String oc138 = "41,42,43,46";
		String purposeCode = "2,4";
		BigDecimal zero = BigDecimal.ZERO;
		System.out.println("zero :: {} " + zero);
		System.out.println(oc138.contains(purposeCode));
	}
	
}
