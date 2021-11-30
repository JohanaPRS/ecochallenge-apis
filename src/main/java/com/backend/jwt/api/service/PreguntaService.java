package com.backend.jwt.api.service;

import com.backend.jwt.api.entity.Pregunta;
import com.backend.jwt.api.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PreguntaService {

    @Autowired
    private PreguntaRepository repo;

    public List<Pregunta> listAll() {
        return repo.findAll();
    }

    public void save(Pregunta pregunta) {
        repo.save(pregunta);
    }

    //no lo usamos
    public void delete(int id) {
        repo.deleteById(id);
    }

    public Pregunta getASinglePregunta(int id){
        return repo.findPregunta(id);
    }


}