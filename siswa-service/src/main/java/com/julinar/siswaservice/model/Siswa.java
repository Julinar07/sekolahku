package com.julinar.siswaservice.model;

import com.julinar.siswaservice.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Siswa extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    @OneToMany(mappedBy = "siswa")
    private List<OrangTua> orangTuas;
}
