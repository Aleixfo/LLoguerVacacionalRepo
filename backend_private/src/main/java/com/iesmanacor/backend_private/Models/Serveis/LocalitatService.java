package com.iesmanacor.backend_private.Models.Serveis;

import com.iesmanacor.backend_private.Models.Entitats.Localitat;
import com.iesmanacor.backend_private.Models.Repositoris.LocalitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalitatService implements LocalitatServeiInterface {

    @Autowired
    private LocalitatRepository localitatRepository;



    @Override
    public List<Localitat> llistarLocalitats() {
        return (List<Localitat>) localitatRepository.findAll();
    }
}
