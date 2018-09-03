package com.example.demo.data.userapps;

import java.util.List;

import com.example.demo.data.applink.AppLink;

public interface UserAppsService {
	UserAppsRepository getRepository();
	
	/**
	 * Initialize all users (first time usage)
	 */
	void initialize();
	
	/**
	 * Get all users
	 * @return	All users
	 */
	List<UserApps> getAllUsers();
	
	/**
	 * Get all app links open to user
	 * @param login		The login of the current user
	 * @return			The app links open to the user
	 */
	List<AppLink> getOpenAppLinks(String login);
	
	/**
	 * Get all app links NOT open to user
	 * @param login		The login of the current user
	 * @return			The app links NOT open to the user
	 */
	List<AppLink> getClosedAppLinks(String login);
	
	/**
	 * Remove app link with given name from user table corresponding to login
	 * @param appName	The name of the app to be removed
	 * @param login		The login of the user whose table the app is to be removed from
	 */
	void removeAppLink(String appName, String login);
	
	/**
	 * Add app link with given name to user table corresponding to login
	 * @param appName	The name of the app to be added
	 * @param login		The login of the user whose table the app is to be added to
	 */
	void addAppLink(String appName, String login);
	
	/**
	 * Get app link with given name if it is open to user with given login
	 * @param login		The login of the current user
	 * @param name		The name of the app
	 * @return			The app link with the given name (or null)
	 */
	AppLink getAppLinkByName(String login, String appName);
	
}