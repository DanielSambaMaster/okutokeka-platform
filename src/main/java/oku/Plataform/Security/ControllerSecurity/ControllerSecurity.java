package oku.Plataform.Security.ControllerSecurity;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import oku.Plataform.Security.ModelSecurity.AuthUserDTO;
import oku.Plataform.Security.ModelSecurity.RegisterDTO;
import oku.Plataform.Security.ModelSecurity.Users;
import oku.Plataform.Security.ServiceSecurity.ServiceSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Security;


//auth/Authentication
@RestController
@RequestMapping("/auth")
public class ControllerSecurity {

    @Autowired
    private ServiceSecurity serviceSecurity;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> autheUser(
            @RequestBody @Validated AuthUserDTO dataDTO,
            HttpServletRequest request) {

        var auth = new UsernamePasswordAuthenticationToken(
                dataDTO.login(),
                dataDTO.password()
        );

        var authentication = authenticationManager.authenticate(auth);

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);

        SecurityContextHolder.setContext(context);

        HttpSession session = request.getSession(true);

        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                context
        );

        return ResponseEntity.ok("Login realizado com sucesso");
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
