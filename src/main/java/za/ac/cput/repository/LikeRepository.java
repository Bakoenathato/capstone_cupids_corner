package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.user.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {
}
