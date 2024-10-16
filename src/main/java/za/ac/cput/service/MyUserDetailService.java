package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserPrincipal;
import za.ac.cput.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String input) throws UsernameNotFoundException {
        // check if input is an email or username
        User user = userRepository.findByUserName(input);
        if (user == null) {
            user = userRepository.findByEmail(input);
            if (user == null) {
                throw new UsernameNotFoundException("User not found with email or username" + input);
            }
        }
        return new UserPrincipal(user);
    }
}
