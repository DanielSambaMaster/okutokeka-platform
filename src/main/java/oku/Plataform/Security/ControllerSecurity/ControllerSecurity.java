package oku.Plataform.Security.ControllerSecurity;

import oku.Plataform.Security.ModelSecurity.AuthUserDTO;
import oku.Plataform.Security.ModelSecurity.RegisterDTO;
import oku.Plataform.Security.ServiceSecurity.ServiceSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Security;


//auth/Authentication
@RestController
@RequestMapping("/auth")
public class ControllerSecurity {

    @Autowired
    private ServiceSecurity serviceSecurity;

    private AuthenticationManager authenticationManager;

    @PostMapping("/Authentication")
    public ResponseEntity autheUser(@RequestBody @Validated AuthUserDTO dataDTO){

    var auth = new UsernamePasswordAuthenticationToken(dataDTO.login(),dataDTO.password());
    var token = this.authenticationManager.authenticate(auth);


       return ResponseEntity.ok(token);
    }

    @PostMapping("/Register")
    public ResponseEntity authoUser(@RequestBody @Validated RegisterDTO dataDTO){




        return ResponseEntity.ok(serviceSecurity.RegistarUser(dataDTO));
    }

    @GetMapping("/Get")
    public ResponseEntity authoUser(){




        return ResponseEntity.ok(serviceSecurity.get());
    }

}
