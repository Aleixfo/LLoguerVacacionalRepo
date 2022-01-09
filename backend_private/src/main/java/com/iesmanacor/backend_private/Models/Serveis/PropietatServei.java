package com.iesmanacor.backend_private.Models.Serveis;

import com.iesmanacor.backend_private.Models.Entitats.Propietat;
import com.iesmanacor.backend_private.Models.Repositoris.PropietatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietatServei implements PropietatServeiInterface{

    @Autowired
    private PropietatRepository propietatRepository;


    @Override
    public List<Propietat> listarTodos() {
        return (List<Propietat>) propietatRepository.findAll();
    }

    @Override
    public void guardar(Propietat p) {
        propietatRepository.save(p);
    }

    @Override
    public Propietat buscarPorId(Long idPropietat) {
        return propietatRepository.findById(idPropietat).orElse(null);
    }

    @Override
    public void eliminar(Long idPropietat) {
        propietatRepository.deleteById(idPropietat);
    }
}
