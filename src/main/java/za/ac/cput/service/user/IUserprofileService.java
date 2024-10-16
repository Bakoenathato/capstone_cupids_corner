package za.ac.cput.service.user;

import za.ac.cput.domain.user.UserProfile;
import za.ac.cput.service.IService;

import java.util.List;


public interface IUserprofileService extends IService<UserProfile,Integer> {
    List<UserProfile> getAll();
}
