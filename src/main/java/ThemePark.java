import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecure;
import people.Visitor;
import stalls.Stall;

import javax.swing.plaf.metal.MetalBorders;
import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    public ThemePark(){
        this.stalls = new ArrayList<Stall>();
        this.attractions = new ArrayList<Attraction>();
    }

    public void addStall(Stall stall){
        this.stalls.add(stall);
    }
    public void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
    }

    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> reviewed = new ArrayList<IReviewed>(this.stalls);
        reviewed.addAll(attractions);
        return reviewed;
    }


    public void visit(Visitor vistor, Attraction attraction){
        vistor.addVisited(attraction);
        attraction.setVisitCount();

    }

    public HashMap<String, Integer> makeReviews(){
        HashMap<String, Integer> reviews = new HashMap<String, Integer>();
        for (IReviewed reviewed: getAllReviewed()) {
            reviews.put(reviewed.getName(), reviewed.getRating());
        }
        return reviews;
    }

    public ArrayList<IReviewed> getAllowedFor(Visitor vistor){
        ArrayList<IReviewed> canVisit = new ArrayList<IReviewed>();
        for (IReviewed ride:getAllReviewed()){
            if(ride instanceof ISecure){
                if(((ISecure) ride).isAllowedTo(vistor)){
                   canVisit.add(ride);
               }
            }else canVisit.add(ride);
        }
        return canVisit;
        }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public ArrayList<Stall> getStalls() {
        return stalls;
    }
}


