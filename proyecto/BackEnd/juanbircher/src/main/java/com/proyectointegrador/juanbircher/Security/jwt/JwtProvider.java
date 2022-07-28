package com.proyectointegrador.juanbircher.Security.jwt;

import com.proyectointegrador.juanbircher.Security.Entity.UsuarioPrincipal;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

import static io.jsonwebtoken.security.Keys.secretKeyFor;


@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private Key secret;
    @Value("${jwt.expiration}")
    private int expiration;

    private Key getSecret(){
        if(secret == null) secret = secretKeyFor(SignatureAlgorithm.HS512);
        return secret;
    }
    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiration*1000))
                .signWith(SignatureAlgorithm.HS512, getSecret())
                .compact();
    }

    public String getNombreUsuarioFromToken (String token){
        return Jwts.parser().setSigningKey(getSecret()).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(getSecret()).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e){
            logger.error("Token mal formado");
        } catch (UnsupportedJwtException e){
            logger.error("Token no soportado");
        } catch (ExpiredJwtException e){
            logger.error("Token expirado");
        } catch (IllegalArgumentException e){
            logger.error("Token vacío");
        } catch (SignatureException e){
            logger.error("Firma no válida");
        }
        return false;
    }

}
