package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserService{
    private UserRepository repository;

    @Autowired
    UserService(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public User create(User user) {
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
}
