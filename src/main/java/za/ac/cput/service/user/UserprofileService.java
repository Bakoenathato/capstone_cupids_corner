package za.ac.cput.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user.UserProfile;
import za.ac.cput.repository.UserprofileRepository;

import java.util.List;

@Service
public class UserprofileService implements IUserprofileService{
    public UserprofileRepository repository;
    @Autowired
    UserprofileService(UserprofileRepository repository){
        this.repository=repository;
    }

    @Override
    public UserProfile create(UserProfile userProfile) {
        return repository.save(userProfile);
    }

    @Override
    public UserProfile read(Integer profileID) {
        return repository.findById(profileID).orElse(null);
    }

    @Override
    public UserProfile update(UserProfile userProfile) {
        return repository.save(userProfile);
    }

    @Override
    public boolean delete(Integer profileId) {
        if(repository.existsById(profileId)) {
            repository.deleteById(profileId);
            return true;
        } else {
            throw new IllegalStateException("Could not find profile with id: " + profileId);
        }
    }

    @Override
    public List<UserProfile> getAll() {
        return repository.findAll();
    }
}
