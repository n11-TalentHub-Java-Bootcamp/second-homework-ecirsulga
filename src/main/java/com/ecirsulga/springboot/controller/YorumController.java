package com.ecirsulga.springboot.controller;

import com.ecirsulga.springboot.converter.UrunYorumConverter;
import com.ecirsulga.springboot.dto.UrunYorumByKullaniciDto;
import com.ecirsulga.springboot.dto.UrunYorumByUrunDto;
import com.ecirsulga.springboot.dto.UrunYorumDto;
import com.ecirsulga.springboot.entity.UrunYorum;
import com.ecirsulga.springboot.service.entityservice.UrunYorumEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/yorumlar")
public class YorumController {

    @Autowired
    private UrunYorumEntityService urunYorumEntityService;


    @GetMapping("/ByUserId/{id}")
    public List<UrunYorumByKullaniciDto> findAllCommentsByUserId(@PathVariable Long id){

        List<UrunYorumByKullaniciDto> urunYorumByKullaniciDtoList = urunYorumEntityService.findAllCommentsByUserId(id);

        return urunYorumByKullaniciDtoList;
    }

    @GetMapping("/ByUrunId/{id}")
    public List<UrunYorumByUrunDto> findAllCommentsByProductId(@PathVariable Long id){

        List<UrunYorumByUrunDto> urunYorumByUrunDtoList = urunYorumEntityService.findAllCommentsByProductId(id);

        return urunYorumByUrunDtoList;
    }

    @PostMapping("")
    public ResponseEntity<Object> saveUrunYorum(@RequestBody UrunYorumDto urunYorumDto){

        UrunYorum urunYorum = UrunYorumConverter.INSTANCE.convertUrunDtoToUrun(urunYorumDto);

        urunYorum = urunYorumEntityService.save(urunYorum);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(urunYorum.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public void deleteUrunYorum(@PathVariable Long id){

        urunYorumEntityService.deleteById(id);
    }



}
