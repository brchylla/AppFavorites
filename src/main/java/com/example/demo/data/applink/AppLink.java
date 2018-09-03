package com.example.demo.data.applink;

import java.net.URL;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by ben chylla on 9/1/18.
 */
public class AppLink {
    @Id
    String _id; // Used to access the ObjectID in the repository
    @Indexed
    private String name; // name of app
    private String description; // description of app
    private String color; // color of shape containing app link
    private boolean defaultStatus; // whether the link is active by default
    private URL link; // link of app

    public AppLink(String name, String description, String color, boolean defaultStatus, URL link) {
        this.name = name;
        this.description = description;
        this.color = color;
        this.defaultStatus = defaultStatus;
        this.link = link;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getColor() {
        return this.color;
    }

    public boolean getDefaultStatus() {
        return this.defaultStatus;
    }

    public URL getLink() {
        return this.link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLink(URL link) {
        this.link = link;
    }
    
    @Override
    public String toString() {
    	return name;
    }

}