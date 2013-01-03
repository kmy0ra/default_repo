package test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import service.BankService;
import service.BankServiceImpl;

public class AuthenticationExample {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"applicationConfig.xml");

		AuthenticationManager am = (AuthenticationManager)appContext.getBean("amAlias");
		
//		SecurityContext sec = SecurityContextHolder.getContext();
	
		String user = "jimi";
		String pass = "jimispassword";

		Authentication request = new UsernamePasswordAuthenticationToken(user,
				pass);
		Authentication result = am.authenticate(request);
		SecurityContextHolder.getContext().setAuthentication(result);
//		System.out
//				.println("Successfully authenticated. Security context contains: "
//						+ SecurityContextHolder.getContext()
//								.getAuthentication());
		BankService bs = (BankService)appContext.getBean("bankService");
		bs.readAccount(1L);
	}

}
