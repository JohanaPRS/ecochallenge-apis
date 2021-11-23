package com.backend.jwt.api.service;

import com.backend.jwt.api.entity.Desafio;
import com.backend.jwt.api.repository.DesafioRepository;
import java.util.List;
import com.backend.jwt.api.service.DesafioService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DesafioService {

    @Autowired
    private DesafioRepository repo;

    public List<Desafio> listAll() {
        return repo.findAll();
    }

    public void save(Desafio desafio) {
        repo.save(desafio);
    }

    //no lo usamos
    public void delete(int id) {
        repo.deleteById(id);
    }

    public Desafio getASingleDesafio(int id){
        return repo.findById(id);
    }

    public  List<Desafio> getDesafiosByStatus(Boolean status){
        return repo.findByStatus(status);
    }

}