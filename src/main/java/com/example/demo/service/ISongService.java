package com.example.demo.service;

import com.example.demo.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);
    Song save(Song song);
    Optional<Song> findById(Long id);
    void deleteById(Long id);
}
