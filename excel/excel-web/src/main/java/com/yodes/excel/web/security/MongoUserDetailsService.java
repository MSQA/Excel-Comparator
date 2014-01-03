package com.yodes.excel.web.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Implementation of the {@link UserDetailsService} that retrieves the users information stored in the mongodb
 */
@Service("mongoUserDetailsService")
public class MongoUserDetailsService implements UserDetailsService, InitializingBean {

	private static final Logger logger = LoggerFactory.getLogger(MongoUserDetailsService.class);

	@Autowired
	private MongoUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (logger.isDebugEnabled()) {
			logger.debug("searching for user with username :  " + username);
		}
		return userRepository.findByUsername(username);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		MongoUser adminUser = new MongoUser("yoda", "reloaded", roles);
		userRepository.save(adminUser);
	}
}
