package com.backend.jwt.api.controller;

import com.backend.jwt.api.entity.Ranking;
import com.backend.jwt.api.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RankingController {

    @Autowired
    private RankingService service;

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @GetMapping("/ranking")
    public List<Ranking> list() {
        return service.listAll();
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/ranking/usuarios", method = RequestMethod.GET)
    public List<Object> getRanking() {
            List<Object> ranking = service.getRanking();
            return ranking;
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/ranking/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ranking> get(@PathVariable("id") int id) {
        Ranking ranking = service.getById(id);
        return new ResponseEntity<Ranking>(ranking, HttpStatus.OK);
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @PostMapping("/ranking")
    public ResponseEntity<Ranking>  add(@RequestBody Ranking ranking) {
        service.save(ranking);
        return new ResponseEntity<Ranking>(ranking, HttpStatus.OK);
    }

    @CrossOrigin(origins= {"https://ecochallenge-web-admin.herokuapp.com", "http://localhost:3000"})
    @RequestMapping(path = "/ranking/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Ranking> update(@RequestBody Ranking ranking, @PathVariable("id") int id) {
        Ranking rankingOptional = service.getById(id);

        if (rankingOptional!=null){
            ranking.setId(id);

        service.save(ranking);

        return new ResponseEntity<Ranking>(ranking, HttpStatus.OK);
        }else {
                return new ResponseEntity<Ranking>(HttpStatus.NOT_FOUND);
        }
    }
}
