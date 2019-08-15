package za.co.mkhabelalucas.simplerestfulapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String headline;
    private String blurb;
    private String image; //In future we can save it as a byte
    private String category;
    private String categoryDisplayName;
    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    public NewsEntity() {

    }

    public NewsEntity(Long id, String headline, String blurb, String image, String category, String categoryDisplayName, String author, Date created, Date updated) {
        this.id = id;
        this.headline = headline;
        this.blurb = blurb;
        this.image = image;
        this.category = category;
        this.categoryDisplayName = categoryDisplayName;
        this.author = author;
        this.created = created;
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryDisplayName() {
        return categoryDisplayName;
    }

    public void setCategoryDisplayName(String categoryDisplayName) {
        this.categoryDisplayName = categoryDisplayName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    @Override
    public String toString() {
        return "NewsEntity{" +
                "id=" + id +
                ", headline='" + headline + '\'' +
                ", blurb='" + blurb + '\'' +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                ", categoryDisplayName='" + categoryDisplayName + '\'' +
                ", author='" + author + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
