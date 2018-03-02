package com.bcht.its.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ配置
 */
@Component
@ConfigurationProperties(prefix = "spring.rabbitmq")
@Getter
@Setter
public class AmqpConfig {
    public static final String EXCHANGE   = "ITS_EXCHANGE_ITS_TFCPASS";
    private String host1;
    private int port1;
    private String username1;
    private String password1;
    private String virtualhost = "/";
    private String host;
    private int port;
    private String username;
    private String password;



    /**
     * 创建公安网ConnectionFactory
     * @return
     */
    @Bean(name="myConnectionFactory")
    @Primary
    public ConnectionFactory myConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(host1);
        connectionFactory.setPort(port1);
        connectionFactory.setUsername(username1);
        connectionFactory.setPassword(password1);
        connectionFactory.setVirtualHost(virtualhost);
        connectionFactory.setPublisherConfirms(true); //必须要设置
        return connectionFactory;
    }

    /**
     * 公安网rabbitmq admin
     * @return
     */
    @Bean
    public RabbitAdmin BchtAdmin(){
        return new RabbitAdmin(myConnectionFactory());
    }

    /**
     * 公安网rabbitTemplate
     * @return
     */
    @Bean

    public RabbitTemplate rabbitTemplate(@Qualifier("myConnectionFactory") ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(EXCHANGE);
        return rabbitTemplate;
    }





    /**
     * 专网ConnectionFactory
     * @return
     */
    @Bean(name="zwConnectionFactory")

    public ConnectionFactory zwConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualhost);
        connectionFactory.setPublisherConfirms(true); //必须要设置
        return connectionFactory;
    }

    /**
     * 专网rabbitmq admin
     * @return
     */
    @Bean
    public RabbitAdmin zwBchtAdmin(){
        return new RabbitAdmin(zwConnectionFactory());
    }

    @Bean(name="zwFactory")
    public SimpleRabbitListenerContainerFactory zwFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                                          @Qualifier("zwConnectionFactory")ConnectionFactory connectionFactory){

        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory,connectionFactory);
        return factory;

    }

}
