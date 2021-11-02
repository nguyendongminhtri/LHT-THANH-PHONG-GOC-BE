package com.example.demo.service.impl;

import com.example.demo.model.Band;
import com.example.demo.model.User;
import com.example.demo.repository.IBandRepository;
import com.example.demo.security.userprincal.UserDetailService;
import com.example.demo.service.IBandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandServiceImpl implements IBandService {
    @Autowired
    UserDetailService userDetailService;
    @Autowired
    IBandRepository bandRepository;
    @Override
    public Page<Band> findAll(Pageable pageable) {
        return bandRepository.findAll(pageable);
    }

    @Override
    public List<Band> findAll() {
        return bandRepository.findAll();
    }

    @Override
    public Band save(Band band) {
        User user = userDetailService.getCurrentUser();
        band.setUser(user);
        return bandRepository.save(band);
    }

    @Override
    public void deleteById(Long id) {
        bandRepository.deleteById(id);
    }

    @Override
    public Optional<Band> findById(Long id) {
        return bandRepository.findById(id);
    }
}
