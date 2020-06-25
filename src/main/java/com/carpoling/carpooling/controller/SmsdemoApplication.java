package com.carpoling.carpooling.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
@Controller
public class SmsdemoApplication  {
	
	public static final String ACCOUNT_SID = "AC233f1ae54ed5a9a53df89083bfa679ae";
    public static final String AUTH_TOKEN = "6940a225e38f4edb3eb2f8fb7e594451";
    public static final String TWILIO_NUMBER ="+13082108256";

@RequestMapping("/greeting")
public String greeting() {
    sendSMS();
    return "greeting";
}
    	
public void sendSMS() {
    try {
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        // Build a filter for the MessageList
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Body", "Hello, World!"));
        params.add(new BasicNameValuePair("To", "+919805108206")); //Add real number here
        params.add(new BasicNameValuePair("From", TWILIO_NUMBER));

        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message = messageFactory.create(params);
        System.out.println(message.getSid());
    } 
    catch (TwilioRestException e) {
        System.out.println(e.getErrorMessage());
    }
}
  
 }