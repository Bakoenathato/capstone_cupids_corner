package za.ac.cput.service;


import za.ac.cput.domain.PotentialMatch;

import java.util.List;

public interface IPotentialMatchService extends IService<PotentialMatch, Long> {

    List<PotentialMatch> getAll();


}
