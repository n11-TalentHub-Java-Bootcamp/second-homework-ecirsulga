package com.ecirsulga.springboot.dto;

import com.ecirsulga.springboot.entity.Kullanici;
import com.ecirsulga.springboot.entity.Urun;

import java.util.Date;

public class UrunYorumDto {
    private Long id;
    private String urunYorum;
    private Date yorumTarihi;
    private Long kullaniciId;
    private Long urunId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrunYorum() {
        return urunYorum;
    }

    public void setUrunYorum(String urunYorum) {
        this.urunYorum = urunYorum;
    }

    public Date getYorumTarihi() {
        return yorumTarihi;
    }

    public void setYorumTarihi(Date yorumTarihi) {
        this.yorumTarihi = yorumTarihi;
    }

    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public Long getUrunId() {
        return urunId;
    }

    public void setUrunId(Long urunId) {
        this.urunId = urunId;
    }
}
