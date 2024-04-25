package com.julinar.siswaservice.mapper;

import com.julinar.siswaservice.bean.OrangTuaRequestBean;
import com.julinar.siswaservice.bean.OrangTuaResponseBean;
import com.julinar.siswaservice.model.OrangTua;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrangTuaMapper extends EntityMapper<OrangTuaRequestBean, OrangTua> {
    OrangTua toEntity(OrangTuaRequestBean requestBean);

    OrangTuaResponseBean toResponseBean(OrangTua orangTua);
}
