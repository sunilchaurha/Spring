package com.springws.wssecurity;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.security.WsSecurityFaultException;
import org.springframework.ws.soap.security.WsSecurityValidationException;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecuritySecurementException;

public class XwsSecirityInterceptorCustom extends XwsSecurityInterceptor{

	Logger logger = Logger.getLogger(XwsSecirityInterceptorCustom.class);
	@Override
	protected void secureMessage(SoapMessage soapMessage,
			MessageContext messageContext)
			throws XwsSecuritySecurementException {
		logger.info("Soap message "+soapMessage);
		logger.info("Message "+messageContext);
		super.secureMessage(soapMessage, messageContext);
	}
	
	@Override
	public boolean understands(SoapHeaderElement headerElement) {
		logger.info(headerElement);
		return super.understands(headerElement);
	}
	@Override
	public void setPolicyConfiguration(Resource policyConfiguration) {
		logger.info(policyConfiguration);
		super.setPolicyConfiguration(policyConfiguration);
	}
	
	@Override
	public void setSecureRequest(boolean secureRequest) {
		logger.info("secure req "+secureRequest);
		super.setSecureRequest(secureRequest);
	}
	
	@Override
	protected void validateMessage(SoapMessage soapMessage,
			MessageContext messageContext) throws WsSecurityValidationException {
		logger.info("Soap message "+soapMessage);
		logger.info("Message "+messageContext);
		super.validateMessage(soapMessage, messageContext);
	}
	
	@Override
	public boolean handleFault(MessageContext messageContext)
			throws WebServiceClientException {
		logger.info("handle fault");
		return super.handleFault(messageContext);
	}
	@Override
	public boolean handleFault(MessageContext messageContext, Object endpoint)
			throws Exception {
		logger.info("handle fault");
		return super.handleFault(messageContext, endpoint);
	}
	
	@Override
	protected boolean handleFaultException(WsSecurityFaultException ex,
			MessageContext messageContext) {
		logger.info("handle fault exception");
		return super.handleFaultException(ex, messageContext);
	}
	
}
