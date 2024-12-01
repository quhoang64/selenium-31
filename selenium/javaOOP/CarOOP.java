package javaOOP;

public class CarOOP {
    // Thuôc tính
    private String carCompany;
    private String carModel;
    private String carColor;
    private String carEngine;
    private String carPrice;

    protected CarOOP(String carCompany, String carModel, String carColor, String carEngine, String carPrice) {
        this.carCompany = carCompany;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carEngine = carEngine;
        this.carPrice = carPrice;
    }


    protected String getCarPrice() {
        return carPrice;
    }

    protected void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    protected String getCarModel() {
        return carModel;
    }

    protected void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    protected String getCarColor() {
        return carColor;
    }

    protected void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    protected String getCarEngine() {
        return carEngine;
    }

    protected void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

    protected String getCarCompany() {
        return carCompany;
    }

    protected void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    protected void showCarCompany() {
        System.out.println(carCompany);
        System.out.println(carModel);
        System.out.println(carColor);
        System.out.println(carEngine);
        System.out.println(carPrice);
    }

    public static void main(String[] args) {
        CarOOP car = new CarOOP("SSTVN", "Audi A8", "white", "Diesel", "500");
        car.showCarCompany();
    }

}
