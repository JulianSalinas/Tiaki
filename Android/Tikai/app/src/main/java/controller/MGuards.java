package controller;

import java.util.ArrayList;

import model.Guard;

public class MGuards {
    private ArrayList<Guard>guards;

    public MGuards(){
        guards = new ArrayList<>();
        guards.add(new Guard(35654165, "Vigilante 1" , "(506) 84532513", "Forever Alone", 71 , null));
        guards.add(new Guard(42352345, "Vigilante 2" , "(506) 84532513", "Forever Alone", 71 , null));
        guards.add(new Guard(89765443, "Vigilante 3" , "(506) 84532513", "Forever Alone", 61 , null));
        guards.add(new Guard(45345332, "Vigilante 4" , "(506) 84532513", "Forever Alone", 71 , null));
        guards.add(new Guard(78637853, "Vigilante 5" , "(506) 84532513", "Forever Alone", 71 , null));
        guards.add(new Guard(95218444, "Vigilante 6" , "(506) 84532513", "Forever Alone", 71 , null));
        guards.add(new Guard(78632422, "Vigilante 7" , "(506) 84532513", "Forever Alone", 41 , null));
        guards.add(new Guard(57224412, "Vigilante 8" , "(506) 84532513", "Forever Alone", 21 , null));
        guards.add(new Guard(78678563, "Vigilante 9" , "(506) 84532513", "Forever Alone", 61 , null));
        guards.add(new Guard(78647856, "Vigilante 10" , "(506) 84532513", "Forever Alone", 41 , null));
        guards.add(new Guard(12345378, "Vigilante 11" , "(506) 84532513", "Forever Alone", 10 , null));

    }

    public ArrayList<Guard> consult() {
        return guards;
    }

    public boolean createOrUpdate(Object object) {
        boolean result = true;
        int position = guards.indexOf(object);
        if(position == -1) guards.add((Guard) object);
        else guards.set(position, (Guard) object);
        return result;
    }

    public boolean delete(Object object) {
        boolean result = true;
        if(guards.contains(object)) guards.remove(object);
        else result = false;
        return result;
    }
}
