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
    public AppLink getAppLink(@RequestParam(value="name") String name) {
        return alService.findAppLinkByName(name);
    }

    @RequestMapping(value="/getOpenAppLinks", method=RequestMethod.GET)
    public List<AppLink> getOpenAppLinks() {
        return alService.findAllOpenAppLinks();
    }

    @RequestMapping(value="/getClosedAppLinks", method=RequestMethod.GET)
    public List<AppLink> getClosedAppLinks() {
        return alService.findAllClosedAppLinks();
    }

    @RequestMapping(value="/getAllAppLinks", method=RequestMethod.GET)
    public List<AppLink> getAllAppLinks() {
        return alService.findAllAppLinks();
    }

    @RequestMapping(value="/removeAppLink", method=RequestMethod.GET)
    public List<AppLink> removeAppLink(@RequestParam(value="name") String name) {
        alService.closeAppLink(name);
        return alService.findAllAppLinks();
    }

    @RequestMapping(value="/addAppLink", method=RequestMethod.GET)
    public List<AppLink> addAppLink(@RequestParam(value="name") String name) {
        alService.openAppLink(name);
        return alService.findAllAppLinks();
    }

}
