package za.ac.cput.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user.Location;
import za.ac.cput.repository.LocationRepository;

import java.util.List;

@Service
public class LocationService implements ILocationService {

    public LocationRepository repository;

    @Autowired
    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Location create(Location location) {
        return repository.save(location);
    }

    @Override
    public Location read(Long postalCode) {
        return repository.findById(postalCode).orElse(null);
    }

    @Override
    public Location update(Location location) {
        if (repository.existsById(location.getPostalCode())) {
            return repository.save(location);
        }
        return null;
    }

    @Override
    public boolean delete(Long postalCode) {
        if (repository.existsById(postalCode)) {
            repository.deleteById(postalCode);
            return true;
        } else {
            throw new IllegalStateException("Cannot delete postal code " + postalCode);
        }
    }

    @Override
    public List<Location> getAll() {
        return repository.findAll();
    }
}