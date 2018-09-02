package com.example.demo.data.applink;

import org.springframework.beans.factory.annotation.Autowired;

import java.net.*;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created by ben chylla on 7/23/18.
 * Aggregates a MutualFundRepository for additional searching and downloading capability
 */
@Service
public class AppLinkServiceImpl implements AppLinkService {
    @Autowired
    AppLinkRepository alRepo;

    /**
     * Default constructor that uses autowiring
     */
    public AppLinkServiceImpl() {}

    public AppLinkRepository getRepository() {
        return alRepo;
    }

    public void setRepository(AppLinkRepository alRepo) {
        this.alRepo = alRepo;
    }

    /**
     * Contructor
     * @param repo  Repository to aggregate
     */
    public AppLinkServiceImpl(AppLinkRepository repo) {
        alRepo = repo;
    }
    
    /**
     * Initializes all app links
     */
    public void initialize() throws MalformedURLException {
        alRepo.save(new AppLink("Twitter", "Twitter", "Purple", false, new URL("https://twitter.com/")));
        alRepo.save(new AppLink("WEI", "Wisconsin Energy Institute", "Green", false, new URL("https://energy.wisc.edu/")));
        alRepo.save(new AppLink("GLBRC", "Great Lakes Bioenergy Research Center", "Yellow", true, new URL("http://www.glbrc.org")));
        alRepo.save(new AppLink("Wisc", "UW homepage", "Blue", false, new URL("http://www.wisc.edu")));
        alRepo.save(new AppLink("Google", "Search Engine", "Red", true, new URL("http://www.google.com")));
    }

    /**
     * Search for app link by name
     * @param name          The name of the app link
     * @return              The app link with the given name
     */
    public AppLink findAppLinkByName(String name) {
        return alRepo.findByName(name);
    }

    /**
     * Search for list of all app links currently active
     * @return              All active app links
     */
    public List<AppLink> findAllActiveAppLinks() {
        return alRepo.findByIsActive(true);
    }

     /**
     * Search for list of all app links currently inactive
     * @return              All inactive app links
     */
    public List<AppLink> findAllInactiveAppLinks() {
        return alRepo.findByIsActive(false);
    }

    /**
     * Search for list of all app links in program
     * @return              All app links
     */
    public List<AppLink> findAllAppLinks() {
        return alRepo.findAll();
    }

}
