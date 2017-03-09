package model;

public class Session {

    private static Session ourInstance = new Session();
    private User user;
    public static Session getInstance() {
        return ourInstance;
    }

    private Session() {
        user = null;
    }

    public void login(String username, String password) throws Exception{
        user =  new User(3500681, username);
    }

    public User getUser() {
        return user;
    }

}
