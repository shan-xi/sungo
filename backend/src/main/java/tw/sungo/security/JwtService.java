package tw.sungo.security;
import io.jsonwebtoken.Jwts; import io.jsonwebtoken.security.Keys; import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Service; import java.nio.charset.StandardCharsets; import java.time.Instant; import java.util.Date;
@Service public class JwtService {
 private final SecretKey key;
 public JwtService(@Value("${app.jwt-secret}") String secret){ if(secret.getBytes(StandardCharsets.UTF_8).length<32) throw new IllegalArgumentException("JWT_SECRET must be at least 32 bytes"); key=Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)); }
 public String create(String username){Instant now=Instant.now();return Jwts.builder().subject(username).issuedAt(Date.from(now)).expiration(Date.from(now.plusSeconds(60*60*8))).signWith(key).compact();}
 public String username(String token){return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();}
}
