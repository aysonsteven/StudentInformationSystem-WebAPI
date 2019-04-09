package io.project.webapi.auth.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserRepository userRepository;

    @RequestMapping(value = "/{login}", method = RequestMethod.HEAD)
    public ResponseEntity<?> isLoginTaken(@PathVariable String login) {
        return userRepository.findFirstByLogin(login)
            .map(user -> new ResponseEntity<>(HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public User createNewUser(@Validated(User.New.class) @RequestBody User user) {
        return userRepository.save(user);
    }
}
