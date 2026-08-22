package oku.Plataform.Security.ModelSecurity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Roles {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;
    private String name;





}
