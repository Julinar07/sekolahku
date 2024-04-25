package com.julinar.siswaservice.service;

import com.julinar.siswaservice.bean.OrangTuaResponseBean;
import com.julinar.siswaservice.bean.SiswaListBean;
import com.julinar.siswaservice.bean.SiswaRequestBean;
import com.julinar.siswaservice.bean.SiswaResponseBean;
import com.julinar.siswaservice.exception.BadRequestException;
import com.julinar.siswaservice.mapper.OrangTuaMapper;
import com.julinar.siswaservice.mapper.SiswaMapper;
import com.julinar.siswaservice.model.OrangTua;
import com.julinar.siswaservice.model.Siswa;
import com.julinar.siswaservice.repository.OrangTuaRepository;
import com.julinar.siswaservice.repository.SiswaRepository;
import com.julinar.siswaservice.validation.SiswaValidation;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SiswaService {
    private final SiswaRepository siswaRepo;
    private final SiswaMapper siswaMapper;
    private final OrangTuaMapper orangTuaMapper;
    private final OrangTuaRepository orangTuaRepository;

    @Autowired
    public SiswaService(SiswaRepository siswaRepo, SiswaMapper siswaMapper, OrangTuaMapper orangTuaMapper, OrangTuaRepository orangTuaRepository) {
        this.siswaRepo = siswaRepo;
        this.siswaMapper = siswaMapper;
        this.orangTuaMapper = orangTuaMapper;
        this.orangTuaRepository = orangTuaRepository;
    }

    @Transactional
    public SiswaResponseBean addSiswa(SiswaRequestBean requestBean) {
        SiswaValidation.validateAddSiswa(requestBean);
        Siswa siswa = siswaMapper.toEntity(requestBean);
        siswaRepo.save(siswa);

        List<OrangTuaResponseBean> orangTuaList = new ArrayList<>();
        requestBean.getOrangTuaList().forEach(orangTuaRequest -> {
            OrangTua ortu = orangTuaMapper.toEntity(orangTuaRequest);
            ortu.setSiswa(siswa);
            orangTuaRepository.save(ortu);

            orangTuaList.add(orangTuaMapper.toResponseBean(ortu));
        });

        return SiswaResponseBean.builder()
                .id(siswa.getId())
                .name(siswa.getName())
                .phoneNumber(siswa.getPhoneNumber())
                .address(siswa.getAddress())
                .orangTuaList(orangTuaList)
                .build();
    }

    @Transactional
    public SiswaResponseBean editSiswa(SiswaRequestBean requestBean) {
        Siswa siswa = siswaRepo.findById(requestBean.getId())
                .orElseThrow(() -> new BadRequestException("Siswa tidak ditemukan"));

        siswa.setName(requestBean.getName());
        siswa.setPhoneNumber(requestBean.getPhoneNumber());
        siswa.setAddress(requestBean.getAddress());
        siswaRepo.save(siswa);

        requestBean.getOrangTuaList().forEach(orangTuaBean -> {
            OrangTua orangTua = orangTuaRepository.findById(orangTuaBean.getId())
                    .orElseThrow(() -> new BadRequestException("Data orang tua siswa tidak ditemukan"));
            orangTua.setName(orangTuaBean.getName());
            orangTua.setPhoneNumber(orangTuaBean.getPhoneNumber());
            orangTua.setAddress(orangTuaBean.getAddress());
            orangTuaRepository.save(orangTua);
        });

        return SiswaResponseBean.builder()
                .id(siswa.getId())
                .name(siswa.getName())
                .phoneNumber(siswa.getPhoneNumber())
                .address(siswa.getAddress())
                .orangTuaList(siswa.getOrangTuas().stream().map(orangTuaMapper::toResponseBean).toList())
                .build();
    }

    @Transactional(readOnly = true)
    public Page<SiswaListBean> getAllSiswa(Pageable pageable, Optional<String> search) {
        Page<Siswa> siswaPage = siswaRepo.findAllByFilter(pageable, search.orElse(Strings.EMPTY));
        return siswaPage.map(siswaMapper::toListBean);
    }

    @Transactional(readOnly = true)
    public SiswaResponseBean detailSiswa(long id) {
        Siswa siswa = siswaRepo.findById(id).orElseThrow(() -> new BadRequestException("Siswa tidak ditemukan"));
        return SiswaResponseBean.builder()
                .id(siswa.getId())
                .name(siswa.getName())
                .phoneNumber(siswa.getPhoneNumber())
                .address(siswa.getAddress())
                .orangTuaList(siswa.getOrangTuas().stream().map(orangTuaMapper::toResponseBean).toList())
                .build();
    }
}
