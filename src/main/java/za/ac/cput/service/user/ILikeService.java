package za.ac.cput.service.user;

import za.ac.cput.domain.user.Like;
import za.ac.cput.service.IService;

import java.util.List;

public interface ILikeService extends IService<Like,Long> {
    List<Like> getAll();
}
