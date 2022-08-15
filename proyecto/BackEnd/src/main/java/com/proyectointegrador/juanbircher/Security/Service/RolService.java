package com.proyectointegrador.juanbircher.Security.Service;

import com.proyectointegrador.juanbircher.Security.Entity.Rol;
import com.proyectointegrador.juanbircher.Security.Enums.RolNombre;
import com.proyectointegrador.juanbircher.Security.Repository.iRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
