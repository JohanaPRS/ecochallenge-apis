package com.backend.jwt.api.controller;

import com.backend.jwt.api.entity.Ods;
import com.backend.jwt.api.service.OdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class OdsController {

    @Autowired
    private OdsService service;

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @GetMapping("/ods")
    public List<Ods> list() {
        return service.listAll();
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/ods/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ods> get(@PathVariable("id") int id) {
        Ods ods = service.getById(id);
        return new ResponseEntity<Ods>(ods, HttpStatus.OK);
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @PostMapping("/ods")
    public ResponseEntity<Ods>  add(@RequestBody Ods ods) {
        service.save(ods);
        return new ResponseEntity<Ods>(ods, HttpStatus.OK);
    }
}
