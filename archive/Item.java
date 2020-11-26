// The items in the game.

public class Item
{

/* -------------------------------------------------------------------------
    FINAL VALUES
   ------------------------------------------------------------------------- */

  private final int HEAD = 1;
  private final int NECK = 2;
  private final int RIGHT_HAND = 3;
  private final int LEFT_HAND = 4;
  private final int HANDS = 5;
  private final int BODY = 6;
  private final int LEG = 7;
  private final int BACK = 8;
  private final int FEET = 9;
  private final int RING = 10;
  private final int OTHERS = 11;

/* -------------------------------------------------------------------------
    PRIVATE VARIABLES
   ------------------------------------------------------------------------- */

  // The item name.
  private final String name;

  // The item type.
  private final int type;

/* -------------------------------------------------------------------------
    CONSTRUCTOR
   ------------------------------------------------------------------------- */

  public Item(String requiredName, int requiredType)
  {
    name = requiredName;
    type = requiredType;
  } // Item

/* -------------------------------------------------------------------------
    RETURN METHODS
   ------------------------------------------------------------------------- */

  // Return the name of the item.
  public String getName()
  {
    return name;
  } // getName

  // Return the type of the item.
  public int getType()
  {
    return type;
  } // getType

  // Return the String representation of the item.
  public String toString()
  {
    return name;
  } // toString

} // class Item
