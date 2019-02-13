package com.gconsentini.simian.controller;

//import org.omg.CORBA.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
import com.gconsentini.simian.model.dto.SimianDto;
import com.gconsentini.simian.model.dto.StatsDto;
import com.gconsentini.simian.service.SimianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity isSimian(@RequestBody SimianDto simianDto){
        if (!simianService.isSimian(simianDto))
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/stats")
    public StatsDto getStats(){
        return simianService.getStats();
    }

}
