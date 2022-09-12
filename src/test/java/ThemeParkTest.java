import attractions.Dodgems;
import attractions.Playground;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.*;

public class ThemeParkTest {

    Visitor vistor1;
    Visitor vistor2;
    Visitor vistor3;

    TobaccoStall tobaccoStall;
    Playground playground;

    CandyflossStall candyFlossStalll;

    ThemePark themePark;



    @Before
    public void setUp(){
            vistor1 = new Visitor(22,180.00,500.00);
            vistor2 = new Visitor(16,150,10.00);
            vistor3 = new Visitor(13,150,10.00);
            tobaccoStall = new TobaccoStall("bob's", "bob", ParkingSpot.A1, 100);
            playground = new Playground("park", 40);
            candyFlossStalll = new CandyflossStall("ted's","ted", ParkingSpot.A2, 30);
            themePark = new ThemePark();
        }



    @Test
    public void addStall() {
        themePark.addStall(tobaccoStall);
        assertEquals(1, themePark.getStalls().size());
    }

    @Test
    public void addAttraction() {
        themePark.addAttraction(playground);
        assertEquals(1, themePark.getAttractions().size());
    }

    @Test
    public void getAllReviewed() {
        themePark.addStall(tobaccoStall);
        themePark.addAttraction(playground);
        themePark.addStall(candyFlossStalll);
        assertEquals(3, themePark.getAllReviewed().size());
    }

    @Test
    public void visit() {
        themePark.visit(vistor3, playground);
        assertEquals(1, vistor3.getVisitedAttractions().size());

    }

    @Test
    public void makeReviews() {
        themePark.addStall(tobaccoStall);
        themePark.addAttraction(playground);
        themePark.addStall(candyFlossStalll);
        assertEquals(new Integer(100), themePark.makeReviews().get("bob's"));
    }

    @Test
    public void getAllowedFor() {
        themePark.addStall(tobaccoStall);
        themePark.addAttraction(playground);
        themePark.addStall(candyFlossStalll);
        assertEquals(1, themePark.getAllowedFor(vistor2).size());
        assertEquals(2, themePark.getAllowedFor(vistor1).size());
    }
}