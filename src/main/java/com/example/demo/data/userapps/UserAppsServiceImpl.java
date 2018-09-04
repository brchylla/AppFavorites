package com.example.demo.data.userapps;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.data.applink.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserAppsServiceImpl implements UserAppsService {
	@Autowired
	UserAppsRepository uaRepo;
	@Autowired
	AppLinkService alService;
	
	/**
     * Default constructor that uses autowiring
     */
    public UserAppsServiceImpl() {}

    public UserAppsRepository getRepository() {
        return uaRepo;
    }

    public void setRepository(UserAppsRepository uaRepo) {
        this.uaRepo = uaRepo;
    }

    /**
     * Contructor
     * @param repo  Repository to aggregate
     */
    public UserAppsServiceImpl(UserAppsRepository repo) {
        uaRepo = repo;
    }
	
	/**
	 * Initialize all users (first time usage)
	 */
	public void initialize() {
		// get names of all apps links to initially appear in interface by default
		List<AppLink> defaultApps = alService.findDefaultAppLinks();
		// once you have all app links with default status, collect and store their names
		List<String> namesOfDefaultApps = new ArrayList<String>();
		for (AppLink appLink : defaultApps) {
			namesOfDefaultApps.add(appLink.getName());
		}
		// initialize user table, with names of default apps stored for every user
		uaRepo.save(new UserApps("user1", "glbrcpass", namesOfDefaultApps));
		uaRepo.save(new UserApps("user2", "glbrcpass", namesOfDefaultApps));
		uaRepo.save(new UserApps("user3", "glbrcpass", namesOfDefaultApps));
		uaRepo.save(new UserApps("default", "glbrcpass", namesOfDefaultApps));
	}
	
	/**
	 * Get user with corresponding login
	 * @param login		The user login
	 * @return			The user with the given login
	 */
	public UserApps getUser(String login) {
		return uaRepo.findByLogin(login);
	}
	
	/**
	 * Get all users
	 * @return	All users
	 */
	public List<UserApps> getAllUsers() {
		return uaRepo.findAll();
	}
	
	/**
	 * Get all app links open to user
	 * @param user		The current user
	 * @return			The app links open to the user
	 */
	public List<AppLink> getOpenAppLinks(String login) {
		// Get user with corresponding login
		UserApps user = uaRepo.findByLogin(login);
		// Get all app links open to that user
		List<AppLink> appLinks = new ArrayList<AppLink>();
		List<String> appLinkNames = user.getAppNames();
		for (String name : appLinkNames) {
			appLinks.add(alService.findAppLinkByName(name));
		}
		return appLinks;
	}
	
	/**
	 * Get all app links NOT open to user
	 * @param login		The login of the current user
	 * @return			The app links NOT open to the user
	 */
	public List<AppLink> getClosedAppLinks(String login) {
		// Get user with corresponding login
		UserApps user = uaRepo.findByLogin(login);
		// Iterate through all app links, and return ones that aren't in user table
		List<AppLink> closedAppLinks = new ArrayList<AppLink>();
		for (AppLink appLink : alService.findAllAppLinks()) {
			if (!user.hasApp(appLink.getName())) {
				closedAppLinks.add(appLink);
			}
		}
		return closedAppLinks;
	}
	
	/**
	 * Remove app link with given name from user table corresponding to login
	 * @param appName	The name of the app to be removed
	 * @param login		The login of the user whose table the app is to be removed from
	 */
	public void removeAppLink(String appName, String login) {
		// get user corresponding to login
		UserApps user = uaRepo.findByLogin(login);
		// remove app name from user list of open apps
		user.removeApp(appName);
		// update user table
		uaRepo.save(user);
	}
	
	/**
	 * Add app link with given name to user table corresponding to login
	 * @param appName	The name of the app to be added
	 * @param login		The login of the user whose table the app is to be added to
	 */
	public void addAppLink(String appName, String login) {
		// get user corresponding to login
		UserApps user = uaRepo.findByLogin(login);
		// add app name to user list of open apps
		user.addApp(appName);
		// update user table
		uaRepo.save(user);
	}
	
	/**
	 * Get app link with given name if it is open to given user
	 * @param user		The current user
	 * @param name		The name of the app
	 * @return			The app link with the given name (or null)
	 */
	public AppLink getAppLinkByName(String login, String appName) {
		// Get user with corresponding login
		UserApps user = uaRepo.findByLogin(login);
		// Check if app link is open to user
		if (user.hasApp(appName)) {
			// If app link is open to user, get it from AppLink service
			return alService.findAppLinkByName(appName);
		}
		// If app link is not open to user, return null
		else {
			return null;
		}
	}
}
