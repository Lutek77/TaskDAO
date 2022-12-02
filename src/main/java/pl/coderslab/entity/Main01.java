package pl.coderslab.entity;

public class Main01 {
    public static void main(String[] args) {
        
        User usr1 = new User();
        usr1.setUserName("Edward");
        usr1.setEmail("edek.nozycorenki@gnail.com");
        usr1.setPassword("ddd");
        
        UserDao usr1D = new UserDao();
        usr1D.create(usr1);
        
    }
}
