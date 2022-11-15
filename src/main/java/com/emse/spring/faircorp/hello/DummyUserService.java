package com.emse.spring.faircorp.hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyUserService implements UserService{

    private final GreetingService greetSer;

    @Autowired
    public DummyUserService (GreetingService greetSer){
        this.greetSer = greetSer;
    }
    public void greetAll(){
        String [] Usernames = {"Elodie", "Charles"};
        for (String name: Usernames) {
            greetSer.greet(name);
        }
    }
}