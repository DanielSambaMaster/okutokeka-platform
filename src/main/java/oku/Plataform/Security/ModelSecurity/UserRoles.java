package oku.Plataform.Security.ModelSecurity;

public enum UserRoles {

    FULLACESS(0), ADMIN(1), MANAGER(2), AGENT(3);

    private int userRole;
    UserRoles(int userRole){
        this.userRole = userRole;
    }

    public int getUserRole(){
        return userRole;
    }
}
