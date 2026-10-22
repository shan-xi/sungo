package tw.sungo.model;
import jakarta.persistence.*;
@Entity @Table(name="site_settings")
public class SiteSetting {
 @Id private String settingKey;
 @Column(length=5000) private String settingValue;
 public SiteSetting(){} public SiteSetting(String k,String v){settingKey=k;settingValue=v;}
 public String getSettingKey(){return settingKey;} public void setSettingKey(String v){settingKey=v;}
 public String getSettingValue(){return settingValue;} public void setSettingValue(String v){settingValue=v;}
}
