package com.infy.hnb.pojo;

public class PaymentSessionInputPOJO {
	
	private AmountPOJO amount;
	private String reference;
	private String merchantAccount;
	private String sdkVersion;
	private String shopperReference;
	private String channel;
	private String origin;
	private String html;
	private String returnUrl;
	private String shopperLocale;
	private String countryCode;
	
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public AmountPOJO getAmount() {
		return amount;
	}
	public void setAmount(AmountPOJO amount) {
		this.amount = amount;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getMerchantAccount() {
		return merchantAccount;
	}
	public void setMerchantAccount(String merchantAccount) {
		this.merchantAccount = merchantAccount;
	}
	public String getSdkVersion() {
		return sdkVersion;
	}
	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}
	public String getShopperReference() {
		return shopperReference;
	}
	public void setShopperReference(String shopperReference) {
		this.shopperReference = shopperReference;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public String getShopperLocale() {
		return shopperLocale;
	}
	public void setShopperLocale(String shopperLocale) {
		this.shopperLocale = shopperLocale;
	}	
}