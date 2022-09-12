package behaviours;

import people.Visitor;

public interface ISecure {
    boolean isAllowedTo(Visitor vistor);

}
