// The equipments of the character.

public class Equipment
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

/* -------------------------------------------------------------------------
    INITIAL ITEMS
   ------------------------------------------------------------------------- */

  private final Item shirt = new Item("Shirt", BODY);
  private final Item jeans = new Item("Jeans", LEG);
  private final Item shoes = new Item("Shoes", FEET);

/* -------------------------------------------------------------------------
    PRIVATE VARIABLES
   ------------------------------------------------------------------------- */

  // The equipment name.
  private Item head = new Item("", HEAD);
  private Item neck = new Item("", NECK);
  private Item rightHand = new Item("", RIGHT_HAND);
  private Item leftHand = new Item("", LEFT_HAND);
  private Item hands = new Item("", HANDS);
  private Item body = shirt;
  private Item leg = jeans;
  private Item back = new Item("", BACK);
  private Item feet = shoes;
  private Item ring1 = new Item("", RING);
  private Item ring2 = new Item("", RING);

/* -------------------------------------------------------------------------
    CONSTRUCTOR
   ------------------------------------------------------------------------- */

  public Equipment()
  {
  } // Equipment

/* -------------------------------------------------------------------------
    SET ITEMS TO EQUIPMENT
   ------------------------------------------------------------------------- */

  // Head
  public void setHead(Item requiredHead)
  {
    head = requiredHead;
  } // setHead

  // Neck
  public void setNeck(Item requiredNeck)
  {
    neck = requiredNeck;
  } // setNeck

  // Right Hand
  public void setRightHand(Item requiredRightHand)
  {
    rightHand= requiredRightHand;
  } // setRightHand

  // Left Hand
  public void setLeftHand(Item requiredLeftHand)
  {
    leftHand = requiredLeftHand;
  } // setLeftHand

  // Hands
  public void setHands(Item requiredHands)
  {
    hands = requiredHands;
  } // setHands

  // Body
  public void setBody(Item requiredBody)
  {
    body = requiredBody;
  } // setBody

  // Leg
  public void setLeg(Item requiredLeg)
  {
    leg = requiredLeg;
  } // setLeg

  // Back
  public void setBack(Item requiredBack)
  {
    back = requiredBack;
  } // setBack

  // Feet
  public void setFeet(Item requiredFeet)
  {
    feet = requiredFeet;
  } // set

  // Ring 1
  public void setRing1(Item requiredRing1)
  {
    ring1 = requiredRing1;
  } // setRing1

  // Ring 2
  public void setRing2(Item requiredRing2)
  {
    ring2 = requiredRing2;
  } // setRing2

/* -------------------------------------------------------------------------
    RETURN ITEMS
   ------------------------------------------------------------------------- */

  // Return head.
  public Item getHead()
  {
    return head;
  } // getHead

  // Return neck.
  public Item getNeck()
  {
    return neck;
  } // getNeck

  // Return right hand.
  public Item getRightHand()
  {
    return rightHand;
  } // getRightHand

  // Return left hand.
  public Item getLeftHand()
  {
    return leftHand;
  } // getLeftHand

  // Return hands
  public Item getHands()
  {
    return hands;
  } // getHands

  // Return body.
  public Item getBody()
  {
    return body;
  } // getBody

  // Return leg.
  public Item getLeg()
  {
    return leg;
  } // getLeg

  // Return back.
  public Item getBack()
  {
    return back;
  } // getBack

  // Return feet.
  public Item getFeet()
  {
    return feet;
  } // getFeet

  // Return ring 1.
  public Item getRing1()
  {
    return ring1;
  } // getRing1

  // Return ring 2.
  public Item getRing2()
  {
    return ring2;
  } // getRing2

} // class Equipment
