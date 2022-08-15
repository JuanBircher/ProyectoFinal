package com.proyectointegrador.juanbircher.Repository;

import com.proyectointegrador.juanbircher.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
    
}
