package model;

import java.util.ArrayList;

public class User {

    private int id;
    private String username;
    private ArrayList<Permission> permissions;

    protected User(int id, String username){
        this.id = id;
        this.username = username;
        permissions = new ArrayList<>();
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

    public boolean hasPermission(Permission permission){
        return permissions.contains(permission);
    }

}


