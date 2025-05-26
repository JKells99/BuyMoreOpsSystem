package com.buymore;

import com.buymore.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoreTest {

    @Test
    public void testCoreFunctionality() {
        // This is a placeholder for core functionality tests.
        // You can add assertions here to test the core logic of your application.
        Assertions.assertTrue(true, "Core functionality test passed.");
    }

    @Test
    public void testUserCreation() {
        User user = new User();
        user.setUserName("testUser");
        user.setPassword("testPassword");
        Assertions.assertEquals("testUser", user.getUserName());

    }
    @Test
    public void checkServerStart(){

    }
}
