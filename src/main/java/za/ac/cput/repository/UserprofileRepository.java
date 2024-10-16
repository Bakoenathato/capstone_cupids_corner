package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.user.UserProfile;
@Repository
public interface UserprofileRepository extends JpaRepository<UserProfile,Integer>{;

}
