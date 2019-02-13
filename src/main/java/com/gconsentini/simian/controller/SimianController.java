package com.gconsentini.simian.controller;

//import org.omg.CORBA.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
import com.gconsentini.simian.model.dto.SimianDto;
import com.gconsentini.simian.model.dto.StatsDto;
import com.gconsentini.simian.service.SimianService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Verifica se um DNA é simio")
    @PostMapping("/simian")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 403, message = "Forbidden")
    })
    public ResponseEntity isSimian(@RequestBody SimianDto simianDto){
        if (!simianService.isSimian(simianDto))
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "Verifica os status de todos os dnas verificados", response = StatsDto.class)
    @GetMapping("/stats")
    @ApiResponse(code = 200, message = "Success", response = StatsDto.class)
    public StatsDto getStats(){
        return simianService.getStats();
    }

}
