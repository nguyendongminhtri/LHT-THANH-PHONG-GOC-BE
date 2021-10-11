package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.security.userprincal.UserDetailService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;
    @Autowired
    UserDetailService userDetailService;
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category save(Category category) {
        User user = userDetailService.getCurrentUser();
        category.setUser(user);
        return categoryRepository.save(category);
    }

    @Override
    public Boolean existsByNameCategory(String nameCategory) {
        return categoryRepository.existsByNameCategory(nameCategory);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Page<Category> findAllByNameCategoryContaining(String nameCategory, Pageable pageable) {
        return categoryRepository.findAllByNameCategoryContaining(nameCategory, pageable);
    }

    @Override
    public Page<Category> findByNameCategoryQuery(String nameCategory, Pageable pageable) {
        return categoryRepository.findByNameCategoryQuery(nameCategory,pageable);
    }

}
