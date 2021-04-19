package model;

public class Plane {
    private String model = "Airplane";
    private String country = "Armenia";
    private int year = 1903;
    private int hours;
    private boolean military;
    private double weight = 1000;
    private double topSpeed;
    private int seats;
    private double cost;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if ( !model.isEmpty() ) {
            this.model = model;
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if ( !country.isEmpty() ) {
            this.country = country;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if ( year >= 1903 && year <= 2020 ) {
            this.year = year;
        }
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours >= 0 && hours <= 10000 )
            this.hours = hours;
    }

    public boolean isMilitary() {
        return military;
    }

    public void setMilitary(boolean military) {
        this.military = military;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight >= 1000 && weight <= 160000) {
            this.weight = weight;
        }
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        if (topSpeed >= 0) this.topSpeed = topSpeed;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if(seats >= 0) this.seats = seats;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if(cost >= 0) this.cost = cost;
    }

    public Plane(String model, String country, int year, int hours, boolean military){
        this.setModel(model);
        this.setCountry(country);
        this.setYear(year);
        this.setHours(hours);
        this.setMilitary(military);
    }

    public void printInfo() {
        System.out.println("Model: " + model);
        System.out.println("Country: " + country);
        System.out.println("Year: " + year);
        System.out.println("Hours: " + hours);
        System.out.println("IsMilitary: " + (military ? "Yes" : "No"));
        System.out.println("Weight: " + weight);
        System.out.println("TopSpeed: " + topSpeed);
        System.out.println("Seats count: " + seats);
        System.out.println("Cost: " + cost);
    }
}
