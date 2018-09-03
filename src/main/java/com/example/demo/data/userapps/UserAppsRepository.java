package com.example.demo.data.userapps;

import com.example.demo.data.userapps.UserApps;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface UserAppsRepository extends MongoRepository<UserApps, String> {
	/**
	 * Find user
	 * @param login	A login username
	 * @return		The user with the given login
	 */
	UserApps findByLogin(String login);
	
	/**
	 * Find all users
	 * @return		All users
	 */
	List<UserApps> findAll();
}
