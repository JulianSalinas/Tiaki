package model;

public class Guard extends Stakeholder{

    private String civilStatus;
    private int age;
    private String urlImage;

    public Guard(int id, String name, String telephone, String civilStatus, int age, String urlImage) {
        super(id, name, telephone);
        this.age = age;
        if(urlImage == null)
            this.urlImage = "http://orig08.deviantart.net/2516/f/2012/091/9/5/anime_girl_icon_by_pinkangelx12-d4una2u.png";
        else
            this.urlImage = urlImage;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
