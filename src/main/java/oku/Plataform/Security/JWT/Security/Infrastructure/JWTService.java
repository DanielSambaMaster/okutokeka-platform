package oku.Plataform.Security.JWT.Security.Infrastructure;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import oku.Plataform.Security.Model.Users;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class JWTService {


    private String secret = "samba";

    public String generateToken(Users user){

        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withSubject(user.getUsername())
                    .withIssuer("samba")
                    .withExpiresAt(genInstant())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){

            throw new RuntimeException("JWT creation Exception", exception.getCause());
        }


    }



    public String validateToken(String token){

       try {
           Algorithm algorithm = Algorithm.HMAC256(secret);
           return JWT.require(algorithm)
                   .withIssuer("samba")
                   .build()
                   .verify(token)
                   .getSubject();

               }catch (JWTVerificationException exception){

           return "";

       }
    }

    public Instant genInstant(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("01:00"));
    }


}
