package com.mls.ws.client;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("positive")
@ContextConfiguration(locations = { "classpath:mls-ws-config-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MLSWSTest {

	Logger logger = Logger.getLogger(MLSWSTest.class);

	@Autowired
	@Qualifier("ws.mls.request.channel")
	MessageChannel input;

	@Autowired
	@Qualifier("ws.mls.output.channel")
	PollableChannel outputChannel;

	
	@Test
	public void testWSCall() throws Exception{
		try {

			String p = "<user:GetUserRequest xmlns:user=\"http://com/samples/webservices/userService\"  >"+
							"<user:username>EMC Test</user:username>"+
						"</user:GetUserRequest>";
			
				
			Message<?> message = MessageBuilder.withPayload(p).build();
			logger.info("Request message : "+message);
			input.send(message);
			Message<?> outMessage = outputChannel.receive(100);
			logger.info("Response message : "+outMessage.getPayload());
			
		} catch (Exception e) {
			logger.error("Exception >>>>>>>>>>>>>>>>>>>>>>>>> %n ",e);
		}

	}

}
