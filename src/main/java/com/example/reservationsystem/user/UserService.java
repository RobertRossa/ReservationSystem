package com.example.reservationsystem.user;

import com.example.reservationsystem.userRole.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        return clientRepository.findByUsername(userName)
//                .orElseThrow(() -> new UsernameNotFoundException("Brak użytkownika o tej nazwie"));
//    }

    public User save(User user) {
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
        user.setRole(new UserRole("client"));
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
