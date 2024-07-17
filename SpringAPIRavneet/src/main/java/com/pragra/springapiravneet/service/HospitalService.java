package com.pragra.springapiravneet.service;

import com.pragra.springapiravneet.repository.HospitalRepo;
import com.pragra.springapiravneet.entity.HospitalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepo hospitalRepo;

    public List<HospitalDTO> getAll(){
        return hospitalRepo.findAll();
    }


    public ResponseEntity<HospitalDTO> addNurse(HospitalDTO hospitalDTO){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(hospitalDTO.getNursePassword());
        hospitalDTO.setNursePassword(encodedPassword);
        hospitalRepo.save(hospitalDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hospitalDTO);
    }

    public ResponseEntity<String> deleteNurse(Integer id){
        Optional<HospitalDTO> byNurseID = hospitalRepo.findById(id);
        if(byNurseID.isPresent()){
            hospitalRepo.deleteById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Deleted Successfully");
        }else
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Not Found!");
    }

    public ResponseEntity<?> getByFirstName(String firstName){
        List<HospitalDTO> byFirstName = hospitalRepo.getByFirstName(firstName);
        if(byFirstName.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Not Found!");
        }else
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(byFirstName);
    }

    public Page<HospitalDTO> getByPage(Integer page){
        Pageable pageable = PageRequest.of(page, 5);
        return hospitalRepo.findAll(pageable);
    }

    public ResponseEntity<?> updateNurse(HospitalDTO hospitalDTO, Integer id){
        Optional<HospitalDTO> byId = hospitalRepo.findById(id);

        if(byId.isPresent()){
            HospitalDTO nurseById = byId.get();

            if(hospitalDTO.getNurseFirstName() != null){
                nurseById.setNurseFirstName(hospitalDTO.getNurseFirstName());
            }

            if(hospitalDTO.getNursePassword() != null){
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Unauthorized!");
            }

            if(hospitalDTO.getNurseLastName() != null){
                nurseById.setNurseLastName(hospitalDTO.getNurseLastName());
            }

            if(hospitalDTO.getNursePhoneNo() != null){
                nurseById.setNursePhoneNo(hospitalDTO.getNursePhoneNo());
            }

            if(hospitalDTO.getNurseSalary() != null){
                nurseById.setNurseSalary(hospitalDTO.getNurseSalary());
            }

            hospitalRepo.save(nurseById);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Updated Successfully");
        }else
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Not Found!");


    }
}
