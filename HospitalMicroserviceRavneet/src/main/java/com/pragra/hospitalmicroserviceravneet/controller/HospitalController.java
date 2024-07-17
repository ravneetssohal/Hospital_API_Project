package com.pragra.hospitalmicroserviceravneet.controller;

import com.pragra.hospitalmicroserviceravneet.entity.HospitalDTO;
import com.pragra.hospitalmicroserviceravneet.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitalService")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @GetMapping("/all")
    public List<HospitalDTO> getAll(){
        return hospitalService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<HospitalDTO> addNurse(@RequestBody HospitalDTO hospitalDTO){
        return hospitalService.addNurse(hospitalDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteNurse(@RequestParam Integer id){
        return hospitalService.deleteNurse(id);
    }

    @GetMapping("/getByFirstName")
    public ResponseEntity<?> getByFirstName(@RequestParam String firstName){
        return hospitalService.getByFirstName(firstName);
    }
}
