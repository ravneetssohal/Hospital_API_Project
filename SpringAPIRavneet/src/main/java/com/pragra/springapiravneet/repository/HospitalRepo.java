package com.pragra.springapiravneet.repository;

import com.pragra.springapiravneet.entity.HospitalDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospitalRepo extends JpaRepository<HospitalDTO, Integer> {

    @Query(value = "SELECT nurse FROM HospitalDTO nurse WHERE nurse.nurseFirstName = ?1")
    public List<HospitalDTO> getByFirstName(String firstName);

}
