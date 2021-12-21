package com.ecirsulga.springboot.controller;

import com.ecirsulga.springboot.converter.KullaniciConverter;
import com.ecirsulga.springboot.dto.KullaniciDto;
import com.ecirsulga.springboot.entity.Kullanici;
import com.ecirsulga.springboot.service.entityservice.KullaniciEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/kullanicilar")
public class KullaniciController {

    @Autowired
    private KullaniciEntityService kullaniciEntityService;

    @GetMapping("")
    public List<KullaniciDto> findAll(){

        List<Kullanici> kullaniciList = kullaniciEntityService.findAll();
        List<KullaniciDto> kullaniciDtoList = KullaniciConverter.INSTANCE.convertAllKullaniciListToKullaniciDtoList(kullaniciList);
        return kullaniciDtoList;
    }
    @GetMapping("/{id}")
    public KullaniciDto findById(@PathVariable Long id){

        Kullanici kullanici = kullaniciEntityService.findById(id);
        KullaniciDto kullaniciDto = KullaniciConverter.INSTANCE.convertKullaniciToKullaniciDto(kullanici);
        return kullaniciDto;
    }

    @GetMapping("/byName/{userName}")
    public KullaniciDto findByUserName(@PathVariable String userName){

        Kullanici kullanici = kullaniciEntityService.findByUserName(userName);
        KullaniciDto kullaniciDto = KullaniciConverter.INSTANCE.convertKullaniciToKullaniciDto(kullanici);
        return kullaniciDto;
    }

    @GetMapping("/byPhone/{userPhone}")
    public KullaniciDto findByUserPhone(@PathVariable String userPhone){

        Kullanici kullanici = kullaniciEntityService.findByUserPhone(userPhone);
        KullaniciDto kullaniciDto = KullaniciConverter.INSTANCE.convertKullaniciToKullaniciDto(kullanici);
        return kullaniciDto;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody KullaniciDto kullaniciDto){ //TODO: Input değeri dto tipinde olmalı

        Kullanici kullanici = KullaniciConverter.INSTANCE.convertKullaniciDtoToKullanici(kullaniciDto);

        kullanici = kullaniciEntityService.save(kullanici);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(kullanici.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{userName}/{userPhone}")
    public void delete(@PathVariable String userName, @PathVariable String userPhone){

        kullaniciEntityService.deleteByUserNameAndPhone(userName, userPhone);
    }

    @PutMapping("")
    public KullaniciDto update(@RequestBody KullaniciDto kullaniciDto){//TODO: Input değeri dto tipinde olmalı

        Kullanici kullanici = KullaniciConverter.INSTANCE.convertKullaniciDtoToKullanici(kullaniciDto);

        kullanici = kullaniciEntityService.save(kullanici);

        KullaniciDto kategoriDtoResult = KullaniciConverter.INSTANCE.convertKullaniciToKullaniciDto(kullanici);

        return kategoriDtoResult;
    }



}
