package com.example.demo.service;

import com.example.demo.model.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISingerService {
    Page<Singer> findAll(Pageable pageable);
    List<Singer> findAll();
    Optional<Singer> findById(Long id);
    Singer save(Singer singer);
    void deleteById(Long id);
}
