/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegrador.juanbircher.Service;

import com.proyectointegrador.juanbircher.Entity.Experiencia;
import com.proyectointegrador.juanbircher.Repository.rExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class sExperiencia {
    @Autowired
    rExperiencia RExperiencia;
    
    public List<Experiencia> list(){
        return RExperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return RExperiencia.findById(id);
    }
    
    public Optional<Experiencia> getByNombreE(String nombreE){
        return RExperiencia.findByNombreE(nombreE);
    }
    
    public void save(Experiencia expe){
        RExperiencia.save(expe);
    }
    
    public void delete(int id){
        RExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id){
        return RExperiencia.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return RExperiencia.existsByNombreE(nombreE);
    }
}
