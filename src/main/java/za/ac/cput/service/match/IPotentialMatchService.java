package za.ac.cput.service.match;


import za.ac.cput.domain.match.PotentialMatch;
import za.ac.cput.service.IService;

import java.util.List;

public interface IPotentialMatchService extends IService<PotentialMatch, Long> {

    List<PotentialMatch> getAll();


}
