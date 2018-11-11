package soexample.umeng.com.zhoukao1.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class PubusBean {
    @Id(autoincrement = true)
    private  Long id;
    private String images;
    private  String title;
    private String price;
    @Generated(hash = 1407796688)
    public PubusBean(Long id, String images, String title, String price) {
        this.id = id;
        this.images = images;
        this.title = title;
        this.price = price;
    }
    @Generated(hash = 1091079202)
    public PubusBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImages() {
        return this.images;
    }
    public void setImages(String images) {
        this.images = images;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    
}
