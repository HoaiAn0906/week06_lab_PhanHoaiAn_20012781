package iuh.fit.week06_lab_phanhoaian_20012781.resource;

import iuh.fit.week06_lab_phanhoaian_20012781.request.RegisterRequest;
import iuh.fit.week06_lab_phanhoaian_20012781.response.AuthenticationResponse;
import iuh.fit.week06_lab_phanhoaian_20012781.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import iuh.fit.week06_lab_phanhoaian_20012781.request.LoginRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationResource {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestParam("firstName") String firstName,
            @RequestParam("middleName") String middleName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("avatar") MultipartFile avatar
    ) {
        System.out.println("Registering...");
        RegisterRequest request = new RegisterRequest(firstName, middleName, lastName, email, password);
        return ResponseEntity.ok(authenticationService.register(request, avatar));
    };

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(authenticationService.login(request));
    };
}
