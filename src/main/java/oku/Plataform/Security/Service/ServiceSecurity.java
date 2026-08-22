package oku.Plataform.Security.Service;

import oku.Plataform.Security.Model.DataTransferObjects.RegisterDTO;
import oku.Plataform.Security.Model.Users;
import oku.Plataform.Security.RepoSecurity.RepositoryUsersSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ServiceSecurity implements UserDetailsService {

    @Autowired
    private RepositoryUsersSecurity repositoryUsersSecurity;

    public ResponseEntity RegisterUser(RegisterDTO data){

        if(repositoryUsersSecurity.findByLogin(data.login()) != null){

            return ResponseEntity.badRequest().build();

        }

        String encodePassword = new BCryptPasswordEncoder().encode(data.password());
        Users newUser = new Users( data.login(), data.username(), data.emailAddress(), data.phoneNumber(), encodePassword);
        repositoryUsersSecurity.save(newUser);
        return ResponseEntity.ok(newUser);
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repositoryUsersSecurity.findByLogin(login);
    }
}
