package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Swipe;

@Repository
public interface SwipeRepository extends JpaRepository<Swipe, Long> {
}
