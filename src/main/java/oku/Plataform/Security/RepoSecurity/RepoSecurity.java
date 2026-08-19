package oku.Plataform.Security.RepoSecurity;

import oku.Plataform.Security.ModelSecurity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepoSecurity extends JpaRepository<Users, String> {
    Users findByLogin(String login);
}
