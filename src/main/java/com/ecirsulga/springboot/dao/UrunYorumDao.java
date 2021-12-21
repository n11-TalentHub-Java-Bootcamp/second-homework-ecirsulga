package com.ecirsulga.springboot.dao;

import com.ecirsulga.springboot.entity.UrunYorum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UrunYorumDao extends JpaRepository<UrunYorum,Long> {

    @Query("select urunyorum from UrunYorum urunyorum where urunyorum.kullanici.id = ?1")
    List<UrunYorum> findByUserId(Long id);

    @Query("select urunyorum from UrunYorum urunyorum where urunyorum.urun.id = ?1")
    List<UrunYorum> findByProductId(Long id);

}
