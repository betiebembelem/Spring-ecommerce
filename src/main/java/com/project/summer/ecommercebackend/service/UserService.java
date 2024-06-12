package com.project.summer.ecommercebackend.service;

import com.project.summer.ecommercebackend.api.exception.UserAlreadyExistsException;
import com.project.summer.ecommercebackend.api.model.RegistrationBody;
import com.project.summer.ecommercebackend.model.LocalUser;
import com.project.summer.ecommercebackend.model.dao.LocalUserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private LocalUserDAO localUserDAO;

    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if (localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent() ||
                localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()){
            throw new UserAlreadyExistsException();
        }


        LocalUser user = new LocalUser();

        user.setUsername(registrationBody.getUsername());
        user.setEmail(registrationBody.getEmail());
        user.setFirstname(registrationBody.getFirstName());
        user.setLastname(registrationBody.getLastName());
        //TODO: Шифрование пароля
        user.setPassword(registrationBody.getPassword());

        user = localUserDAO.save(user);
        return user;
    }
}
