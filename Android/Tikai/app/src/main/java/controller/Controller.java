package controller;

public class Controller {

    private MCustomers mCustomers;

    private static Controller instance;

    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    private Controller(){
        mCustomers = new MCustomers();
    }

    public MCustomers getMCustomers() {
        return mCustomers;
    }

    public void setMCustomers(MCustomers mCustomers) {
        this.mCustomers = mCustomers;
    }
}
