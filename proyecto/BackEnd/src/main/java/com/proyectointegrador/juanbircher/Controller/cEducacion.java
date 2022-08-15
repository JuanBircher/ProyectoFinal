/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegrador.juanbircher.Controller;

import com.proyectointegrador.juanbircher.Dto.dtoEducacion;
import com.proyectointegrador.juanbircher.Entity.Educacion;
import com.proyectointegrador.juanbircher.Security.Controller.Mensaje;
import com.proyectointegrador.juanbircher.Service.sEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juanb
 */
@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://frontend-argprograma-56c84.web.app")
public class cEducacion {
    @Autowired
    sEducacion SEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = SEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if(!SEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = SEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!SEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        SEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion DTOEducacion){
        if(StringUtils.isBlank(DTOEducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(SEducacion.existsByNombreE(DTOEducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(DTOEducacion.getNombreE(), DTOEducacion.getDescripcionE());
        
        SEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion DTOEducacion){
        if(!SEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(SEducacion.existsByNombreE(DTOEducacion.getNombreE())&& SEducacion.getByNombreE(DTOEducacion.getNombreE()).get().getId() !=id){
           return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST); 
        }
        if(StringUtils.isBlank(DTOEducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = SEducacion.getOne(id).get();
        
        educacion.setNombreE(DTOEducacion.getNombreE());
        educacion.setDescripcionE(DTOEducacion.getDescripcionE());
        
        SEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
