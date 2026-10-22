package tw.sungo.model;
import jakarta.persistence.*; import java.time.Instant; import java.time.LocalDate;
@Entity @Table(name="news_articles")
public class NewsArticle {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String title;
 @Column(length=500) private String summary;
 @Column(length=12000) private String content;
 private String imageUrl;
 private LocalDate publishedDate=LocalDate.now();
 private boolean published=true;
 private Instant createdAt=Instant.now();
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getSummary(){return summary;} public void setSummary(String v){summary=v;}
 public String getContent(){return content;} public void setContent(String v){content=v;}
 public String getImageUrl(){return imageUrl;} public void setImageUrl(String v){imageUrl=v;}
 public LocalDate getPublishedDate(){return publishedDate;} public void setPublishedDate(LocalDate v){publishedDate=v;}
 public boolean isPublished(){return published;} public void setPublished(boolean v){published=v;}
 public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant v){createdAt=v;}
}
