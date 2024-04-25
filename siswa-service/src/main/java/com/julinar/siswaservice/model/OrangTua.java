package com.julinar.siswaservice.model;

import com.julinar.siswaservice.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OrangTua extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    private Siswa siswa;
}
