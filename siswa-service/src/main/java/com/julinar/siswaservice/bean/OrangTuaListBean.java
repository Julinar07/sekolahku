package com.julinar.siswaservice.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class OrangTuaListBean {
    private long id;
    private String name;
    private String phoneNumber;
}
