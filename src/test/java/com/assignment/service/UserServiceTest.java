package com.assignment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.serviceImpl.UserServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
    private Properties userProperties;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testGetWorkstation() {
        when(userProperties.getProperty("admin")).thenReturn("CCUICKB0F1");
        assertEquals("CCUICKB0F1", userService.getWorkstation("admin"));
    }

    @Test
    public void testUserExists() {
        when(userProperties.containsKey("admin")).thenReturn(true);
        assertTrue(userService.userExists("admin"));
    }
    
    @Test
    public void testUserNotExists() {
    	when(userProperties.containsKey("staff")).thenReturn(false);
    	assertFalse(userService.userExists("staff"));
    }
}