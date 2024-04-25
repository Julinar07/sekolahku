package com.julinar.siswaservice.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SiswaRequestBean {
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    private List<OrangTuaRequestBean> orangTuaList;
}
