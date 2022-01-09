package com.iesmanacor.backend_private.Models.Serveis;

import com.iesmanacor.backend_private.Models.Entitats.Municipi;
import com.iesmanacor.backend_private.Models.Repositoris.MunicipiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipiService implements MunicipiServeiInterface{

    @Autowired
    private MunicipiRepository municipiRepository;



    @Override
    public List<Municipi> llistarMunicipis() {
        return (List<Municipi>) municipiRepository.findAll();
    }
}
