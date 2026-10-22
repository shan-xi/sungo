package tw.sungo.controller;
import tw.sungo.repo.AdminUserRepository; import tw.sungo.security.JwtService; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.web.bind.annotation.*; import org.springframework.http.HttpStatus; import org.springframework.web.server.ResponseStatusException; import jakarta.validation.Valid; import jakarta.validation.constraints.NotBlank;
@RestController @RequestMapping("/api/auth") public class AuthController {
 private final AdminUserRepository users;private final PasswordEncoder encoder;private final JwtService jwt;
 public AuthController(AdminUserRepository u,PasswordEncoder e,JwtService j){users=u;encoder=e;jwt=j;}
 public record LoginRequest(@NotBlank String username,@NotBlank String password){} public record LoginResponse(String token,String username){}
 @PostMapping("/login") public LoginResponse login(@Valid @RequestBody LoginRequest r){var u=users.findByUsername(r.username()).orElseThrow(()->new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid username or password"));if(!encoder.matches(r.password(),u.getPasswordHash()))throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid username or password");return new LoginResponse(jwt.create(u.getUsername()),u.getUsername());}
}
