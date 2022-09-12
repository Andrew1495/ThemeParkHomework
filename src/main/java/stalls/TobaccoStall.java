package stalls;

import behaviours.ISecure;
import people.Visitor;

public class TobaccoStall extends Stall implements ISecure {

    public TobaccoStall(String name, String ownerName, ParkingSpot parkingSpot, int rating) {
        super(name, ownerName, parkingSpot, rating);
    }


    public boolean isAllowedTo(Visitor vistor) {
        if (vistor.getAge() < 18) {
            return false;
        } else return true;
    }


}
