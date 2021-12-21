package com.ecirsulga.springboot.converter;

import com.ecirsulga.springboot.dto.UrunYorumByKullaniciDto;
import com.ecirsulga.springboot.dto.UrunYorumDto;
import com.ecirsulga.springboot.entity.Kullanici;
import com.ecirsulga.springboot.entity.Urun;
import com.ecirsulga.springboot.entity.UrunYorum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-21T21:43:51+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.4 (JetBrains s.r.o)"
)
public class UrunYorumConverterImpl implements UrunYorumConverter {

    @Override
    public List<UrunYorumByKullaniciDto> convertAllUrunYorumListToUrunYorumDtoList(List<UrunYorum> urunYorumList) {
        if ( urunYorumList == null ) {
            return null;
        }

        List<UrunYorumByKullaniciDto> list = new ArrayList<UrunYorumByKullaniciDto>( urunYorumList.size() );
        for ( UrunYorum urunYorum : urunYorumList ) {
            list.add( urunYorumToUrunYorumByKullaniciDto( urunYorum ) );
        }

        return list;
    }

    @Override
    public UrunYorum convertUrunDtoToUrun(UrunYorumDto urunYorumDto) {
        if ( urunYorumDto == null ) {
            return null;
        }

        UrunYorum urunYorum = new UrunYorum();

        urunYorum.setKullanici( urunYorumDtoToKullanici( urunYorumDto ) );
        urunYorum.setUrun( urunYorumDtoToUrun( urunYorumDto ) );
        urunYorum.setYorum( urunYorumDto.getUrunYorum() );
        urunYorum.setId( urunYorumDto.getId() );
        urunYorum.setYorumTarihi( urunYorumDto.getYorumTarihi() );

        return urunYorum;
    }

    protected UrunYorumByKullaniciDto urunYorumToUrunYorumByKullaniciDto(UrunYorum urunYorum) {
        if ( urunYorum == null ) {
            return null;
        }

        Date yorumTarihi = null;

        yorumTarihi = urunYorum.getYorumTarihi();

        String kullaniciAdi = null;
        String kullaniciSoyadi = null;
        String urunYorum1 = null;

        UrunYorumByKullaniciDto urunYorumByKullaniciDto = new UrunYorumByKullaniciDto( kullaniciAdi, kullaniciSoyadi, urunYorum1, yorumTarihi );

        return urunYorumByKullaniciDto;
    }

    protected Kullanici urunYorumDtoToKullanici(UrunYorumDto urunYorumDto) {
        if ( urunYorumDto == null ) {
            return null;
        }

        Kullanici kullanici = new Kullanici();

        kullanici.setId( urunYorumDto.getKullaniciId() );

        return kullanici;
    }

    protected Urun urunYorumDtoToUrun(UrunYorumDto urunYorumDto) {
        if ( urunYorumDto == null ) {
            return null;
        }

        Urun urun = new Urun();

        urun.setId( urunYorumDto.getUrunId() );

        return urun;
    }
}
