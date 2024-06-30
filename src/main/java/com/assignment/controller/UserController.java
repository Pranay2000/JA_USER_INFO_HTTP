package com.assignment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.service.UserService;
import com.assignment.util.HttpUtil;

@RestController
@RequestMapping("/appName")
public class UserController {

	@Autowired
	 private UserService userService;

    @Autowired
    private HttpUtil httpUtil;

    @GetMapping("/userDetail")
    public ResponseEntity<?> getUserDetail(@RequestParam String user) {
        if (userService.userExists(user)) {
            String workstation = userService.getWorkstation(user);
            Map<String, String> payload = new HashMap<>();
            payload.put("user", user);
            payload.put("workstation", workstation);
            payload.put("status", "Success");
            payload.put("message", "user exist in database and has access to given workstation");

            httpUtil.postToTargetService(payload);
            return ResponseEntity.ok(payload);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}