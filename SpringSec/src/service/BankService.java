package service;

import org.springframework.security.access.annotation.Secured;

public interface BankService {
	@Secured("ROLE_ADMIN")
	public void readAccount(Long id);
}
