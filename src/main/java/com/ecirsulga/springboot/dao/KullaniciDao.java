package com.ecirsulga.springboot.dao;

import com.ecirsulga.springboot.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KullaniciDao extends JpaRepository<Kullanici,Long> {

    @Query("select kullanici from Kullanici kullanici where kullanici.kullaniciAdi = ?1")
    Kullanici findByUserName(String userName);

    @Query("select kullanici from Kullanici kullanici where kullanici.telefon = ?1")
    Kullanici findByUserPhone(String userPhone);


}
