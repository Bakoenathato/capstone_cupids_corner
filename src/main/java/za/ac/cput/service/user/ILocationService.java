package za.ac.cput.service.user;

import za.ac.cput.domain.user.Location;
import za.ac.cput.service.IService;

import java.util.List;

public interface ILocationService extends IService<Location,Long> {
    List<Location> getAll();
}
