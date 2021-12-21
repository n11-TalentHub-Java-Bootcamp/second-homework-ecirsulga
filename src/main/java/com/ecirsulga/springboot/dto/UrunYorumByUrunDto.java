package com.ecirsulga.springboot.dto;

import java.math.BigDecimal;
import java.util.Date;

public class UrunYorumByUrunDto {

    private String urunAdi;
    private BigDecimal urunFiyati;
    private String urunYorum;
    private Date yorumTarihi;

    public UrunYorumByUrunDto(String urunAdi, BigDecimal urunFiyati, String urunYorum, Date yorumTarihi) {
        this.urunAdi = urunAdi;
        this.urunFiyati = urunFiyati;
        this.urunYorum = urunYorum;
        this.yorumTarihi = yorumTarihi;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public BigDecimal getUrunFiyati() {
        return urunFiyati;
    }

    public void setUrunFiyati(BigDecimal urunFiyati) {
        this.urunFiyati = urunFiyati;
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
}
