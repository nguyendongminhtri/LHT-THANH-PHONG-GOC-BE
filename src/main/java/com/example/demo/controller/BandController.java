package com.example.demo.controller;

import com.example.demo.dto.response.ResponMessage;
import com.example.demo.model.Band;
import com.example.demo.service.impl.BandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("band")
@RestController
public class BandController {
    @Autowired
    BandServiceImpl bandService;
    @GetMapping
    public ResponseEntity<?> pageBand(@PageableDefault(sort = "nameBand", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Band> bandPage = bandService.findAll(pageable);
        if(bandPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bandPage, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createBand(@RequestBody Band band){
        if(band.getAvatarBand()==null){
            return new ResponseEntity<>(new ResponMessage("no_avatar_band"), HttpStatus.OK);
        }
        bandService.save(band);
        return new ResponseEntity<>(new ResponMessage("create_success"), HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<?> getListBand(){
        List<Band> bandList = bandService.findAll();
        if(bandList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bandList, HttpStatus.OK);
    }
}
