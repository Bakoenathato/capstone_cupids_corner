package za.ac.cput.service;

import za.ac.cput.domain.User;
import za.ac.cput.dto.LoginDTO;
import za.ac.cput.dto.LoginResponse;

import java.util.List;

public interface IUserService extends IService<User, Long> {
    List<User> getAll();

    LoginResponse loginUser(LoginDTO loginDTO);

}
