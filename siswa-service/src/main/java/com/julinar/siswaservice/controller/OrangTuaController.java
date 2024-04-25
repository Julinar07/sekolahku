package com.julinar.siswaservice.controller;

import com.julinar.siswaservice.bean.*;
import com.julinar.siswaservice.service.OrangTuaService;
import com.julinar.siswaservice.util.SortableUnpaged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/orang-tua")
public class OrangTuaController {
    private final OrangTuaService orangTuaService;

    @Autowired
    public OrangTuaController(OrangTuaService orangTuaService) {
        this.orangTuaService = orangTuaService;
    }

    @PutMapping("/edit")
    public GeneralWrapper<OrangTuaResponseBean> editOrangTua(@RequestBody OrangTuaRequestBean requestBean) {
        return new GeneralWrapper<OrangTuaResponseBean>().success(orangTuaService.editOrangTua(requestBean));
    }

    @GetMapping("")
    public GeneralWrapper<Page<OrangTuaListBean>> getAllOrangTua(Pageable pageable,
                                                                 @RequestParam(value = "unpaged", defaultValue = "false") boolean unpaged,
                                                                 @RequestParam Optional<String> search) {
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;
        return new GeneralWrapper<Page<OrangTuaListBean>>().success(orangTuaService.getAllOrangTua(pageable, search));
    }

    @GetMapping("/{id}")
    public GeneralWrapper<OrangTuaResponseBean> detailOrangTua(@PathVariable long id) {
        return new GeneralWrapper<OrangTuaResponseBean>().success(orangTuaService.detailOrangTua(id));
    }
}
