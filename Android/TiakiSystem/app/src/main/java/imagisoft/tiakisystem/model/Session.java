package imagisoft.tiakisystem.model;

public class Session {

    private static Session ourInstance = new Session();
    private User currentUser;

    public static Session getInstance() {
        return ourInstance;
    }

    public User login(int id, String password){
        String encryptedPass = Encrypting.encrypt(password);
        currentUser = new User(id, "Julian Salinas", Type.ADMINISTRATOR);
        return currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

}
