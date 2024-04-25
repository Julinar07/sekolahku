package com.julinar.siswaservice.service;

import com.julinar.siswaservice.bean.OrangTuaRequestBean;
import com.julinar.siswaservice.bean.OrangTuaResponseBean;
import com.julinar.siswaservice.mapper.OrangTuaMapper;
import com.julinar.siswaservice.repository.OrangTuaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrangTuaService {
    private final OrangTuaRepository orangTuaRepo;
    private final OrangTuaMapper orangTuaMapper;

    @Autowired
    public OrangTuaService(OrangTuaRepository orangTuaRepo, OrangTuaMapper orangTuaMapper) {
        this.orangTuaRepo = orangTuaRepo;
        this.orangTuaMapper = orangTuaMapper;
    }

    @Transactional
    public OrangTuaResponseBean editOrangTua(OrangTuaRequestBean requestBean) {
        
    }

}
