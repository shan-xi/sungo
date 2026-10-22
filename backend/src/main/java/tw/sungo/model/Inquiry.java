package tw.sungo.model;
import jakarta.persistence.*; import java.time.Instant;
@Entity @Table(name="inquiries")
public class Inquiry {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String name;
 @Column(nullable=false) private String email;
 private String phone;
 private String company;
 @Column(nullable=false,length=4000) private String message;
 private String status="NEW";
 private Instant createdAt=Instant.now();
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getCompany(){return company;} public void setCompany(String v){company=v;}
 public String getMessage(){return message;} public void setMessage(String v){message=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
 public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant v){createdAt=v;}
}
