package com.sambit.Entity;

import javax.persistence.*;

@Entity
@Table
public class Image {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;
    @Column
    private String imageName;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageId=" + imageId +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}
