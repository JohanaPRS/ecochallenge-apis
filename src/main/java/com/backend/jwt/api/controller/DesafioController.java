package com.backend.jwt.api.controller;

import com.backend.jwt.api.entity.*;
import com.backend.jwt.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.http.*;

@RestController
public class DesafioController {

    @Autowired
    private DesafioService service;

    @Autowired
    private ScoreService scoreserv;

    @Autowired
    private RankingService rankingserv;

    @Autowired
    private NivelService nivelserv;

    @Autowired
    private OdsService odsserv;

    @Autowired
    private CustomUserDetailsService userserv;

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @GetMapping("/desafios")
    public List<Desafio> list() {
        return service.listAll();
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/desafios/{id}", method = RequestMethod.GET)
    public ResponseEntity<Desafio> get(@PathVariable("id")  int id) {
        try {
            Desafio desafio = service.getASingleDesafio(id);
            return new ResponseEntity<Desafio>(desafio, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Desafio>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/desafios/status/{status}", method = RequestMethod.GET)
    public List<Desafio> get(@PathVariable("status")  Boolean status) {
            List<Desafio> desafios = service.getDesafiosByStatus(status);
            return desafios;
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @PostMapping("/desafios")
    public ResponseEntity<Desafio>  add(@RequestBody Desafio desafio) {
        service.save(desafio);
        return new ResponseEntity<Desafio>(desafio, HttpStatus.OK);
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
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
    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
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

    ///terminar desafío:

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @PostMapping("/desafios/terminar/{id_desafio}/{nombre_usuario}/{puntos_desafio}")
    public ResponseEntity<?>   terminar(@PathVariable("id_desafio") int id_desafio, @PathVariable("nombre_usuario") String nombre_usuario,  @PathVariable("puntos_desafio") int puntos_desafio) {
        User user = userserv.userByUserName(nombre_usuario);
        int id_usuario = user.getId();
        Score score = new Score (id_desafio, id_usuario, puntos_desafio);
        scoreserv.save(score); // registro el nuevo score obtenido por el user - score con id desafio + id_usuario + puntos desafio
        int puntaje_total = scoreserv.getUserScore(id_usuario); // obtengo el puntaje total del user
        Nivel nivel = nivelserv.getNivelByRango(puntaje_total, puntaje_total);
        int id_nivel = nivel.getId();
        // actualizo esto en ranking
        Ranking ranking = rankingserv.getByUser(id_usuario);
        if(ranking != null){
            ranking.setId(ranking.getId());
            ranking.setId_usuario(ranking.getId_usuario());
            ranking.setNombre_usuario(ranking.getNombre_usuario());
            ranking.setId_nivel(id_nivel);
            ranking.setPuntaje_total(puntaje_total);
            rankingserv.save(ranking);
        }else{
           Ranking nuevo = new Ranking (id_usuario, nombre_usuario, id_nivel,puntaje_total);
            rankingserv.save(nuevo);
        }
        //Actualizo tabla users
        user.setId_nivel(id_nivel);
        user.setPuntaje(puntaje_total);
        userserv.saveUpdate(user);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
