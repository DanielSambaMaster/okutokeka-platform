package oku.Plataform.Security.ServiceSecurity;

import oku.Plataform.Security.ModelSecurity.AuthUserDTO;
import oku.Plataform.Security.ModelSecurity.RegisterDTO;
import oku.Plataform.Security.ModelSecurity.Users;
import oku.Plataform.Security.RepoSecurity.RepoSecurity;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.SourceType;
import org.jspecify.annotations.NullMarked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ServiceSecurity implements UserDetailsService {

    @Autowired
    private RepoSecurity repo;


    public ResponseEntity RegistarUser(RegisterDTO dataDTO){

        if(repo.findByLogin(dataDTO.login()) != null){
            return ResponseEntity.badRequest().build();
        }


        Users newUser = new Users(dataDTO.login(), new BCryptPasswordEncoder().encode(dataDTO.password()));
        repo.save(newUser);


        return ResponseEntity.ok().build();
    }

    public ResponseEntity get(){



        return ResponseEntity.ok(repo.findAll());
    }






    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repo.findByLogin(login);
    }
}
