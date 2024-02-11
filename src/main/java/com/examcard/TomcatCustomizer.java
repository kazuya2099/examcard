package com.examcard;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class TomcatCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

	@Override
	public void customize(TomcatServletWebServerFactory factory) {
		InetAddress address;
		try {
			address = InetAddress.getByName("127.0.0.1");
			factory.setAddress(address);
			factory.setProtocol("AJP/1.3");
			factory.setPort(8009);
			factory.getTomcatConnectorCustomizers().add(c -> c.setProperty("secretRequired", "false"));
		} catch (UnknownHostException e) {
			log.error("Tomcat AJP エラー", e);
		}
	}

}
