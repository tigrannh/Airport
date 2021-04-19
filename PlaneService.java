package Service;

import model.Plane;

import java.util.Scanner;

public class PlaneService {

    public Plane create(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name of the plane (Any not empty string)");
        String model = s.next();

        System.out.println("Enter country the plane belongs to (Any not empty string)");
        String country = s.next();

        System.out.println("Enter year of plane publishing (from 1903 to 2020)");
        int year = s.nextInt();

        System.out.println("Enter hours in air (from 0 to 10000)");
        int hours = s.nextInt();

        System.out.println("Enter plane is military or not (y/n)");
        boolean isMilitary = s.next().charAt(0) == 'y';

        System.out.println("Enter weight of plane (from 1000 to 160000) KG");
        double weight = s.nextDouble();

        System.out.println("Enter maximal speed per hour (any not negative value)");
        double topSpeed = s.nextDouble();

        System.out.println("Enter number of seats (any not negative value)");
        int seats = s.nextInt();

        System.out.println("Enter cost of plane (any not negative value)");
        double cost = s.nextDouble();

        Plane plane = new Plane(model,country, year, hours, isMilitary);
        plane.setWeight(weight);
        plane.setTopSpeed(topSpeed);
        plane.setSeats(seats);
        plane.setCost(cost);

        return plane;
    }

    public void printCostAndTopSpeedIfPlaneIsMilitary(Plane plane) {
        if(plane.isMilitary())
            System.out.printf("%s %s\n", plane.getCost(), plane.getTopSpeed());
        else
            System.out.printf("%s %s\n", plane.getModel(), plane.getCountry());
    }


    public Plane newestPlane(Plane plane1, Plane plane2) {
        return plane1.getYear() >= plane2.getYear() ? plane1 : plane2;
    }

    public void printCountryOfPlaneWithSmallestSeats(Plane plane1, Plane plane2, Plane plane3) {
        if( plane1.getSeats() <= plane2.getSeats() && plane1.getSeats() <= plane3.getSeats())
            System.out.println(plane1.getCountry());
        else if(plane2.getSeats() <= plane3.getSeats())
            System.out.println(plane2.getCountry());
        else System.out.println(plane3.getCountry());
    }

    public void printAllNotMilitaryPlanes(Plane[] planes) {
        for(Plane plane : planes){
            if(!plane.isMilitary()) plane.printInfo();
        }
    }

    public void printMilitaryPlanesHoursMoreThan100(Plane[] planes) {
        for(Plane plane : planes) {
            if(plane.isMilitary() && plane.getHours() >= 100)
                plane.printInfo();
        }
    }

    public Plane planeWithMinimalWeight(Plane[] planes) {
        Plane min = planes[0];
        for(int i = 1; i < planes.length ; i++) {
            if(planes[i].getWeight() <= min.getWeight()) min = planes[i];
        }
        return min;
    }

    public Plane planeWithMinCostFromMilitaries(Plane[] planes) {
        Plane min = null;
        for(Plane plane: planes){
            if(plane.isMilitary()){
                if(min == null) min = plane;
                else if (plane.getCost() < min.getCost()) min = plane;
            }
        }
        return min;
    }

    public void orderByYear(Plane[] planes) {

        boolean isActive = true;
        int countOfFors = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < planes.length - 1 - countOfFors; i++) {
                if (planes[i].getYear() > planes[i + 1].getYear()) {
                    Plane x = planes[i];
                    planes[i] = planes[i + 1];
                    planes[i + 1] = x;
                    isActive = true;
                }
            }
            countOfFors++;
        }

        for(Plane plane : planes){
            plane.printInfo();
        }
    }

}
