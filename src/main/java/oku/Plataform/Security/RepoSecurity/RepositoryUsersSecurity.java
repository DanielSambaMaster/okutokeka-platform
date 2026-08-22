package oku.Plataform.Security.RepoSecurity;

import oku.Plataform.Security.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryUsersSecurity extends JpaRepository<Users, UUID> {


    UserDetails findByLogin(String login);
}
