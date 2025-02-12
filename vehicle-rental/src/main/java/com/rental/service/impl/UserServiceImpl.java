package com.rental.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entity.User;
import com.rental.repository.UserRepository;
import com.rental.service.HashingService;
import com.rental.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private HashingService passwordEncoder;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(String username, String email, String password) {
        String encodedPassword = passwordEncoder.encrypt(password);

        User newUser = new User(username, email, encodedPassword);

        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(String id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

//	@Override
//	public User createUser(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
