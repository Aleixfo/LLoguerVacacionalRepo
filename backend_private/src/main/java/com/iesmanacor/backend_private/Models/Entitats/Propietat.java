package com.iesmanacor.backend_private.Models.Entitats;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data //Longbok afegeix setters, getters i el constructor buit.
@Entity //Entitat (se menejara amb una taula)
@Table(name="PROPIETAT") //Si la taula no s'escriu exactament igual a la classe s'ha de posar el nom de la taula (NO ES EL CAS)
public class Propietat implements Serializable {

    private static final long serialVersionUID=1L;

    //Atributs pelicula

    @Id //Indicam quin es el camp identificador
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicam com es genera l'identificador (En aquest cas AUTO_INCREMENT)
    private Long idPROPIETAT;


    private String nomPropietat;

    @ManyToOne //Relacio de molts a un ambn la taula municipi
    @JoinColumn(name = "id_municipi") //Especificam el nom de la taula
    private Municipi municipi;

    private String normes;
    private String direccio;

    @NotNull
    @Column(name="%descompte_Setmana", nullable=false)
    private int descompteSetmana;

    @NotNull
    @Column(name="%descompte_mes", nullable=false)
    private int descompteMes;

    /*
    @OneToMany - Per indicar una relació de un a molts
    private Habitacio hab;
    */



}