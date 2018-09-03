package com.example.demo.controller;

import com.example.demo.data.applink.AppLink;
import com.example.demo.data.applink.AppLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ben chylla on 9/1/18.
 */
@RestController
public class AppLinkController {

    @Autowired
    AppLinkService alService;
    
    @RequestMapping(value="/getAppLink", method=RequestMethod.GET)
    public AppLink getAppLink(@RequestParam(value="appName") String appName) {
        return alService.findAppLinkByName(appName);
    }

    @RequestMapping(value="/getAllAppLinks", method=RequestMethod.GET)
    public List<AppLink> getAllAppLinks() {
        return alService.findAllAppLinks();
    }

}
