package ua.kiev.prog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /*
    TINYBLOB: maximum length of 255 bytes
    BLOB: maximum length of 65,535 bytes
    MEDIUMBLOB: maximum length of 16,777,215 bytes
    LONGBLOB: maximum length of 4,294,967,295 bytes
     */
    @Column(columnDefinition="MEDIUMBLOB", nullable = false)
    private byte[] image;

    public Photo() {

    }

    public Photo(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", image=" + image.length +
                '}';
    }
}
