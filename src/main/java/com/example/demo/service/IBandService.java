package com.example.demo.service;

import com.example.demo.model.Band;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBandService {
    Page<Band> findAll(Pageable pageable);
    List<Band> findAll();
    Band save(Band band);
    void deleteById(Long id);
    Optional<Band> findById(Long id);
}
