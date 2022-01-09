package com.iesmanacor.backend_private.Models.Repositoris;

import com.iesmanacor.backend_private.Models.Entitats.Propietat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietatRepository extends CrudRepository<Propietat, Long> {

}
