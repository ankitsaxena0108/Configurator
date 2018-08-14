package com.prudential.users.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.prudential.core.common.ErrorCode;
import com.prudential.core.common.LocaleRepository;
import com.prudential.core.common.ThreadLocalVars;
import com.prudential.core.common.locale.Locale;
import com.prudential.core.users.UsersException;
import com.prudential.core.users.model.User;

@Service
public class UserDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

	@Autowired
	private LocaleRepository locRepo;

	@Autowired
	private UserRepository userRepo;

	public User currentUser() throws UsersException {
		String login = ThreadLocalVars.getCurrentUser();
		if (StringUtils.isEmpty(login)) {
			throw new UsersException(ErrorCode.CORE_1000);
		}
		return userRepo.findByLogin(login);
	}

	
	public Iterable<User> findAll() {
		return userRepo.findAll();
	}

	public User findUser(long id) {
		User user = userRepo.findOne(id);
		logger.debug("Found User {} against id {}", user, id);
		return user;
	}

	
	public User findUser(String login) {
		return userRepo.findByLogin(login);
	}

	public Locale findLocale(String language, String country) {
		return locRepo.findByLanguageAndCountry(language, country);
	}

}
