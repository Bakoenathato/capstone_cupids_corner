package za.ac.cput.service;

import za.ac.cput.domain.UserProfile;

import java.util.List;


public interface IUserprofileService extends IService<UserProfile,Integer>{
    List<UserProfile> getAll();
}
