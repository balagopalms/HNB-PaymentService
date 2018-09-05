package com.infy.hof.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infy.hnb.pojo.PaymentSessionInputPOJO;
import com.infy.hnb.pojo.PaymentSessionOutputPOJO;
import com.infy.hnb.services.PaymentSessionService;

@WebServlet(urlPatterns="/adyen")
public class PaymentSessionServlet extends HttpServlet{

	@Override
	public void doPost (HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		
		PaymentSessionInputPOJO input = new PaymentSessionInputPOJO();	
		PaymentSessionService service = new PaymentSessionService();
		input = (PaymentSessionInputPOJO)service.getPayLoad(httpRequest);
		PaymentSessionOutputPOJO session = service.getPaymentSession(input);
		
		httpResponse.setContentType("application/json");
		PrintWriter out;
		try {
			out = httpResponse.getWriter();
			out.print(session.getPaymentSession());
			out.flush();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
