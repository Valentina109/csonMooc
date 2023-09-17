package com.cspiration.mooc.controller;
import com.cspiration.mooc.entity.UserAuth;
import com.cspiration.mooc.service.IUserAuthService;
import com.cspiration.mooc.support.UserSupport;
import com.cspiration.mooc.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
class UserAuthRESTController {
    @Autowired
    private IUserAuthService iUserAuthService;
    @Autowired
    private UserSupport userSupport;

    @PostMapping("/users")
    public JsonResponse<String> addUser(@RequestBody UserAuth userAuth){
        iUserAuthService.insert(userAuth);
        return JsonResponse.success();
    }
    @GetMapping("/users/{username}")
    public  boolean getUser(@PathVariable String username){
        return iUserAuthService.getByUsername(username);
    }
    @PutMapping("/users")
    public JsonResponse<String> updateUsers(@RequestBody UserAuth userAuth){
        iUserAuthService.update(userAuth);
        return JsonResponse.success();
    }
    @PostMapping("/users-tokens")
    public JsonResponse<String> login(@RequestBody UserAuth userAuth){
        String token = iUserAuthService.authREST(userAuth);
        return new JsonResponse<>(token);
    }
    @GetMapping("/users")
    public JsonResponse<UserAuth> getUsers() throws NoSuchAlgorithmException {
        Long userId = userSupport.getCurrentUserId();
        UserAuth userAuth = iUserAuthService.getByUserId(userId);
        return new JsonResponse<>(userAuth);
    }
}
