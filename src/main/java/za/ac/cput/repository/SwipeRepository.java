package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Swipe;
import za.ac.cput.domain.SwipeDirection;
import za.ac.cput.domain.User;

@Repository
public interface SwipeRepository extends JpaRepository<Swipe, Long> {

    boolean existsBySwiper_UserIdAndSwiped_UserIdAndDirection(long swiperUserId, long swipedUserId, SwipeDirection direction);

}
