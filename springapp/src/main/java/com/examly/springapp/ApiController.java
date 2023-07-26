package com.examly.springapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class ApiController{

    @Autowired
    private SpringappApplication app;

    @GetMapping("/")
    public ArrayList<Cricketer> getAllCricketers(){
        return app.cricketersList;
    }
}