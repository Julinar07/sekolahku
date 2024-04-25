package com.julinar.siswaservice.repository;

import com.julinar.siswaservice.model.Siswa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepository extends CrudRepository<Siswa, Long> {
    @Query(nativeQuery = true,
            value = "select * from {h-schema}siswa where (:search = '' or name like concat('%',:search,'%')) ")
    Page<Siswa> findAllByFilter(Pageable pageable, String search);
}
