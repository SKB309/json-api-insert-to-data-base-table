package com.danyal;

public class Currencies {
	
	 Xcd Xcd ;
	 
	 private SubCurrencies EUR ;
	 private SubCurrencies MYR;
	 private SubCurrencies USD;
//	 private SubCurrencies;
	 

	public com.danyal.Xcd getXcd() {
		return Xcd;
	}

	public SubCurrencies getEUR() {
		return EUR;
	}

	public void setEUR(SubCurrencies eUR) {
		EUR = eUR;
	}

	public SubCurrencies getMYR() {
		return MYR;
	}

	public void setMYR(SubCurrencies mYR) {
		MYR = mYR;
	}

	public SubCurrencies getUSD() {
		return USD;
	}

	public void setUSD(SubCurrencies uSD) {
		USD = uSD;
	}

	public void setXcd(com.danyal.Xcd xcd) {
		Xcd = xcd;
	}

	
}
