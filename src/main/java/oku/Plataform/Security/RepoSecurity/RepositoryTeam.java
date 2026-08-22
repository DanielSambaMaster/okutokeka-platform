package oku.Plataform.Security.RepoSecurity;

import oku.Plataform.Security.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryTeam extends JpaRepository<Team, Long> {
}
