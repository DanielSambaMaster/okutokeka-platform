package oku.Plataform.Security.RepoSecurity;

import oku.Plataform.Security.Model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryPermission extends JpaRepository<Permission, Long> {
}
