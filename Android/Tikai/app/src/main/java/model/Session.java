package model;

import java.util.ArrayList;

public class Session {

    private static Session ourInstance = new Session();

    private int id;
    private String username;
    private String urlImage;
    private ArrayList<Permission> permissions;

    public static Session getInstance() {
        return ourInstance;
    }

    public void login(String username, String password) throws Exception{
        this.id = 35146533;
        this.username = username;
        this.permissions = new ArrayList<>();
        this.urlImage = "http://i.imgur.com/g58Yz.png";
        permissions.add(Permission.LOOK_RESIDENTS);
        permissions.add(Permission.LOOK_CUSTOMERS);
        permissions.add(Permission.LOOK_GUARDS);
        permissions.add(Permission.LOOK_HOMEOWNERS);
        permissions.add(Permission.LOOK_REGISTRY);
        permissions.add(Permission.LOOK_VISITORS);
        permissions.add(Permission.CRUD_RESIDENTS);
        permissions.add(Permission.CRUD_CUSTOMERS);
        permissions.add(Permission.CRUD_GUARDS);
    }

    public boolean hasPermission(Permission permission){
        return permissions.contains(permission);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
