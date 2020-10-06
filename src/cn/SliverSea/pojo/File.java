package cn.SliverSea.pojo;

import java.sql.Date;
import java.sql.Time;

public class File {
    private int id;
    private String name;
    private String images;
    private String description;
    private float size;
    private int star;
    private Date time;





    public File() {
        super();
    }


    public File(int id, String name,String images, String description, float size, int star, Date time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.star = star;
        this.time = time;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    public String getImages() {
        return images;
    }

    public void setImages(String image) {
        this.images = image;
    }

}
