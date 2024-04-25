package com.julinar.siswaservice.mapper;

import com.julinar.siswaservice.bean.SiswaListBean;
import com.julinar.siswaservice.bean.SiswaRequestBean;
import com.julinar.siswaservice.model.Siswa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SiswaMapper extends EntityMapper<SiswaRequestBean, Siswa> {
    SiswaListBean toListBean(Siswa siswa);
}
