package com.example.demo.data.userapps;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class UserApps {
	
	@Id
	String _id; // Used to access the ObjectID in the table
	@Indexed
	private String login; // the user login
	private String password; // the user password
	private List<String> appNames; // the names of the app links currently in user table 
	
	public UserApps(String login, String password, List<String> appNames) {
		this.login = login;
		this.password = password;
		this.appNames = appNames;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public List<String> getAppNames() {
		return appNames;
	}
	
	public boolean hasApp(String name) {
		if (appNames.contains(name)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void removeApp(String appName) {
		appNames.remove(appName);
	}
	
	public void addApp(String appName) {
		appNames.add(appName);
	}
	
	public void setAppNames(List<String> appNames) {
		this.appNames = appNames;
	}
	
	@Override
	public String toString() {
		return login;
	}
	
}