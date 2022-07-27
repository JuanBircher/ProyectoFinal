package com.proyectointegrador.juanbircher.Security.Repository;

import com.proyectointegrador.juanbircher.Security.Entity.Rol;
import com.proyectointegrador.juanbircher.Security.Enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
