package attractions;

import behaviours.ISecure;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecure, ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    public boolean isAllowedTo(Visitor vistor) {
        if (vistor.getAge() < 12 && vistor.getHeight() < 145) {
            return false;
        } else return true;
    }

    @Override
    public double defaultPrice() {
        return 8.40;
    }

    @Override
    public double priceFor(Visitor vistor) {
        if (vistor.getHeight() >= 200) {
            return defaultPrice() * 2;
        }
        else return defaultPrice() ;
    }
}
