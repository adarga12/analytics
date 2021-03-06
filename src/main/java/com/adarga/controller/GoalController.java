package com.adarga.controller;

import com.adarga.domain.Goal;
import com.adarga.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Controller for collection of Goals
 * Created by cbolton on 6/14/17.
 */

@RestController
@RequestMapping("/Goals")
public class GoalController {

    @Autowired
    private AnalyticsService service;

    @RequestMapping(method= RequestMethod.GET)
    public ArrayList<Goal> getGoals() {
        return service.getGoals();
    }

    @RequestMapping(method= RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE)
    public void updateGoal(@RequestBody Goal goal) throws NotImplementedException {
        service.updateGoal(goal);
    }

    @RequestMapping(method= RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public void addGoal(@RequestBody Goal goal) {
        service.addGoal(goal);
    }

    @RequestMapping(method= RequestMethod.DELETE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public void deleteGoal(@RequestBody Goal goal) {
        service.deleteGoal(goal);
    }

}
