package io.project.webapi.auth.session;

import io.project.webapi.auth.user.User;
import io.project.webapi.auth.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/sessions")
@CrossOrigin(origins = "http://localhost:4200")
public class SessionController {

    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> login(@Validated(User.Existing.class) @RequestBody User user) {
        return userRepository.findFirstByLoginAndPassword(user.getLogin(), user.getPassword())
            .map(u -> new ResponseEntity<>(HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
    }
}
