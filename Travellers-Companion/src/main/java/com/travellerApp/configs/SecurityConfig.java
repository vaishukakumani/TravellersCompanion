package com.travellerApp.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


import com.travellerApp.dao.UserDao1;
import com.travellerApp.service.OAuthUserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	static final String SIGNING_KEY = "plotNo2019300coitroad";
	 static final Integer ENCODING_STRENGTH = 256;
	 static final String SECURITY_REALM = "Travellers companion JWT Realm";
	
	 @Autowired
	    private OAuthUserService userDetailsService;

	    @Autowired
	    private UserDao1 userRepository;
	    
	    @Bean
	    @Override
	    protected AuthenticationManager authenticationManager() throws Exception {
	        return super.authenticationManager();
	    }
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService)
	                .passwordEncoder(new ShaPasswordEncoder(ENCODING_STRENGTH));
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                .sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                .and()
	                .authorizeRequests()
	                .antMatchers("/api/createUser/*").permitAll()
	                .antMatchers("/api/Itinerary/*").authenticated()
	                .antMatchers("/api/forum/*").authenticated()
	                .and()
	                .httpBasic()
	                .realmName(SECURITY_REALM)
	                .and()
	                .csrf()
	                .disable();

	    }

	    @Bean
	    public JwtAccessTokenConverter accessTokenConverter() {
	        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	        converter.setSigningKey(SIGNING_KEY);
	       
	        
	        return converter;
	    }

	    @Bean
	    public TokenStore tokenStore() {
	        return new JwtTokenStore(accessTokenConverter());
	    }
	    
	  
	     @Bean
		  public DefaultTokenServices tokenServices() {
		        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		        defaultTokenServices.setTokenStore(tokenStore());
		        defaultTokenServices.setSupportRefreshToken(true);
		        defaultTokenServices.setAccessTokenValiditySeconds(3600);
		        return defaultTokenServices;
		    }
	

}
