package com.example.dat367_projekt_11;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.dat367_projekt_11.models.Profile;

public class ProfileUnitTest {
    private final Profile profile;

    public ProfileUnitTest() {
        profile = new Profile("Profile");
    }

    @Test
    public void getName(){assertEquals("Profile", profile.getName());}


}
