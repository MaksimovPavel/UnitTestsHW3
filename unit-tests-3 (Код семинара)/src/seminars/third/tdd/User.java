package seminars.third.tdd;

public class User {

    String name;
    String password;
    Boolean isAdmin;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = true;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public Boolean getIsAdmin(){
        return isAdmin;
    }

    //3.6.
    public boolean authenticate(String givenLogin, String givenPassword) {
        if (givenLogin.equals(this.name) && givenPassword.equals(this.password)){
            isAuthenticate = true;
            return true;
        } else {
            isAuthenticate = false;
            return false;
        }
    }
}