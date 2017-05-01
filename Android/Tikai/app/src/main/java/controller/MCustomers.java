package controller;

import java.util.ArrayList;

import model.Customer;

public class MCustomers{

    private ArrayList<Customer>customers;

    public MCustomers(){
        customers = new ArrayList<>();
        customers.add(new Customer(304955837, "Residencial uno", "Paraíso, Cartago"));
        customers.add(new Customer(793674837, "Residencial dos", "Paraíso, Cartago"));
        customers.add(new Customer(378394523, "Residencial tres", "Paraíso, Cartago"));
        customers.add(new Customer(337837837, "Residencial cuatro", "Paraíso, Cartago"));
        customers.add(new Customer(896531231, "Residencial cinco", "Paraíso, Cartago"));
        customers.add(new Customer(345378677, "Residencial seis", "Paraíso, Cartago"));
        customers.add(new Customer(345348373, "Residencial siete", "Paraíso, Cartago"));
        customers.add(new Customer(345348578, "Residencial ocho", "Paraíso, Cartago"));
        customers.add(new Customer(393934534, "Residencial nueve", "Paraíso, Cartago"));
        customers.add(new Customer(963585211, "Residencial diez", "Paraíso, Cartago"));
        customers.add(new Customer(852741836, "Residencial once", "Paraíso, Cartago"));
        customers.add(new Customer(987424533, "Residencial doce", "Paraíso, Cartago"));
        customers.add(new Customer(254214353, "Residencial trece", "Paraíso, Cartago"));
        customers.add(new Customer(378734345, "Residencial catorce", "Paraíso, Cartago"));
    }

    public ArrayList<Customer> consult() {
        return customers;
    }

    public boolean createOrUpdate(Object object) {
        boolean result = true;
        int position = customers.indexOf(object);
        if(position == -1) customers.add((Customer) object);
        else customers.set(position, (Customer) object);
        return result;
    }

    public boolean delete(Object object) {
        boolean result = true;
        if(customers.contains(object)) customers.remove(object);
        else result = false;
        return result;
    }

}
