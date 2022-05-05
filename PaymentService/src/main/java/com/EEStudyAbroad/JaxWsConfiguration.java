package com.EEStudyAbroad;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//configure JaxWs, a standardized API for creating and consuming SOAP web services.
@Configuration
public class JaxWsConfiguration {

	//a Spring Bean to register a servlet: A servlet is a Java programming language class that is used to extend the capabilities of servers that host applications accessed by means of a request-response programming model
	@Bean
	public ServletRegistrationBean<CXFServlet> cxfServlet(){
		return new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/soap-service/*");
	}
	
	//the bus provides access to different extensions and wires CXF internals
	@Bean(name="cfx")
	public SpringBus springBus() {
		return new SpringBus();
	}
	
	//Will probably need these once I get BookingService & BookingServiceImpl set up:
	/*
	@Bean
	public BookingServiceImpl bookingServiceImpl() {
		return new BookingServiceImpl();
	}
	
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), bookingServiceImpl());
		endpoint.publish("booking-service");
		return endpoint;
	}
	*/
}
