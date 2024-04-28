package com.julinar.siswaservice.mapper;

import com.julinar.siswaservice.bean.OrangTuaListBean;
import com.julinar.siswaservice.bean.OrangTuaRequestBean;
import com.julinar.siswaservice.bean.OrangTuaResponseBean;
import com.julinar.siswaservice.bean.SiswaListBean;
import com.julinar.siswaservice.model.OrangTua;
import com.julinar.siswaservice.model.Siswa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrangTuaMapper extends EntityMapper<OrangTuaRequestBean, OrangTua> {
    OrangTua toEntity(OrangTuaRequestBean requestBean);

    OrangTuaResponseBean toResponseBean(OrangTua orangTua);

    OrangTuaListBean toListBean(OrangTua orangTua);
}
