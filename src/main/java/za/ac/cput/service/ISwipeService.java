package za.ac.cput.service;

import za.ac.cput.domain.Swipe;

import java.util.List;

public interface ISwipeService extends IService<Swipe, Long> {
    List<Swipe> getAll();
}
