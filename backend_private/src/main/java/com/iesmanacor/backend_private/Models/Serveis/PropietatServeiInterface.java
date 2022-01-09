package com.iesmanacor.backend_private.Models.Serveis;

import com.iesmanacor.backend_private.Models.Entitats.Propietat;

import java.util.List;

public interface PropietatServeiInterface {

   public List<Propietat> listarTodos();
   public void guardar(Propietat p);
   public Propietat buscarPorId(Long idPropietat);
   public void eliminar(Long idPropietat);



}
