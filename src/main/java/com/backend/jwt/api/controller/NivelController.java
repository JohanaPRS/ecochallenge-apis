package com.backend.jwt.api.controller;

import com.backend.jwt.api.entity.Nivel;
import com.backend.jwt.api.service.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class NivelController {

    @Autowired
    private NivelService service;

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @GetMapping("/nivel")
    public List<Nivel> list() {
        return service.listAll();
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/nivel/{rango_minimo}/{rango_maximo}", method = RequestMethod.GET)
    public ResponseEntity<Nivel> get(@PathVariable("rango_minimo")  int rango_minimo, @PathVariable("rango_maximo")  int rango_maximo) {
        try {
            Nivel nivel = service.getNivelByRango(rango_minimo,rango_maximo);
            return new ResponseEntity<Nivel>(nivel, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Nivel>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/nivel/{id}", method = RequestMethod.GET)
    public ResponseEntity<Nivel> get(@PathVariable("id") int id) {
        Nivel nivel = service.getNivelById(id);
        return new ResponseEntity<Nivel>(nivel, HttpStatus.OK);
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/nivel/descripcion/{descripcion}", method = RequestMethod.GET)
    public List<Nivel> get(@PathVariable("descripcion") String descripcion) {
        List<Nivel> niveles = service.getNivelByDesc(descripcion);
        return niveles;
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @PostMapping("/nivel")
    public ResponseEntity<Nivel>  add(@RequestBody Nivel nivel) {
        service.save(nivel);
        return new ResponseEntity<Nivel>(nivel, HttpStatus.OK);
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/nivel/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Nivel> update(@RequestBody Nivel nivel, @PathVariable("id") int id) {
        Nivel nivelOptional = service.getById(id);

        if (nivelOptional!=null){
            nivel.setId(id);

        service.save(nivel);

        return new ResponseEntity<Nivel>(nivel, HttpStatus.OK);
        }else {
                return new ResponseEntity<Nivel>(HttpStatus.NOT_FOUND);
        }
    }
}
