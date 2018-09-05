package com.infy.hnb.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.infy.hnb.pojo.AmountPOJO;
import com.infy.hnb.pojo.PaymentSessionInputPOJO;
import com.infy.hnb.pojo.PaymentSessionOutputPOJO;

public class PaymentSessionService {

	public PaymentSessionOutputPOJO getPaymentSession(PaymentSessionInputPOJO inputRequest) {
		
		inputRequest.setReference("HNBOrderForDemo");
		inputRequest.setMerchantAccount("HnBECommTest");
		inputRequest.setSdkVersion("1.3.2");
		inputRequest.setShopperReference("HNBDemo_Reference");
		inputRequest.setChannel("Web");
		inputRequest.setHtml("true");
		//inputRequest.setOrigin("http://localhost:8282/");
		//	inputRequest.setReturnUrl("http://localhost:8282/StoreStockPusher/Adyen.html");
		inputRequest.setCountryCode("GB");
		inputRequest.setShopperLocale("shopperLocale");
		
		PaymentSessionOutputPOJO output = new PaymentSessionOutputPOJO();
		output.setPaymentSession(callAdyen(inputRequest));
		
		return output;
	}
	
	public String callAdyen(PaymentSessionInputPOJO inputRequest) {
		
		String output = "No session key :(";
		
		try {
			URL url = new URL("https://checkout-test.adyen.com/v32/paymentSession");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("X-API-Key", "AQEfhmfuXNWTK0Qc+iSesFABe1h8Cxd32qLHGNBZ+MzNyhDBXVsNvuR83LVYjEgiTGAH-+JQpLkHSDmliqvoYb33/PwvkQ8anUgghE9YykxS+Rlk=-GLKj7HYgxLgjN2d5");
			conn.setRequestProperty("Content-Type", "application/json");
			
			ObjectMapper mapper = new ObjectMapper();
			String input = mapper.writeValueAsString(inputRequest);
			System.out.println(input);		
			
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			
			System.out.println("Output from Server .... \n");
			String str;
			while ((str = br.readLine()) != null) {
				output = str;
				System.out.println(str);
			}

			conn.disconnect();			
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}		
		return output;	
	}
	
	public Object getPayLoad(HttpServletRequest httpRequest) {
		
	    StringBuilder sb = new StringBuilder();
	    ObjectMapper mapper = new ObjectMapper();
	    
	    BufferedReader reader = null;
	    PaymentSessionInputPOJO input = null;
	    
	    try {
	    	reader = httpRequest.getReader();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line).append('\n');
	        }
	        input = (PaymentSessionInputPOJO)mapper.readValue(sb.toString(), PaymentSessionInputPOJO.class);
	    }
	    catch (IOException e) {
	    	System.out.println(e);
	    }
	    finally {
	        try {
				reader.close();
			} catch (IOException e) {
				System.out.println(e);
			}
	    }
	    return input;
	}
}
