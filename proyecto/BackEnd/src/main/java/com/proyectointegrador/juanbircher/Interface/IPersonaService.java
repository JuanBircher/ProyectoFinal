package com.proyectointegrador.juanbircher.Interface;

import com.proyectointegrador.juanbircher.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //traer persona//
    public List<Persona> getPersona();
    
    //guardar un obj de tipo persona//
    public void savePersona(Persona persona);
    
    //eliminar un obj por id//
    public void deletePersona(Long id);
            
    //buscar una persona por id//
    public Persona findPersona(Long id);
}
