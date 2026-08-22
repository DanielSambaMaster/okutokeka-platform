package oku.Plataform.Security.RepoSecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryPermission extends JpaRepository<RepositoryPermission, Long> {
}
