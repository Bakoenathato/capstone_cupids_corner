package za.ac.cput.service;

import za.ac.cput.domain.Like;

import java.util.List;

public interface ILikeService extends IService<Like,Long>{
    List<Like> getAll();
}
