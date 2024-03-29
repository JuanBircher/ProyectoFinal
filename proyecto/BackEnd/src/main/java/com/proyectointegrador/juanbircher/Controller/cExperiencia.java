/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegrador.juanbircher.Controller;

import com.proyectointegrador.juanbircher.Dto.dtoExperiencia;
import com.proyectointegrador.juanbircher.Entity.Experiencia;
import com.proyectointegrador.juanbircher.Security.Controller.Mensaje;
import com.proyectointegrador.juanbircher.Service.sExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/explab")
@CrossOrigin(origins = "https://frontend-argprograma-56c84.web.app")

public class cExperiencia {
    @Autowired
    sExperiencia SExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = SExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!SExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = SExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(SExperiencia.existsByNombreE(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoExp.getNombreE(), dtoExp.getDescripcionE());
        SExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
        }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoExp){
        //validamos si existe ID
        if(!SExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(SExperiencia.existsByNombreE(dtoExp.getNombreE()) && SExperiencia.getByNombreE(dtoExp.getNombreE()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Esa expedriencia ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("El campo es obliogatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = SExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoExp.getNombreE());
        experiencia.setDescripcionE(dtoExp.getDescripcionE());
        
        SExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
        }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        
        if (!SExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("EL ID no existe"), HttpStatus.BAD_REQUEST);
        
        SExperiencia.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
