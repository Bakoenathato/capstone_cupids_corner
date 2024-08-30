package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.io.IOException;
import java.util.List;

@Service
public class UserService implements IUserService {
    private UserRepository repository;

    @Autowired
    UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User read(Long userId) {
        return repository.findById(userId).orElse(null);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(Long userId) {
        repository.deleteById(userId);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    //    public User addUserWithImage(User user, MultipartFile imageFile) throws IOException {
//        if (imageFile != null && !imageFile.isEmpty()) {
//            user(imageFile.getBytes());
//        }
//        return repository.save(user);
//    }
    public User addUserWithImage(User user, MultipartFile imageFile) throws IOException {

        User updatedUser = new User.Builder()
                .setUserId(user.getUserId())
                .setUserName(user.getUserName())
                .setPassword(user.getPassword())
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setGender(user.getGender())
                .setCreatedAt(user.getCreatedAt())
                .setDisplayImage(imageFile != null && !imageFile.isEmpty() ? imageFile.getBytes() : user.getDisplayImage())
                .build();

        return repository.save(updatedUser);
    }
//    public User addUserWithBase64Image(User user, String base64Image) {
//        if (base64Image != null && !base64Image.isEmpty()) {
//            byte[] imageBytes = java.util.Base64.getDecoder().decode(base64Image);
//            user.setDisplayImage(imageBytes);
//        }
//        return repository.save(user);
//    }
}
