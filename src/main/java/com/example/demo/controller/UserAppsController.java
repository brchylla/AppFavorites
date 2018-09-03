package com.example.demo.controller;

import com.example.demo.data.applink.AppLink;
import com.example.demo.data.userapps.UserAppsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ben chylla on 9/2/2018
 */
@RestController
public class UserAppsController {
	
	@Autowired
	UserAppsService uaService;
	
	/**
	 * Return list of app links open for this user
	 * @param login				The user login
	 * @return					All app links open for this user
	 */
	@RequestMapping(value="/getOpenAppLinks", method=RequestMethod.GET)
    public List<AppLink> getOpenAppLinks(@RequestParam(value="login") String login) {
		return uaService.getOpenAppLinks(login);
    }

	/**
	 * Return list of app links closed for this user
	 * @param login				The user login
	 * @return					All app links closed for this user
	 */
	@RequestMapping(value="/getClosedAppLinks", method=RequestMethod.GET)
    public List<AppLink> getClosedAppLinks(@RequestParam(value="login") String login) {
    	return uaService.getClosedAppLinks(login);
    }
	
	/**
	 * Remove app link from view for a specific user
	 * @param appName			The name of the app link
	 * @param login				The login of the user
	 * @return					Updated list of app links to open in user view
	 */
	@RequestMapping(value="/removeAppLink", method=RequestMethod.GET)
    public List<AppLink> removeAppLink(@RequestParam(value="appName") String appName, 
    								   @RequestParam(value="login") String login) {
		// update user table by removing app link name
		uaService.removeAppLink(appName, login);
		// return updated list of open app links
		return uaService.getOpenAppLinks(login);
    }

    /**
     * Add app link to view for a specific user
     * @param appName			The name of the app link
     * @param login				The login of the user
     * @return					Updated list of app links to open in user view
     */
	@RequestMapping(value="/addAppLink", method=RequestMethod.GET)
    public List<AppLink> addAppLink(@RequestParam(value="appName") String appName, 
									@RequestParam(value="login") String login) {
    	// update user table by adding app link name
    	uaService.addAppLink(appName, login);
    	// return updated list of open app links
    	return uaService.getOpenAppLinks(login);
    }
}
