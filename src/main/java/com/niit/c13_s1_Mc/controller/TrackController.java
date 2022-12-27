package com.niit.c13_s1_Mc.controller;

import com.niit.c13_s1_Mc.domain.Track;
import com.niit.c13_s1_Mc.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class TrackController {

    ITrackService trackService;
    @Autowired
    public TrackController(ITrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("/track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        return new ResponseEntity<>(trackService.addTrack(track), HttpStatus.CREATED);
    }

    @GetMapping("/track")
    public ResponseEntity<?>getAllTrack(){
        return new ResponseEntity<>(trackService.getAllTrack(),HttpStatus.OK);
    }

    @DeleteMapping("/track/{id}")
    public ResponseEntity<?>deleteTrack(@PathVariable int id){
        return new ResponseEntity<>(trackService.deleteTrack(id),HttpStatus.OK);
    }

    @GetMapping("/track/{id}")
    public ResponseEntity<?>getAllTrackById(@PathVariable int id){
        return new ResponseEntity<>(trackService.getAllTrackById(id),HttpStatus.OK);
    }

    @PutMapping("/track")
    public ResponseEntity<?>updateTrack(@RequestBody Track track){
        return new ResponseEntity<>(trackService.updateTrack(track),HttpStatus.OK);
    }
}
