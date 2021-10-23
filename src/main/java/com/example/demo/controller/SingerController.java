package com.example.demo.controller;

import com.example.demo.dto.response.ResponMessage;
import com.example.demo.model.Singer;
import com.example.demo.service.impl.SingerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("singer")
public class SingerController {
    @Autowired
    SingerServiceImpl singerService;
    @GetMapping
    public ResponseEntity<?> pageSinger(@PageableDefault(sort = "nameSinger", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Singer> singerPage = singerService.findAll(pageable);
        if(singerPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(singerPage, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createSinger(@RequestBody Singer singer){
        if(singer.getAvatarSinger()==null){
            return new ResponseEntity<>(new ResponMessage("no_avatar_singer"), HttpStatus.OK);
        }
        if(singer.getBirthDay()==null){
            return new ResponseEntity<>(new ResponMessage("no_birthday_singer"), HttpStatus.OK);
        }
        singerService.save(singer);
        return new ResponseEntity<>(new ResponMessage("create_success"), HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<?> getListSinger(){
        List<Singer> singerList = singerService.findAll();
        if(singerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(singerList, HttpStatus.OK);
    }
}
