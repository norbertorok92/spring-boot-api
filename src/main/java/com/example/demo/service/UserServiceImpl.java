package com.example.demo.service;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
 
import org.springframework.stereotype.Service;
 
import com.example.demo.model.User;
 
 
 
@Service("userService")
public class UserServiceImpl implements UserService{
     
    private static final AtomicLong counter = new AtomicLong();
     
    private static List<User> users;
     
    static{
        users= populateDummyUsers();
    }
 
    public List<User> findAllUsers() {
        return users;
    }
     
    public User findById(long id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
     
    public User findByName(String name) {
        for(User user : users){
            if(user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }
     
    public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }
 
    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }
 
    public void deleteUserById(long id) {
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isUserExist(User user) {
        return findByName(user.getName())!=null;
    }
     
    public void deleteAllUsers(){
        users.clear();
    }
 
    private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(), "Norbert", 27, 6400));
        users.add(new User(counter.incrementAndGet(), "Andrei", 25, 5100));
        users.add(new User(counter.incrementAndGet(), "Alin", 30, 3800));
        users.add(new User(counter.incrementAndGet(), "Alexandra", 35, 4400));
        users.add(new User(counter.incrementAndGet(), "Andor", 29, 6800));
        users.add(new User(counter.incrementAndGet(), "Ariana", 32, 6200));
        users.add(new User(counter.incrementAndGet(), "Paul", 42, 9100));
        users.add(new User(counter.incrementAndGet(), "Vlad", 22, 4400));
        users.add(new User(counter.incrementAndGet(), "Daniel", 32, 3100));
        users.add(new User(counter.incrementAndGet(), "Ion", 24, 3500));
        return users;
    }
 
}