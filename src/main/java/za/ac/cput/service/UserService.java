package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.util.LoginDTO;
import za.ac.cput.util.LoginResponse;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    private UserRepository repository;

    @Autowired
    UserService(UserRepository repository){
        this.repository = repository;
    }


    @Override
    public User create(User user) {

        if (repository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("There is already a user with this email in the system please try to login");
        }
        if (repository.findByUserName(user.getUserName()) != null) {
            throw new IllegalArgumentException("There is already a user with this username please try anothor one or log in");
        }
        return repository.save(user);
    }

    @Override
    public User read(Long userId){
        return repository.findById(userId).orElse(null);
    }

    @Override
    public User update(User user){
        return repository.save(user);
    }

    @Override
    public void delete(Long userId) {
        repository.deleteById(userId);
    }

    @Override
    public List<User> getAll(){
        return repository.findAll();
    }

    public LoginResponse loginUser(LoginDTO loginDTO) {
        User user1 = repository.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String storedPassword = user1.getPassword();
            if (password.equals(storedPassword)) {
                Optional<User> user = repository.findOneByEmailAndPassword(loginDTO.getEmail(), storedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exists", false);
        }
    }

}
