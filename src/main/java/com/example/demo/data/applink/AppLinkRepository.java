package com.example.demo.data.applink;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by ben chylla on 9/1/18.
 */
public interface AppLinkRepository extends MongoRepository<AppLink, String> {
    /**
     * Search for app link using its name
     * @param name          Name of app link
     * @return              The app link with the given name
     */
    AppLink findByName(String name); // find app link using its name
    
    /**
     * Search for all app links with given active status
     * @return              All app links with given active status
     */
    List<AppLink> findByIsActive(boolean isActive);

    /**
     * Search for all app links in program
     * @return              All app links
     */
    List<AppLink> findAll();

}
