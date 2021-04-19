package main;

import Service.PlaneService;
import model.Plane;

import java.util.Scanner;

public class AirportTest {
    public static void main(String[] args) {
        PlaneService service = new PlaneService();
        Plane plane1 = service.create();
        Plane plane2 = service.create();
        Plane plane3 = service.create();

        System.out.println("---------------------");
        plane1.printInfo();
        System.out.println("---------------------");
        plane2.printInfo();
        System.out.println("---------------------");
        plane3.printInfo();
        System.out.println("---------------------");

        Plane[] planes = {plane1, plane2, plane3};

        Scanner s = new Scanner(System.in);

        boolean isMenuActive = true;
        while(isMenuActive) {
            System.out.println("1. Print cost and topSpeed if the plane is military otherwise print model and country ");
            System.out.println("2. Return the plane which one is newer (if they have the same age return first one)");
            System.out.println("3. Print country of the plane with smallest seats count (if they have the same - print first).");
            System.out.println("4. Print all not military planes.");
            System.out.println("5. Print all military planes which were in air more than 100 hours.");
            System.out.println("6. Return the plane with minimal weight (if there are some of them return last one).");
            System.out.println("7. Return the plane with minimal cost from all military planes (if there are some of them return first one).");
            System.out.println("8. Print planes in ascending form order by year");
            System.out.println("9. Exit");

            int command = s.nextInt();

            switch (command) {
                case 1:
                    service.printCostAndTopSpeedIfPlaneIsMilitary(plane1);
                    break;
                case 2:
                    service.newestPlane(plane1, plane2);
                    break;
                case 3:
                    service.printCountryOfPlaneWithSmallestSeats(plane1, plane2, plane3);
                    break;
                case 4:
                    service.printAllNotMilitaryPlanes(planes);
                    break;
                case 5:
                    service.printMilitaryPlanesHoursMoreThan100(planes);
                    break;
                case 6:
                    service.planeWithMinimalWeight(planes);
                    break;
                case 7:
                    service.planeWithMinCostFromMilitaries(planes);
                    break;
                case 8:
                    service.orderByYear(planes);
                    break;
                case 9:
                    isMenuActive = false;
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Invalid command number!");
            }
        }
    }
}
