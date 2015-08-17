package oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import client.MongoClientDetailsService;
import client.MongoClientDetailsServiceBuilder;

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfiguration extends
		AuthorizationServerConfigurerAdapter {

	private ClientDetailsService clientDetailService;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security)
			throws Exception {

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
			throws Exception {

	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients)
			throws Exception {
		clientDetailService=new MongoClientDetailsService();
		MongoClientDetailsServiceBuilder builder=new MongoClientDetailsServiceBuilder();
		clients.setBuilder(builder);
		
		builder.withClient("Tour").secret("secret").and()
		.withClient("Customer").secret("Customer");
	}
}
