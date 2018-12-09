package classes;

/**
 *
 * @author x0n4d0
 */

public enum ID {
    
    EMPTY( 	 ' ',1),
    SOLO(	 '#',2),
    FOOD(	 '+',3);
    
    private final char charID;
    private final int id;
    
    private ID(char charID, int id) {
    	this.charID = charID;
    	this.id = id;
    }

    public int getByteId() {
    	return this.id;
    }
    
    public char getcharID() {
    	return this.charID;
    }

}
