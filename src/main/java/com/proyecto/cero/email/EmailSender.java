package com.proyecto.cero.email;

import com.sendgrid.*;

public class EmailSender {

	static SendGrid sendgrid = new SendGrid("app34760661@heroku.com", "1snjqgxm1351");

	public static void sendEmail() {
		SendGrid.Email email = new SendGrid.Email();
		email.addTo("Eugenio.Valeiras@gmail.com");
		email.setFrom("notify@vaquita.com");
		email.setSubject("Test Email Sender");
		email.setText("text email Sender");
		
		try {
			SendGrid.Response response = sendgrid.send(email);
			System.out.println("The email FROM: =>"+email.getFrom()+" TO: "+email.getTos()+" | ¿enviado? => "+response.getStatus());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		EmailSender.sendEmail();
	}
	
}
