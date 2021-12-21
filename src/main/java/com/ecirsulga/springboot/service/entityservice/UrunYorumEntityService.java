package com.ecirsulga.springboot.service.entityservice;

import com.ecirsulga.springboot.dao.KullaniciDao;
import com.ecirsulga.springboot.dao.UrunDao;
import com.ecirsulga.springboot.dao.UrunYorumDao;
import com.ecirsulga.springboot.dto.UrunYorumByKullaniciDto;
import com.ecirsulga.springboot.dto.UrunYorumByUrunDto;
import com.ecirsulga.springboot.entity.Kullanici;
import com.ecirsulga.springboot.entity.Urun;
import com.ecirsulga.springboot.entity.UrunYorum;
import com.ecirsulga.springboot.exception.UrunYorumNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UrunYorumEntityService {
    @Autowired
    private UrunYorumDao urunYorumDao;
    @Autowired
    private KullaniciDao kullaniciDao;

    @Autowired
    private UrunDao urunDao;

    public List<UrunYorum> findAll() {
        return urunYorumDao.findAll();
    }

    public UrunYorum save(UrunYorum urunYorum){
        urunYorum = urunYorumDao.save(urunYorum);

        return urunYorum;
    }

    public List<UrunYorumByKullaniciDto> findAllCommentsByUserId(Long id) {
        Optional<Kullanici> kullaniciOptional = kullaniciDao.findById(id);
        Kullanici kullanici = null;
        if (kullaniciOptional.isPresent()){
            kullanici = kullaniciOptional.get();
        }
        if(kullanici == null)
            throw new UrunYorumNotFoundException(id + " kullanici idsi ile aranan kullanıcı databasede bulunamadı !");

        List<UrunYorum> urunYorumList = urunYorumDao.findByUserId(kullanici.getId());

        if(urunYorumList.size() == 0)
            throw new UrunYorumNotFoundException(id + " kullanici idli kullanıcı henüz bir yorum yapmamıştır !");


        List<UrunYorumByKullaniciDto> urunYorumByKullaniciDtoList = convertAllUrunYorumDtosByKullanici(urunYorumList,kullanici);

        return urunYorumByKullaniciDtoList;
    }

    private List<UrunYorumByKullaniciDto> convertAllUrunYorumDtosByKullanici(List<UrunYorum> urunYorumList, Kullanici kullanici)
    {
        List<UrunYorumByKullaniciDto> urunYorumByKullaniciDtoList = new LinkedList<UrunYorumByKullaniciDto>();

        for (int i=0;i<urunYorumList.size();i++)
        {
            UrunYorum urunYorum = urunYorumList.get(i);
            UrunYorumByKullaniciDto urunYorumByKullaniciDto = new UrunYorumByKullaniciDto(kullanici.getAdi(), kullanici.getSoyadi(), urunYorum.getYorum(), urunYorum.getYorumTarihi());
            urunYorumByKullaniciDtoList.add(urunYorumByKullaniciDto);
        }
        return urunYorumByKullaniciDtoList;
    }

    public List<UrunYorumByUrunDto> findAllCommentsByProductId(Long id) {
        Optional<Urun> urunOptional = urunDao.findById(id);
        Urun urun = null;
        if (urunOptional.isPresent()){
            urun = urunOptional.get();
        }
        if(urun == null)
            throw new UrunYorumNotFoundException(id + " urun idsi ile aranan urun databasede bulunamadı !");

        List<UrunYorum> urunYorumList = urunYorumDao.findByProductId(urun.getId());

        if(urunYorumList.size() == 0)
            throw new UrunYorumNotFoundException(id + " urun idli urune henüz bir yorum yapmamıştır !");

        List<UrunYorumByUrunDto> urunYorumDtoList = convertAllUrunYorumDtosByUrun(urunYorumList,urun);

        return urunYorumDtoList;
    }

    private List<UrunYorumByUrunDto> convertAllUrunYorumDtosByUrun(List<UrunYorum> urunYorumList, Urun urun) {
        List<UrunYorumByUrunDto> urunYorumByUrunDtoList = new LinkedList<UrunYorumByUrunDto>();

        for (int i=0;i<urunYorumList.size();i++)
        {
            UrunYorum urunYorum = urunYorumList.get(i);
            UrunYorumByUrunDto urunYorumDto = new UrunYorumByUrunDto(urun.getAdi(), urun.getFiyat(), urunYorum.getYorum(), urunYorum.getYorumTarihi());
            urunYorumByUrunDtoList.add(urunYorumDto);
        }
        return urunYorumByUrunDtoList;
    }

    public void deleteById(Long id) {
        urunYorumDao.deleteById(id);
    }
}
