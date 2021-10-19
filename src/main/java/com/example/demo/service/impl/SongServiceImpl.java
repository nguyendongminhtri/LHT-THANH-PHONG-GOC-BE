package com.example.demo.service.impl;

import com.example.demo.model.Song;
import com.example.demo.model.User;
import com.example.demo.repository.ISongRepository;
import com.example.demo.security.userprincal.UserDetailService;
import com.example.demo.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    ISongRepository songRepository;
    @Autowired
    UserDetailService userDetailService;

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public Song save(Song song) {
        User user = userDetailService.getCurrentUser();
        song.setUser(user);
        return songRepository.save(song);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }
}
