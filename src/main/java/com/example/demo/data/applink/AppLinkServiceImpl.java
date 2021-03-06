package com.example.demo.data.applink;

import org.springframework.beans.factory.annotation.Autowired;

import java.net.*;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created by ben chylla on 9/1/18.
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
        alRepo.save(new AppLink("Google", "Search Engine", "Red", true, new URL("http://www.google.com")));
        alRepo.save(new AppLink("Wisc", "UW homepage", "DeepSkyBlue", false, new URL("http://www.wisc.edu")));
        alRepo.save(new AppLink("GLBRC", "Great Lakes Bioenergy Research Center", "Yellow", true, new URL("http://www.glbrc.org")));
        alRepo.save(new AppLink("WEI", "Wisconsin Energy Institute", "LimeGreen", false, new URL("https://energy.wisc.edu/")));
        alRepo.save(new AppLink("Twitter", "Social Media", "MediumPurple", false, new URL("https://twitter.com/")));
        alRepo.save(new AppLink("Facebook", "Social Media", "CornflowerBlue", true, new URL("https://facebook.com/")));
        alRepo.save(new AppLink("LinkedIn", "Social Media", "Cyan", true, new URL("https://linkedin.com/")));
        alRepo.save(new AppLink("Google Maps", "Navigation", "Lime", true, new URL("https://google.com/maps")));
        alRepo.save(new AppLink("Wolfram Alpha", "Calculator", "Orange", true, new URL("http://m.wolframalpha.com/")));
        alRepo.save(new AppLink("Weather", "Weather", "SkyBlue", true, new URL("https://weather.com/")));
        alRepo.save(new AppLink("SpotHero", "Parking", "RoyalBlue", true, new URL("https://spothero.com/")));
        alRepo.save(new AppLink("Wikipedia", "Encyclopedia", "Silver", true, new URL("https://www.wikipedia.org/")));
        alRepo.save(new AppLink("UW Credit Union", "Banking", "OrangeRed", true, new URL("https://www.uwcu.org/")));
        alRepo.save(new AppLink("Yelp", "Consumer Reviews", "Salmon", true, new URL("https://www.yelp.com/")));
        alRepo.save(new AppLink("Indeed", "Jobs", "Aquamarine", true, new URL("https://www.indeed.com/")));
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
     * Search for list of default links in program
     * @return				App links with default status
     */
    public List<AppLink> findDefaultAppLinks() {
    	return alRepo.findByDefaultStatus(true);
    }

    /**
     * Search for list of all app links in program
     * @return              All app links
     */
    public List<AppLink> findAllAppLinks() {
        return alRepo.findAll();
    }

}
