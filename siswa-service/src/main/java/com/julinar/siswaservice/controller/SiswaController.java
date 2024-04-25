package com.julinar.siswaservice.controller;

import com.julinar.siswaservice.bean.GeneralWrapper;
import com.julinar.siswaservice.bean.SiswaListBean;
import com.julinar.siswaservice.bean.SiswaRequestBean;
import com.julinar.siswaservice.bean.SiswaResponseBean;
import com.julinar.siswaservice.service.SiswaService;
import com.julinar.siswaservice.util.SortableUnpaged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/siswa")
public class SiswaController {
    private final SiswaService siswaService;

    @Autowired
    public SiswaController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }

    @PostMapping("/add")
    public GeneralWrapper<SiswaResponseBean> addSiswa(@RequestBody SiswaRequestBean requestBean) {
        return new GeneralWrapper<SiswaResponseBean>().success(siswaService.addSiswa(requestBean));
    }

    @PutMapping("/edit")
    public GeneralWrapper<SiswaResponseBean> editSiswa(@RequestBody SiswaRequestBean requestBean) {
        return new GeneralWrapper<SiswaResponseBean>().success(siswaService.editSiswa(requestBean));
    }

    @GetMapping("")
    public GeneralWrapper<Page<SiswaListBean>> getAllSiswa(Pageable pageable,
                                                           @RequestParam(value = "unpaged", defaultValue = "false") boolean unpaged,
                                                           @RequestParam Optional<String> search) {
        pageable = unpaged ? new SortableUnpaged(pageable.getSort()) : pageable;
        return new GeneralWrapper<Page<SiswaListBean>>().success(siswaService.getAllSiswa(pageable, search));
    }

    @GetMapping("/{id}")
    public GeneralWrapper<SiswaResponseBean> detailSiswa(@PathVariable long id) {
        return new GeneralWrapper<SiswaResponseBean>().success(siswaService.detailSiswa(id));
    }
}
