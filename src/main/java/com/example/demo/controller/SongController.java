package com.example.demo.controller;

import com.example.demo.dto.response.ResponMessage;
import com.example.demo.model.Song;
import com.example.demo.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("song")
public class SongController {
    @Autowired
    SongServiceImpl songService;
    @GetMapping
    public ResponseEntity<?> pageSong(@PageableDefault(sort = "nameSong", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Song> songPage = songService.findAll(pageable);
        if(songPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(songPage, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createSong(@RequestBody Song song){
        if(song.getAvatarSong()==null){
            return new ResponseEntity<>(new ResponMessage("no_avatar_song"), HttpStatus.OK);
        }
        if(song.getMp3Url()==null){
            return new ResponseEntity<>(new ResponMessage("no_mp3_song"), HttpStatus.OK);
        }
        songService.save(song);
        return new ResponseEntity<>(new ResponMessage("yes"), HttpStatus.OK);
    }
}
