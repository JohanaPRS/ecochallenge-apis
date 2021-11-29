package com.backend.jwt.api.service;

import com.backend.jwt.api.entity.Nivel;
import com.backend.jwt.api.repository.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NivelService {

    @Autowired
    private NivelRepository repo;

    public Nivel getById(int id){
        return repo.findById(id);
    }

    public List<Nivel> listAll() {
        return repo.findAll();
    }

    public void save(Nivel nivel) {
        repo.save(nivel);
    }

    //no lo usamos
    public void delete(int id) {
        repo.deleteById(id);
    }

    public Nivel getNivelByRango(int rango_minimo, int rango_maximo){
        return repo.findByRango(rango_minimo, rango_maximo);
    }

    public  Nivel getNivelById(int id){
        return repo.findById(id);
    }

    public  List<Nivel> getNivelByDesc(String descripcion){
        return repo.findByDescripcion(descripcion);
    }

}