package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Location;
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
    public void delete(Long postalCode) {
        repository.deleteById(postalCode);
    }

    @Override
    public List<Location> getAll() {
        return repository.findAll();
    }
}