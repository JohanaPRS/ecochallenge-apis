package com.backend.jwt.api.service;

import com.backend.jwt.api.entity.Ods;
import com.backend.jwt.api.repository.OdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OdsService {

    @Autowired
    private OdsRepository repo;

    public Ods getById(int id){
        return repo.findById(id);
    }

    public List<Ods> listAll() {
        return repo.findAll();
    }

    public List<Object> listAllMess() {
        return repo.findMessages();
    }

    public void save(Ods ods) {
        repo.save(ods);
    }

    //no lo usamos
    public void delete(int id) {
        repo.deleteById(id);
    }

}