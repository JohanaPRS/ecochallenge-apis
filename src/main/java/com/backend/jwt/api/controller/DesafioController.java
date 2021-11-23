package com.backend.jwt.api.controller;

import com.backend.jwt.api.entity.Desafio;
import com.backend.jwt.api.service.DesafioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.backend.jwt.api.entity.JwtResponse;
import java.util.HashMap;
import java.util.*;
import org.springframework.http.*;

@RestController
public class DesafioController {

    @Autowired
    private DesafioService service;

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com"})
    @GetMapping("/desafios")
    public List<Desafio> list() {
        return service.listAll();
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com"})
    @RequestMapping(path = "/desafios/{id}", method = RequestMethod.GET)
    public ResponseEntity<Desafio> get(@PathVariable("id")  int id) {
        try {
            Desafio desafio = service.getASingleDesafio(id);
            return new ResponseEntity<Desafio>(desafio, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Desafio>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com"})
    @RequestMapping(path = "/desafios/{status}", method = RequestMethod.GET)
    public List<Desafio> get(@PathVariable("status")  Boolean status) {
            List<Desafio> desafios = service.getDesafiosByStatus(status);
            return desafios;
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com"})
    @PostMapping("/desafios")
    public ResponseEntity<Desafio>  add(@RequestBody Desafio desafio) {
        service.save(desafio);
        return new ResponseEntity<Desafio>(desafio, HttpStatus.OK);
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com"})
    @RequestMapping(path = "/desafios/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Desafio desafio, @PathVariable("id") int id) {
        Desafio desafioOptional = service.getASingleDesafio(id);

        if (desafioOptional!=null){
        desafio.setId(id);

        service.save(desafio);

        return new ResponseEntity<Desafio>(desafio, HttpStatus.OK);
        }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com"})
    @RequestMapping(path = "/desafios/status/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateStatus(@RequestBody Desafio desafio, @PathVariable("id") int id) {
        Desafio desafioOptional = service.getASingleDesafio(id);

        if (desafioOptional!=null){
            desafio.setId(id);
            desafio.setNombre_desafio(desafioOptional.getNombre_desafio());
            desafio.setPuntaje_desafio(desafioOptional.getPuntaje_desafio());
            desafio.setPaso1Desafio(desafioOptional.getPaso1Desafio());
            desafio.setPaso2Desafio(desafioOptional.getPaso2Desafio());
            desafio.setPaso3Desafio(desafioOptional.getPaso3Desafio());
            desafio.setPaso4Desafio(desafioOptional.getPaso4Desafio());

            service.save(desafio);

            return new ResponseEntity<Desafio>(desafio, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
