package com.example.volumecalculatorapp;

// Model Class untuk ditampilkan di Adapter
public class Shape {
    int shapeImg;
    String shapeName;

    // Constructor
    public Shape(int shapeImg, String shapeName) {
        this.shapeImg = shapeImg;
        this.shapeName = shapeName;
    }

    // Getter & Setter
    public int getShapeImg() {
        return shapeImg;
    }

    public void setShapeImg(int shapeImg) {
        this.shapeImg = shapeImg;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }
}
