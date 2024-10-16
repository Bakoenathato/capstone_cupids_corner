package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.user.User;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //User findByUserId(Long id);

    Optional<User> findOneByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    User findByUserName(String userName);

    Optional <User> findByUserNameOrEmail(String userName, String email);
}
