package com.backend.jwt.api.controller;

import com.backend.jwt.api.entity.Score;
import com.backend.jwt.api.service.CustomUserDetailsService;
import com.backend.jwt.api.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService service;
    private CustomUserDetailsService userService;

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @GetMapping("/score")
    public List<Score> list() {
        return service.listAll();
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/score/usuario/{id_usuario}", method = RequestMethod.GET)
    public int getScore(@PathVariable("id_usuario")  int id_usuario) {
            //User user = userService.loadUserById(usuario);
            //user.setId(usuario);
            int score = service.getUserScore(id_usuario);
            return score;
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/score/{id}", method = RequestMethod.GET)
    public ResponseEntity<Score> get(@PathVariable("id") int id) {
        Score score = service.getById(id);
        return new ResponseEntity<Score>(score, HttpStatus.OK);
    }

   /* @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/score/puntajeUser", method = RequestMethod.GET)
    public List<Score> getPuntajesUsuarios() {
        List<Score> scores = service.getScoreOrdenados();
        return scores;
    }*/

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @PostMapping("/score")
    public ResponseEntity<Score>  add(@RequestBody Score score) {
        service.save(score);
        return new ResponseEntity<Score>(score, HttpStatus.OK);
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/score/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Score> update(@RequestBody Score score, @PathVariable("id") int id) {
        Score nivelOptional = service.getById(id);

        if (nivelOptional!=null){
            score.setId(id);

        service.save(score);

        return new ResponseEntity<Score>(score, HttpStatus.OK);
        }else {
                return new ResponseEntity<Score>(HttpStatus.NOT_FOUND);
        }
    }
}
