package tw.sungo.config;
import tw.sungo.security.JwtFilter; import org.springframework.context.annotation.*; import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.config.http.SessionCreationPolicy; import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.security.web.SecurityFilterChain; import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; import org.springframework.web.servlet.config.annotation.*; import org.springframework.beans.factory.annotation.Value; import java.nio.file.Path;
@Configuration public class SecurityConfig implements WebMvcConfigurer {
 private final JwtFilter jwtFilter; private final String uploadDir;
 public SecurityConfig(JwtFilter f,@Value("${app.upload-dir}") String d){jwtFilter=f;uploadDir=d;}
 @Bean SecurityFilterChain security(HttpSecurity http)throws Exception{return http.csrf(c->c.disable()).cors(c->{}).sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeHttpRequests(a->a.requestMatchers("/api/auth/**","/api/public/**","/uploads/**","/actuator/health").permitAll().requestMatchers("/api/admin/**").hasRole("ADMIN").anyRequest().permitAll()).addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class).build();}
 @Bean PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
 @Override public void addResourceHandlers(ResourceHandlerRegistry registry){String path=Path.of(uploadDir).toAbsolutePath().normalize().toUri().toString();registry.addResourceHandler("/uploads/**").addResourceLocations(path);}
}
