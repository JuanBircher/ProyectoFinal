package com.proyectointegrador.juanbircher.Security.Repository;

import com.proyectointegrador.juanbircher.Security.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario (String nombreUsuario);

    boolean existsByNombreUsuario (String nombreUsuario);
    boolean existsByEmail (String email);
}
