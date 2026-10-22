package tw.sungo.model;
import jakarta.persistence.*;
@Entity @Table(name="admin_users")
public class AdminUser {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String username;
 @Column(nullable=false) private String passwordHash;
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getUsername(){return username;} public void setUsername(String v){username=v;}
 public String getPasswordHash(){return passwordHash;} public void setPasswordHash(String v){passwordHash=v;}
}
