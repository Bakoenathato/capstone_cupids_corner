package za.ac.cput.service;

import za.ac.cput.domain.User;
import za.ac.cput.util.LoginDTO;
import za.ac.cput.util.LoginResponse;

import java.util.List;

public interface IUserService extends IService<User, Long> {
    List<User> getAll();

    LoginResponse loginUser(LoginDTO loginDTO);
}
