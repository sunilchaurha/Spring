package com.springws.service.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;

import com.springws.domain.User;
import com.springws.service.UserService;
import com.springws.service.jaxb.GetUserRequest;
import com.springws.service.jaxb.GetUserResponse;

@Endpoint
public class UserServiceEndpoint {

	
	private static final String TARGET_NAMESPACE = "http://com/samples/webservices/userService";
	
	@Autowired
	private UserService userService;
	
	@PayloadRoot(localPart = "GetUserRequest", namespace = TARGET_NAMESPACE)
	@SoapAction(value=TARGET_NAMESPACE)
	public @ResponsePayload GetUserResponse getUser(@RequestPayload GetUserRequest userRequest){
		String username = userRequest.getUsername();
		User user = userService.getUser(username);
		com.springws.service.jaxb.User user2 = new com.springws.service.jaxb.User();
		user2.setUsername(user.getUsername());
		user2.setEmail(user.getEmail());
		GetUserResponse response = new GetUserResponse();
		response.setUserDetail(user2);
		return response;
		
		
	}

	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}

