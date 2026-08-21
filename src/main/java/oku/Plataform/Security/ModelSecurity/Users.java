package oku.Plataform.Security.ModelSecurity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity(name = "Users")
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Users implements UserDetails {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String login;
        private String password;
        private UserRoles role;



        public Users(RegisterDTO data){

        this.login = data.login();
        this.name = "User";
        this.password = data.password();
        this.role = UserRoles.ADMIN;

        }


        public Users(String login, String password){
            this.name = "Daniel";
            this.login =login;
            this.password = password;
            this.role = UserRoles.ADMIN;
        }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
