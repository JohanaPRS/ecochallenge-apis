package com.backend.jwt.api.service;

import com.backend.jwt.api.entity.Score;
import com.backend.jwt.api.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScoreService {

    @Autowired
    private ScoreRepository repo;

    public Score getById(int id){
        return repo.findScore(id);
    }

    public List<Score> listAll() {
        return repo.findAll();
    }

    public void save(Score score) {
        repo.save(score);
    }

    //no lo usamos
    public void delete(int id) {
        repo.deleteById(id);
    }

    public int getUserScore(int id_usuario){
        return repo.getTotalScoreForUser(id_usuario);
    }

    /*public List<Score> getScoreOrdenados(){
        return repo.findFirst();
    }*/

}