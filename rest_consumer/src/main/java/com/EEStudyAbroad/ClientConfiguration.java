
package com.EEStudyAbroad;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import com.EEStudyAbroad.soap.service.PaymentService;

@Configuration
public class ClientConfiguration {

	@Bean
	public JaxWsPortProxyFactoryBean serviceProxy() {
		JaxWsPortProxyFactoryBean proxyFactory = new JaxWsPortProxyFactoryBean();
		
		try {
			proxyFactory.setWsdlDocumentUrl(new URL("http://localhost:8003/soap-service/payment-service?wsdl"));
			proxyFactory.setServiceInterface(PaymentService.class);
			
			proxyFactory.setServiceName("PaymentServiceImplService");
			proxyFactory.setPortName("paymentPort");
			proxyFactory.setNamespaceUri("http://service.EEStudyAbroad.com/");
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
		return proxyFactory;
	}
	
}
