package com.example.dat367_projekt_11;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.dat367_projekt_11.models.Profile;
import com.example.dat367_projekt_11.models.User;

public class UserUnitTest {
private final User user;
    public UserUnitTest() {
        user = new User("firstname.lastename@email.com","abc123");
    }

    @Test
    public void getEmailTest(){assertEquals("firstname.lastename@email.com", user.getEmail());}

    @Test
    public void getPassword(){assertEquals("abc123", user.getPassword());}


}