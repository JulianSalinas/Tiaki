package imagisoft.tiakisystem.model;


public class User {

    private int userId;
    private String name;
    private String imageUrl;
    private Type type;

    public User(int userId, String name, Type type){
        this.userId = userId;
        this.name = name;
        this.type = type;
    }

    public User(int userId, String name, Type type, String imageUrl){
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return type == user.type;

    }
}
