package oku.Plataform.Security.RepoSecurity;

import oku.Plataform.Security.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryRole extends JpaRepository<Role, Long> {
}
