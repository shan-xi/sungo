package tw.sungo.controller;
import tw.sungo.model.*;import tw.sungo.repo.*;import org.springframework.web.bind.annotation.*;import org.springframework.http.HttpStatus;import org.springframework.web.server.ResponseStatusException;import jakarta.validation.Valid;import jakarta.validation.constraints.*;import java.util.*;
@RestController @RequestMapping("/api/public") public class PublicController {
 private final ProductRepository products;private final NewsRepository news;private final SettingRepository settings;private final InquiryRepository inquiries;
 public PublicController(ProductRepository p,NewsRepository n,SettingRepository s,InquiryRepository i){products=p;news=n;settings=s;inquiries=i;}
 @GetMapping("/products") public List<Product> products(){return products.findAllByOrderBySortOrderAscIdDesc().stream().filter(Product::isPublished).toList();}
 @GetMapping("/news") public List<NewsArticle> news(){return news.findAllByOrderByPublishedDateDescIdDesc().stream().filter(NewsArticle::isPublished).toList();}
 @GetMapping("/settings") public Map<String,String> settings(){Map<String,String> m=new HashMap<>();settings.findAll().forEach(s->m.put(s.getSettingKey(),s.getSettingValue()));return m;}
 public record InquiryRequest(@NotBlank @Size(max=120) String name,@NotBlank @Email String email,@Size(max=80) String phone,@Size(max=150) String company,@NotBlank @Size(max=4000) String message){}
 @PostMapping("/inquiries") @ResponseStatus(HttpStatus.CREATED) public Map<String,String> inquiry(@Valid @RequestBody InquiryRequest r){Inquiry i=new Inquiry();i.setName(r.name());i.setEmail(r.email());i.setPhone(r.phone());i.setCompany(r.company());i.setMessage(r.message());inquiries.save(i);return Map.of("message","感謝您的詢問，我們已收到您的訊息。");}
}
