package com.gconsentini.simian.controller;

import com.gconsentini.simian.model.Simian;
//import org.omg.CORBA.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
import com.gconsentini.simian.service.SimianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimianController {

//    @Autowired
//    private Environment environment;

    @Autowired
    private SimianService simianService;

    @PostMapping("/simian")
    public ResponseEntity isSimian(@RequestBody Simian simian){
        System.out.println(simian);
        if (!simianService.isSimian(simian.getDna().toArray(new String[0])))
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        return new ResponseEntity(HttpStatus.OK);
    }

}
