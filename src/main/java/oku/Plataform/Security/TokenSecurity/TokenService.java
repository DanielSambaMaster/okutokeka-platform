package oku.Plataform.Security.TokenSecurity;


import org.springframework.stereotype.Service;

@Service
public class TokenService {

    String token;
    public String createToken(){


       // String token = JWT.CreateToken();

        return token;
    }

    public String validateToken(){
        return token;
    }
}
