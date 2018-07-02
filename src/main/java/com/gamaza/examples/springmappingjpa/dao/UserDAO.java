package com.gamaza.examples.springmappingjpa.dao;

import com.gamaza.examples.springmappingjpa.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {}
