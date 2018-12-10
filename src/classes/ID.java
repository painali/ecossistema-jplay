package classes;

/**
 *
 * @author x0n4d0
 */

public enum ID {
    
    SOLO(' ',1),
    FOOD('+',2),
    TREE('#',3);

    
    private final char charID;
    private final int id;
    
    private ID(char charID, int id) {
    	this.charID = charID;
    	this.id = id;
    }

    public int getIntID() {
    	return this.id;
    }
    
    public char getCharID() {
    	return this.charID;
    }

}
