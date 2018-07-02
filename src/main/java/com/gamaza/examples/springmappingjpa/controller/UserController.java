package com.gamaza.examples.springmappingjpa.controller;

import com.gamaza.examples.springmappingjpa.dto.UserDTO;
import com.gamaza.examples.springmappingjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public @ResponseBody List<UserDTO> getAll(){
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody UserDTO getOne(@PathVariable("id") Integer id){
        return userService.getOne(id);
    }

    @PostMapping
    public @ResponseBody UserDTO insert(@RequestBody UserDTO userDTO){
        return userService.create(userDTO);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO){
        userService.update(id, userDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id){
        userService.delete(id);
    }

}
