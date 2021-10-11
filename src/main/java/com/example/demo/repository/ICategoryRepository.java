package com.example.demo.repository;

import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Boolean existsByNameCategory(String nameCategory);
    //Cach 1 : Dung ham co san cua tang Repository
    Page<Category> findAllByNameCategoryContaining(String nameCategory, Pageable pageable);

    //Cach 2: Tu trien khai @Query
    @Query("SELECT c FROM Category AS c WHERE c.nameCategory LIKE CONCAT('%',:nameCategory,'%')")
    Page<Category> findByNameCategoryQuery(@Param("nameCategory") String nameCategory, Pageable pageable);
}
