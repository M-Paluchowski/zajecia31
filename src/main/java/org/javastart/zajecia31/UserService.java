package org.javastart.zajecia31;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(final UserRepository userRepository, final UserRoleRepository userRoleRepository,
                       final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(String username, String password) {
        final User user = new User();
        user.setPassword(passwordEncoder.encode(password));
        user.setUsername(username);
        user.setEnabled(true);

        final UserRole userRole = new UserRole();
        userRole.setUsername(username);
        userRole.setRole("ROLE_USER");

        userRepository.save(user);
        userRoleRepository.save(userRole);
    }
}
