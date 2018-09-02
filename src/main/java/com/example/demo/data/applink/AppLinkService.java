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
     * Search for list of all app links currently active
     * @return              All active app links
     */
    List<AppLink> findAllOpenAppLinks();

    /**
     * Search for list of all app links currently inactive
     * @return              All inactive app links
     */
    List<AppLink> findAllClosedAppLinks();

    /**
     * Search for list of all app links in program
     * @return              All app links
     */
    List<AppLink> findAllAppLinks();

    /**
     * Close app link with given name
     * @param name          The name of the app link to be removed
     */
    void closeAppLink(String name);

    /**
     * Open app link with given name
     * @param name          The name of the app to be added
     */
    void openAppLink(String name);

}
