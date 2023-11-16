package iuh.fit.week06_lab_phanhoaian_20012781.services;

import iuh.fit.week06_lab_phanhoaian_20012781.models.User;
import iuh.fit.week06_lab_phanhoaian_20012781.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServices {
    private final UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
