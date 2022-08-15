/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegrador.juanbircher.Service;

import com.proyectointegrador.juanbircher.Entity.Educacion;
import com.proyectointegrador.juanbircher.Repository.rEducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juanb
 */
@Service
@Transactional
public class sEducacion {
    @Autowired
    rEducacion REducacion;
    
    public List<Educacion> list(){
        return REducacion.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return REducacion.findById(id);
    }
    
    public Optional<Educacion> getByNombreE(String nombreE){
        return REducacion.findByNombreE(nombreE);
    }
    
    public void save(Educacion educacion){
        REducacion.save(educacion);
    }
    
    public void delete(int id){
        REducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return REducacion.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return REducacion.existsByNombreE(nombreE);
    }
}
