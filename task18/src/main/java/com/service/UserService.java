package com.service;

import com.User;
import com.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class UserService {
    private UserRepository userRepository;
    private MailService mailService;

    @Autowired
    public UserService(UserRepository userRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    @Transactional
    public User read(long id) {
        log.info("Read user by id = {}", id);
        return userRepository.findById(id).get();
    }

    @Transactional
    public List<User> readAll() {
        log.info("Read all users");
        return userRepository.findAll();
    }

    @Transactional
    public void saveUser(User user) {
        log.info("Save user {}", user);
        userRepository.save(user);
        mailService.sendMail(user);
    }

    @Transactional
    public boolean update(User user, long id) {
        log.info("Update user {} by id = {}", user, id);
        user.setId(id);
        userRepository.save(user);
        return true;
    }

    @Transactional
    public boolean deleteUser(long id) {
        log.info("Delete user by id = {}", id);
        userRepository.deleteById(id);
        return true;
    }

    @Transactional
    public List<User> findUsersByFirstName(String firstName) {
        log.info("Find all users by first name = {}", firstName);
        return userRepository.findAllByFirstName(firstName);
    }

    @Transactional
    public List<User> findUsersByLastName(String lastName) {
        log.info("Find all users by last name = {}", lastName);
        return userRepository.findAllByLastName(lastName);
    }
}
