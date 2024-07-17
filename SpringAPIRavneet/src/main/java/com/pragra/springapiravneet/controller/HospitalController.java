package com.pragra.springapiravneet.controller;

import com.pragra.springapiravneet.entity.HospitalDTO;
import com.pragra.springapiravneet.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<HospitalDTO> all = hospitalService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Status", "905")
                .header("Content-Type", "application/json")
                .body(all);
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

    @GetMapping("/viewByPage")
    public Page<HospitalDTO> getByPage(@RequestParam Integer page){
        return hospitalService.getByPage(page);
    }

    @PatchMapping("/updateNurse")
    public ResponseEntity<?> updateNurse(@RequestBody HospitalDTO hospitalDTO, @RequestParam Integer id){
        return hospitalService.updateNurse(hospitalDTO, id);
    }

}
