package com.backend.jwt.api.service;

import com.backend.jwt.api.entity.Ranking;
import com.backend.jwt.api.repository.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RankingService {

    @Autowired
    private RankingRepository repo;

    public Ranking getById(int id){
        return repo.findRanking(id);
    }

    public Ranking getByUser(int id_usuario){
        return repo.findByUser(id_usuario);
    }

    public List<Ranking> listAll() {
        return repo.findAll();
    }

    public void save(Ranking ranking) {
        repo.save(ranking);
    }

    //no lo usamos
    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<Object>getRanking(){
        return repo.findFirst();
    }

}