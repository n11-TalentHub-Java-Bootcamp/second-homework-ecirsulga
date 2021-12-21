package com.ecirsulga.springboot.dto;

import java.math.BigDecimal;
import java.util.Date;

public class UrunYorumByKullaniciDto {
    private String kullaniciAdi;
    private String kullaniciSoyadi;
    private String urunYorum;
    private Date yorumTarihi;

    public UrunYorumByKullaniciDto(String kullaniciAdi, String kullaniciSoyadi, String urunYorum, Date yorumTarihi) {
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciSoyadi = kullaniciSoyadi;
        this.urunYorum = urunYorum;
        this.yorumTarihi = yorumTarihi;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciSoyadi() {
        return kullaniciSoyadi;
    }

    public void setKullaniciSoyadi(String kullaniciSoyadi) {
        this.kullaniciSoyadi = kullaniciSoyadi;
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

    @Override
    public String toString() {
        return "UrunYorumForKullaniciDto{" +
                ", kullaniciAdi='" + kullaniciAdi + '\'' +
                ", kullaniciSoyadi='" + kullaniciSoyadi + '\'' +
                ", urunYorum='" + urunYorum + '\'' +
                ", yorumTarihi=" + yorumTarihi +
                '}';
    }
}
