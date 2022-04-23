package com.astralTinderV1.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChooseYourPartnerService {

    private UserRepository userRepository;

    @Autowired
    public ChooseYourPartnerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User randomUser() {

        List<User> userList = userRepository.findAll();

        int chooseRandomUser = (int) (Math.random() * userList.size());

        User randomUser = userList.get(chooseRandomUser);

        return randomUser;
    }
}
