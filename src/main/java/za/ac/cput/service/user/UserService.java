package za.ac.cput.service.user;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.UserPrincipal;
import za.ac.cput.domain.user.Role;
import za.ac.cput.domain.user.User;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.service.security.JWTService;

import java.util.List;

@Service
public class UserService implements IUserService{

    private UserRepository repository;

    private AuthenticationManager authManager;

    private JWTService jwtService;

    @Autowired
    UserService(UserRepository repository, AuthenticationManager authManager, JWTService jwtService) {
        this.repository = repository;
        this.authManager = authManager;
        this.jwtService = jwtService;
    }


    @Override
    public User create(User user) {

        if (repository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("There is already a user with this email in the system please try to login");
        }
        if (repository.findByUserName(user.getUserName()) != null) {
            throw new IllegalArgumentException("There is already a user with this username please try another one or log in");
        }
        System.out.println("Raw password: " + user.getPassword());

        String encodedPassword = encoder.encode(user.getPassword());

        User createUser = new User.Builder()
                .setUserName(user.getUserName())
                .setEmail(user.getEmail())
                .setPassword(encodedPassword)
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setGender(user.getGender())
                .setDisplayImage(user.getDisplayImage())
                .setUserRole(user.getUserRole())
                .build();

        return repository.save(createUser);

    }

    @Override
    public User read(Long id) {
        return repository.findById(id).orElseThrow(()-> new IllegalStateException("User with " +
                "Id " + id + " does not exist"));
    }

//    @Override
//    public User update(User user){
//        return repository.save(user);
//    }
//
//    @Override
//    public void delete(Long id) {
//        repository.deleteById(id);
//    }

    @Override
    public User update(User user){
        if (repository.existsById(user.getId())) {
            return repository.save(user); // Perform the update if the user exists
        } else {
            throw new EntityNotFoundException("User not found with ID: " + user.getId());
        }
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id); // Delete user if found
            return true;
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    /*
    * @Override
    public boolean delete(Long userId) {
        if (repository.existsById(userId)) {
            repository.deleteById(userId); // Delete user if found
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }
    * */


    @Override
    public List<User> getAll(){
        return repository.findAll();
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User register(User userInput) {
        if (repository.findByEmail(userInput.getEmail()) != null) {
            throw new IllegalArgumentException("There is already a user with this email in the system please try to login");
        }
        if (repository.findByUserName(userInput.getUserName()) != null) {
            throw new IllegalArgumentException("There is already a user with this username please try another one or log in");
        }

        System.out.println("Raw password: " + userInput.getPassword());

        String encodedPassword = encoder.encode(userInput.getPassword());

        User user = new User.Builder()
                .setUserName(userInput.getUserName())
                .setEmail(userInput.getEmail())
                .setPassword(encodedPassword)
                .setFirstName(userInput.getFirstName())
                .setLastName(userInput.getLastName())
                .setGender(userInput.getGender())
                .setDisplayImage(userInput.getDisplayImage())
                .setUserRole(Role.USER)
                .build();

        return repository.save(user);
    }

//    public LoginResponse loginUser(LoginDTO loginDTO) {
//        User user1 = repository.findByEmail(loginDTO.getEmail());
//        if (user1 != null) {
//            String password = loginDTO.getPassword();
//            String storedPassword = user1.getPassword();
//            if (password.equals(storedPassword)) {
//                Optional<User> user = repository.findOneByEmailAndPassword(loginDTO.getEmail(), storedPassword);
//                if (user.isPresent()) {
//                    return new LoginResponse("Login Success", true);
//                } else {
//                    return new LoginResponse("Login Failed", false);
//                }
//            } else {
//                return new LoginResponse("Password Not Match", false);
//            }
//        } else {
//            return new LoginResponse("Email not exists", false);
//        }
//    }

    public String verify(User user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        if(authentication.isAuthenticated()) {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            return jwtService.generateToken(userPrincipal.getUsername());
        } else {
            throw new RuntimeException("Authentication failed");
        }

//        if(authentication.isAuthenticated()) {
//            return jwtService.generateToken(user.getUserName());
//        } else {
//            return null;
//        }
    }

    public User readCurrent(String username) {
        return repository.findByUserName(username);
    }
}
