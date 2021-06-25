package com.example.reservationsystem.user;

import com.example.reservationsystem.userRole.UserRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserService() {
    }

    public List<UserDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(this::convertToUserReservationDTO)
                .collect(Collectors.toList());
    }

    private UserDTO convertToUserReservationDTO(User user) {
        UserDTO userReservationDTO = new UserDTO();
        userReservationDTO.setUserId(user.getId());
        userReservationDTO.setFirstName(user.getFirstName());
        userReservationDTO.setLastName(user.getLastName());
        return userReservationDTO;
    }


    public User save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
//        user.setRoleId(new UserRole("user"));

        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return userRepository.findByFirstName(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Brak użytkownika o takim email"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
