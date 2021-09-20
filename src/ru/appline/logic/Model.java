package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {
    private static final Model instance = new Model();

    private final Map<Integer, User>model;

    public static Model getInstance(){
        return instance;
    }
    private Model(){
        model = new HashMap<>();
        model.put(1, new User("Ildar", "Adullin", 20000.00));
        model.put(2, new User("Stas", "Russakov", 999999.00));
        model.put(3, new User("Ivan", "Ivanov", 100000.00));
        model.put(4, new User("Ivane", "Ivanove", 100000.00));
    }
    public void add(User user, int id){
        model.put(id, user);
    }
    public Map<Integer, User> getFromList(){
        return model;
    }
    public void delete(int id){
        model.remove(id);
    }
    public void edit(int id, User user){
        model.put(id, user);
    }

}
