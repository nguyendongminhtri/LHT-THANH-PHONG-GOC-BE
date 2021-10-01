package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String name); //Tim kiem User co ton tai trong DB khong?
    Boolean existsByUsername(String username); //username da co trong DB chua, khi tao du lieu
    Boolean existsByEmail(String email); //email da co trong DB chua
    User save(User user);
    Page<User> findAll(Pageable pageable); //Page User
    Optional<User> findById(Long id); //Detail 1 User theo ID
    void deleteById(Long id);
}
