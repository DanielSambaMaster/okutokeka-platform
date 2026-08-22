package oku.Plataform.Security.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import oku.Plataform.Security.Model.DataTransferObjects.AuthenticationDTO;
import oku.Plataform.Security.Model.DataTransferObjects.RegisterDTO;
import oku.Plataform.Security.Service.ServiceSecurity;
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


//auth/Authentication
@RestController
@RequestMapping("/auth")
public class ControllerSecurity {

    @Autowired
    private ServiceSecurity serviceSecurity;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> authentication(@RequestBody @Validated  HttpServletRequest request, AuthenticationDTO data) {




        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.login(), data.login()));


     if(authenticate.isAuthenticated()){
         ResponseEntity.ok("User está autenticado");
         System.out.println(request.getSession().getId());
     }

        System.out.println(request.getSession().getId());

        return ResponseEntity.ok("Login realizado com sucesso");
    }

    @PostMapping("/Register")
    public ResponseEntity registerEnpoint(@RequestBody @Validated RegisterDTO data){

        serviceSecurity.RegisterUser(data);
        return ResponseEntity.ok().build();
    }



}
