package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.PotentialMatch;

import java.util.Optional;

@Repository
public interface PotentialMatchRepository extends JpaRepository<PotentialMatch, Long> {

    Optional<PotentialMatch> findByUser1_IdAndUser2_Id(long user1Id, long user2Id);
}
