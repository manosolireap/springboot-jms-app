package com.mano.jmsapp.jmsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.
        DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@SpringBootApplication
@EnableJms
public class JmsAppApplication {

	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerFactory
            (ConnectionFactory connectionFactory,
             DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}


	public static void main(String[] args) throws Exception{

		ConfigurableApplicationContext context =
                SpringApplication.run(JmsAppApplication.class, args);
		MessageSender sender=context.getBean("messageSender",
                MessageSender.class);
		sender.send("msgQueue","Hi! How are you?");
		context.close();
	}
}
