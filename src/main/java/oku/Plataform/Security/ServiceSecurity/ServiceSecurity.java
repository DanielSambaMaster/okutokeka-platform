package oku.Plataform.Security.ServiceSecurity;

import oku.Plataform.Security.RepoSecurity.RepoSecurity;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;
import org.jspecify.annotations.NullMarked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ServiceSecurity implements UserDetailsService {


    private RepoSecurity repo;

    @Autowired
   public ServiceSecurity(RepoSecurity repo){
       this.repo=repo;
   }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repo.findByLogin(login);
    }
}
