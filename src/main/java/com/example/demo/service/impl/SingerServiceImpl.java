package com.example.demo.service.impl;

import com.example.demo.model.Singer;
import com.example.demo.model.User;
import com.example.demo.repository.ISingerRepository;
import com.example.demo.security.userprincal.UserDetailService;
import com.example.demo.service.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SingerServiceImpl implements ISingerService {
    @Autowired
    ISingerRepository singerRepository;
    @Autowired
    UserDetailService userDetailService;
    @Override
    public Page<Singer> findAll(Pageable pageable) {
        return singerRepository.findAll(pageable);
    }

    @Override
    public List<Singer> findAll() {
        return singerRepository.findAll();
    }

    @Override
    public Optional<Singer> findById(Long id) {
        return singerRepository.findById(id);
    }

    @Override
    public Singer save(Singer singer) {
        User user = userDetailService.getCurrentUser();
        singer.setUser(user);
        return singerRepository.save(singer);
    }

    @Override
    public void deleteById(Long id) {
        singerRepository.deleteById(id);
    }
}
