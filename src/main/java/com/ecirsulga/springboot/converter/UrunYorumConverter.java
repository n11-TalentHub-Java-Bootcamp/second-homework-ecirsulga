package com.ecirsulga.springboot.converter;

import com.ecirsulga.springboot.dto.UrunYorumByKullaniciDto;
import com.ecirsulga.springboot.dto.UrunYorumDto;
import com.ecirsulga.springboot.entity.UrunYorum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UrunYorumConverter {
    UrunYorumConverter INSTANCE = Mappers.getMapper(UrunYorumConverter.class);

    @Mapping(source = "telefon", target = "telefon")
    List<UrunYorumByKullaniciDto> convertAllUrunYorumListToUrunYorumDtoList(List<UrunYorum> urunYorumList);

    @Mapping(source = "kullaniciId", target = "kullanici.id")
    @Mapping(source = "urunId", target = "urun.id")
    @Mapping(source = "urunYorum", target = "yorum")
    UrunYorum convertUrunDtoToUrun(UrunYorumDto urunYorumDto);

}
