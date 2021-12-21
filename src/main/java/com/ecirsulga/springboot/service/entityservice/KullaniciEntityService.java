package com.ecirsulga.springboot.service.entityservice;

import com.ecirsulga.springboot.dao.KullaniciDao;
import com.ecirsulga.springboot.entity.Kullanici;
import com.ecirsulga.springboot.exception.KullaniciNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KullaniciEntityService {
    @Autowired
    private KullaniciDao kullaniciDao;

    public List<Kullanici> findAll(){
        return (List<Kullanici>) kullaniciDao.findAll();
    }

    public Kullanici findById(Long id){
        Optional<Kullanici> optionalKullanici = kullaniciDao.findById(id);

        Kullanici kullanici = null;
        if (optionalKullanici.isPresent()){
            kullanici = optionalKullanici.get();
        }

        return kullanici;
    }

    public Kullanici findByUserName(String userName){
        Kullanici kullanici = kullaniciDao.findByUserName(userName);

        return kullanici;
    }

    public Kullanici findByUserPhone(String userPhone){
        Kullanici kullanici = kullaniciDao.findByUserPhone(userPhone);

        return kullanici;
    }

    public Kullanici save(Kullanici kullanici){
        return kullaniciDao.save(kullanici);
    }

    public void delete(Kullanici kullanici){
        kullaniciDao.delete(kullanici);
    }

    public void deleteById(Long id){
        kullaniciDao.deleteById(id);
    }

    public long count(){
        return kullaniciDao.count();
    }

    public void deleteByUserNameAndPhone(String userName,String userPhone)
    {
        Kullanici firstFoundUser = findByUserName(userName);
        Kullanici secondFoundUser = findByUserPhone(userPhone);
        if(firstFoundUser == null)
            throw new KullaniciNotFoundException(userName + " kullanici adi ile aranan kullanıcı databasede bulunamadı !");
        if(secondFoundUser == null)
            throw new KullaniciNotFoundException(userPhone + " kullanici telefonu ile aranan kullanıcı databasede bulunamadı !");
        if(firstFoundUser.getId() != secondFoundUser.getId())
            throw new KullaniciNotFoundException(userName + " kullanici adi ile " + userPhone +" telefon bilgileri uyuşmamaktadır.");
        else {
            delete(firstFoundUser);
        }

    }

}
