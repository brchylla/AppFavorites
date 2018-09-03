package com.example.demo.data.applink;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by ben chylla on 9/1/18.
 */
public interface AppLinkService {
    AppLinkRepository getRepository();

    /**
     * Initializes the service; activates default apps if none are available.
     */
    void initialize() throws MalformedURLException;

    /**
     * Search for app link by name
     * @param name          The name of the app link
     * @return              The app link with the given name
     */
    AppLink findAppLinkByName(String name);
    
    /**
     * Search for list of default links in program
     * @return				App links with default status
     */
    List<AppLink> findDefaultAppLinks();

    /**
     * Search for list of all app links in program
     * @return              All app links
     */
    List<AppLink> findAllAppLinks();

}
