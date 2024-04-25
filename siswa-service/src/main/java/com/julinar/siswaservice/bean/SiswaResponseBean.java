package com.julinar.siswaservice.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class SiswaResponseBean {
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    private List<OrangTuaResponseBean> orangTuaList;
}
