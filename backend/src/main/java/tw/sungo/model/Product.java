package tw.sungo.model;
import jakarta.persistence.*;
import java.time.Instant;
@Entity @Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String name;
 @Column(nullable=false) private String category;
 @Column(length=3000) private String description;
 private String imageUrl;
 private String code;
 private boolean published=true;
 private int sortOrder=0;
 private Instant createdAt=Instant.now();
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getCategory(){return category;} public void setCategory(String v){category=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public String getImageUrl(){return imageUrl;} public void setImageUrl(String v){imageUrl=v;}
 public String getCode(){return code;} public void setCode(String v){code=v;}
 public boolean isPublished(){return published;} public void setPublished(boolean v){published=v;}
 public int getSortOrder(){return sortOrder;} public void setSortOrder(int v){sortOrder=v;}
 public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant v){createdAt=v;}
}
