package com.sambit.Bean;

public class ImageBean {
    private int imageId;
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
        return "ImageBean{" +
                "imageId=" + imageId +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}
