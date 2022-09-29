package com.example.dat367_projekt_11;

import static org.junit.Assert.assertEquals;

import com.example.dat367_projekt_11.models.User;

import org.junit.Test;

public class UserUnitTest {
private final User user;
    public UserUnitTest() {
        user = new User("firstname.lastename@email.com","abc123", "hej");
    }

    @Test
    public void getEmailTest(){assertEquals("firstname.lastename@email.com", user.getEmail());}

    @Test
    public void getPassword(){assertEquals("abc123", user.getPassword());}


}