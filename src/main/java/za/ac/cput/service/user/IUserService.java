package za.ac.cput.service.user;

import za.ac.cput.domain.user.User;
import za.ac.cput.dto.LoginDTO;
import za.ac.cput.dto.LoginResponse;
import za.ac.cput.service.IService;

import java.util.List;

public interface IUserService extends IService<User, Long> {
    List<User> getAll();

    //LoginResponse loginUser(LoginDTO loginDTO);

}
