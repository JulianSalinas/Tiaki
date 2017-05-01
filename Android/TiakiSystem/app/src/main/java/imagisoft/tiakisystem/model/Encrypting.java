package imagisoft.tiakisystem.model;

public class Encrypting {

    public static String encrypt(String something){
        return something.replace('c','a');
    }

    public static String decrypt(String something){
        return something.replace('a','c');
    }

}
