package com.example.demo.controller;

import com.example.demo.dto.response.ResponMessage;
import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.security.userprincal.UserDetailService;
import com.example.demo.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("category")
@RestController
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;
    @Autowired
    UserDetailService userDetailService;
    @GetMapping
    public ResponseEntity<?> pageCategory(@PageableDefault(sort = "nameCategory", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Category> categoryPage = categoryService.findAll(pageable);
        if(categoryPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        User user = userDetailService.getCurrentUser();
        if(!user.getUsername().equals("Anonymous")){
            if(categoryService.existsByNameCategory(category.getNameCategory())){
                return new ResponseEntity<>(new ResponMessage("no_name_category"), HttpStatus.OK);
            }
            if(category.getAvatarCategory()==null){
                return new ResponseEntity<>(new ResponMessage("no_avatar-category"),HttpStatus.OK);
            }
            categoryService.save(category);
            return new ResponseEntity<>(new ResponMessage("yes"), HttpStatus.OK);
        }
       return new ResponseEntity<>(new ResponMessage("create_failed"), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if(!category.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.deleteById(category.get().getId());
        return new ResponseEntity<>(new ResponMessage("Delete Success!"), HttpStatus.OK);
    }
    //Cach 1: Dung @PathVariable
    @GetMapping("/search/{nameCategory}")
    public ResponseEntity<?> searchByNameCategory(@PathVariable String nameCategory, @PageableDefault(sort = "nameCategory", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Category> categoryPage = categoryService.findByNameCategoryQuery(nameCategory, pageable);
        if(categoryPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
    }
@GetMapping("/{id}")
    public ResponseEntity<?> detailCategory(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if(!category.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
}
@PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category category){
    Optional<Category> category1 = categoryService.findById(id);
    if(!category1.isPresent()){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    if(categoryService.existsByNameCategory(category.getNameCategory())){
        if(!category.getAvatarCategory().equals(category1.get().getAvatarCategory())){
            category1.get().setAvatarCategory(category.getAvatarCategory());
            categoryService.save(category1.get());
            return new ResponseEntity<>(new ResponMessage("yes"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponMessage("no_name_category"), HttpStatus.OK);
    }
    category1.get().setNameCategory(category.getNameCategory());
    category1.get().setAvatarCategory(category.getAvatarCategory());
    categoryService.save(category1.get());
    return new ResponseEntity<>(new ResponMessage("yes"), HttpStatus.OK);
}
//Cach 2: Dung @Requesparam
//    @GetMapping("/search")
//    public ResponseEntity<?> searchByNameCategory(@RequestParam("nameCategory") String search, @PageableDefault(sort = "nameCategory", direction = Sort.Direction.ASC)Pageable pageable){
//        Page<Category> categoryPage = categoryService.findByNameCategoryQuery(search,pageable);
//        if(categoryPage.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
//    }
    @GetMapping("/list")
    public ResponseEntity<?> getListCategory(){
        List<Category> categoryList = categoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
