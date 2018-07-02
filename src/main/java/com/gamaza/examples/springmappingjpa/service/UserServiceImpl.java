package com.gamaza.examples.springmappingjpa.service;

import com.gamaza.examples.springmappingjpa.dao.UserDAO;
import com.gamaza.examples.springmappingjpa.dto.UserDTO;
import com.gamaza.examples.springmappingjpa.model.User;
import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    private DozerBeanMapper dozerBeanMapper;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, DozerBeanMapper dozerBeanMapper) {
        this.userDAO = userDAO;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @Override
    public List<UserDTO> getAll() {
        return Lists.newArrayList(userDAO.findAll()).stream().map(user -> dozerBeanMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }


    @Override
    public UserDTO getOne(Integer id) {
        return dozerBeanMapper.map(userDAO.findById(id).orElseGet(User::new), UserDTO.class);
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        return dozerBeanMapper.map(userDAO.save(dozerBeanMapper.map(userDTO, User.class)), UserDTO.class);
    }

    @Override
    public void update(Integer id, UserDTO userDTO) {
        for (UserDTO u : getAll())
            if (u.getId() == id) {
                userDTO.setId(id);
                userDAO.save(dozerBeanMapper.map(userDTO, User.class));
                break;
            }
    }

    @Override
    public void delete(Integer id) {
        userDAO.deleteById(id);
    }

}
