package com.pragra.hospitalmicroserviceravneet.httpClient;

import com.pragra.hospitalmicroserviceravneet.entity.HospitalDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "hospitalClient", url = "http://localhost:8080/hospital")
public interface HospitalClient {
    @GetMapping("/all")
    List<HospitalDTO> getAll();

    @PostMapping("/add")
    ResponseEntity<HospitalDTO> addNurse(@RequestBody HospitalDTO hospitalDTO);

    @DeleteMapping("/delete")
    ResponseEntity<String> deleteNurse(@RequestParam Integer id);

    @GetMapping("/getByFirstName")
    ResponseEntity<?> getByFirstName(@RequestParam String firstName);
}
