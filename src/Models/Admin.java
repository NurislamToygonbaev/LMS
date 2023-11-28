package Models;

public class Admin {
    private String fullName = "Toigonbaev Nurislam";
    private String email = "Admin@outlook.com";
    private String password = "admin123";

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    @Override
    public String toString() {
        return "Admin: \n" +
                "full name =       " + fullName + "\n" +
                "email =           " + email + "\n" +
                "password =        " + password + "\n\n";
    }
}
