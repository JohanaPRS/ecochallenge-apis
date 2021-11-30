package com.backend.jwt.api.controller;

import com.backend.jwt.api.entity.Pregunta;
import com.backend.jwt.api.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PreguntaController {

    @Autowired
    private PreguntaService service;

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @GetMapping("/preguntas")
    public List<Pregunta> list() {
        return service.listAll();
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/preguntas/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pregunta> get(@PathVariable("id")  int id) {
        try {
            Pregunta pregunta = service.getASinglePregunta(id);
            return new ResponseEntity<Pregunta>(pregunta, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Pregunta>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @PostMapping("/preguntas")
    public ResponseEntity<Pregunta>  add(@RequestBody Pregunta pregunta) {
        service.save(pregunta);
        return new ResponseEntity<Pregunta>(pregunta, HttpStatus.OK);
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/preguntas/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pregunta> update(@RequestBody Pregunta pregunta, @PathVariable("id") int id) {
        Pregunta preguntaOptional = service.getASinglePregunta(id);

        if (preguntaOptional!=null){
            pregunta.setId(id);
            service.save(pregunta);
            return new ResponseEntity<Pregunta>(pregunta, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
