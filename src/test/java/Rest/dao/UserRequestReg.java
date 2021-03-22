package Rest.dao;

public class UserRequestReg {

    public String email;
    public String password;

    public UserRequestReg(String email){
        this.email = email;
    }

    public UserRequestReg(String email, String password){
        this.email = email;
        this.password = password;
    }
}
