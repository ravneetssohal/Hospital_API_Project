package com.pragra.hospitalmicroserviceravneet.service;

import com.pragra.hospitalmicroserviceravneet.entity.HospitalDTO;
import com.pragra.hospitalmicroserviceravneet.httpClient.HospitalClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public class HospitalService {
    @Autowired
    HospitalClient hospitalClient;

    public List<HospitalDTO> getAll(){
        return hospitalClient.getAll();
    }

    public ResponseEntity<HospitalDTO> addNurse(HospitalDTO hospitalDTO){
        return hospitalClient.addNurse(hospitalDTO);
    }

    public ResponseEntity<String> deleteNurse(Integer id){
        try {
            ResponseEntity<String> response = hospitalClient.deleteNurse(id);
            return response;
        }catch (FeignException e){
            if(e.status() == 404){
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Not Found!");
            }
        }
        return hospitalClient.deleteNurse(id);
    }

    public ResponseEntity<?> getByFirstName(String firstName){
        try {
            ResponseEntity<?> response = hospitalClient.getByFirstName(firstName);
            return response;
        }catch (FeignException e){
            if(e.status() == 404){
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Not Found!");
            }
        }
        return hospitalClient.getByFirstName(firstName);
    }
}
