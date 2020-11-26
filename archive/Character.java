// The character of the game.

public class Character
{

/* -------------------------------------------------------------------------
    INITIAL VALUES
   ------------------------------------------------------------------------- */

  private final int LEVEL_INITIAL_VALUE = 1;
  private final int MAXEXP_INITIAL_VALUE = 100;
  private final double MAXHEALTH_INITIAL_VALUE = 100;
  private final double MAXMIRACLES_INITIAL_VALUE = 80;
  private final double DAMAGE_INITIAL_VALUE = 25;
  private final double WILL_INITIAL_VALUE = 10;
  private final double FOCUS_INITIAL_VALUE = 10;
  private final double CONFIDENCE_INITIAL_VALUE = 10;
  private final double CONFUSION_INITIAL_VALUE = 10;
  private final double DOUBT_INITIAL_VALUE = 10;
  private final double DESPAIR_INITIAL_VALUE = 10;

/* -------------------------------------------------------------------------
    PRIVATE VARIABLES
   ------------------------------------------------------------------------- */

  // The name of the character.
  private String name;

  // The (initial) stats of the character.
  private int level = LEVEL_INITIAL_VALUE;
  private int maxEXP = MAXEXP_INITIAL_VALUE;
  private double maxHealth = MAXHEALTH_INITIAL_VALUE;
  private double maxMiracles = MAXMIRACLES_INITIAL_VALUE;
  private double damage = DAMAGE_INITIAL_VALUE;
  private double will = WILL_INITIAL_VALUE;
  private double focus = FOCUS_INITIAL_VALUE;
  private double confidence = CONFIDENCE_INITIAL_VALUE;
  private double confusion = CONFUSION_INITIAL_VALUE;
  private double doubt = DOUBT_INITIAL_VALUE;
  private double despair = DESPAIR_INITIAL_VALUE;

  // The current experience of the character.
  private int currentEXP = 0;

  // The current health and miracles of the character.
  private double currentHealth = maxHealth;
  private double currentMiracles = maxMiracles;

  // The equipments of the character.
  private Equipment equipment = new Equipment();

  // The inventory of the character.
  private Item[] inventory = new Item[50];
  private int noOfItems = 0;

  // Character alive status.
  private boolean isAlive = true;

/* -------------------------------------------------------------------------
    CONSTRUCTOR
   ------------------------------------------------------------------------- */

  // Create a character without a name.
  public Character()
  {
  } // Character

  // Create a character with a name.
  public Character(String requiredName)
  {
    name = requiredName;
  } // Character

  // Set the name of the character.
  public void setCharacterName(String requiredName)
  {
    name = requiredName;
  } // setCharacterName

  // Reset the character.
  public void characterReset()
  {
    name = "";
    level = LEVEL_INITIAL_VALUE;
    maxEXP = MAXEXP_INITIAL_VALUE;
    maxHealth = MAXHEALTH_INITIAL_VALUE;
    currentMiracles = MAXMIRACLES_INITIAL_VALUE;
    damage = DAMAGE_INITIAL_VALUE;
    will = WILL_INITIAL_VALUE;
    focus = FOCUS_INITIAL_VALUE;
    confidence = CONFIDENCE_INITIAL_VALUE;
    confusion = CONFUSION_INITIAL_VALUE;
    doubt = DOUBT_INITIAL_VALUE;
    despair = DESPAIR_INITIAL_VALUE;
    currentEXP = 0;
    currentHealth = maxHealth;
    currentMiracles = maxMiracles;
    isAlive = true;
  } // characterReset

/* -------------------------------------------------------------------------
    METHODS TO INCREASE EXP/LEVEL
   ------------------------------------------------------------------------- */

  // Character level up.
  public void levelUp()
  {
    if (level < 100)
    {
      level++;
      maxEXP = 58 + 9 * level * (level + 1) + 15 * level + level % 7;
      double healthPercentage = currentHealth / maxHealth;
      double miraclesPercentage = currentMiracles / maxMiracles;
      maxHealth += (10 + will * 1.2 - confusion * 0.2);
      maxMiracles += (8 + confidence * 0.8 - despair * 0.1);
      damage += (5 + (will + confidence) * 0.05 + focus * 0.5 - doubt * 0.05);
      will += (0.96 + level * 0.03);
      focus += (0.96 + level * 0.03);
      confidence += (0.96 + level * 0.03);
      confusion += (0.48 + level * 0.01);
      doubt += (0.48 + level * 0.01);
      despair += (0.48 + level * 0.01);
      currentEXP = 0;
      currentHealth = maxHealth * healthPercentage;
      currentMiracles = maxMiracles * miraclesPercentage;
    } // if
  } // levelUp

  // Character level up by given amount.
  public void levelUp(int amount)
  {
    for (int index = 0; index < amount; index++)
    {
      levelUp();
    } // for
  } // levelUp

  // Character gains experience by given amount.
  public void expGain(int amount)
  {
    currentEXP += amount;
    if (currentEXP >= maxEXP)
    {
      currentEXP -= maxEXP;
      levelUp();
    } // if
  } // expGain

  // Character loses experience by given amount.
  public void expLost(int amount)
  {
    currentEXP -= amount;
    if (currentEXP < 0)
      currentEXP = 0;
  } // expLost

/* -------------------------------------------------------------------------
    METHODS TO INCREASE STATS
   ------------------------------------------------------------------------- */

  // Set character's maximum health as given amount.
  public void setMaxHealth(int amount)
  {
    maxHealth = amount;
  } // setHealth

  // Character maximum health increases by given amount.
  public void healthUp(int amount)
  {
    maxHealth += amount;
  } // healthUp

  // Set character's maximum miracles as given amount.
  public void setMaxMiracles(int amount)
  {
    maxMiracles = amount;
  } // setMiracles

  // Character maximum miracles increases by given amount.
  public void miraclesUp(int amount)
  {
    maxMiracles += amount;
  } // miraclesUp

  // Set character's damage as given amount.
  public void setDamage(int amount)
  {
    damage = amount;
  } // setDamage

  // Character damage increases by given amount.
  public void damageUp(int amount)
  {
    damage += amount;
  } // damageUp

  // Set character's will as given amount.
  public void setWill(int amount)
  {
    will = amount;
  } // setWill

  // Character will increases by given amount.
  public void willUp(int amount)
  {
    will += amount;
  } // willUp

  // Set character's focus as given amount.
  public void setFocus(int amount)
  {
    focus = amount;
  } // setFocus

  // Character focus increases by given amount.
  public void focusUp(int amount)
  {
    focus += amount;
  } // focusUp

  // Set character's confidence as given amount.
  public void setConfidence(int amount)
  {
    confidence = amount;
  } // setConfidence

  // Character confidence increases by given amount.
  public void confidenceUp(int amount)
  {
    confidence += amount;
  } // confidenceUp

  // Set character's confusion as given amount.
  public void setConfusion(int amount)
  {
    confusion = amount;
  } // setConfusion

  // Character confusion increases by given amount.
  public void confusionUp(int amount)
  {
    confusion += amount;
  } // confusionUp

  // Set character's doubt as given amount.
  public void setDoubt(int amount)
  {
    doubt = amount;
  } // setDoubt

  // Character doubt increases by given amount.
  public void doubtUp(int amount)
  {
    doubt += amount;
  } // doubtUp

  // Set character's despair as given amount.
  public void setDespair(int amount)
  {
    despair = amount;
  } // setDespair

  // Character despair increases by given amount.
  public void despairUp(int amount)
  {
    despair += amount;
  } // despairUp

/* -------------------------------------------------------------------------
    CURRENT HEALTH AND MIRACLES
   ------------------------------------------------------------------------- */

  // Set character's current health as the given amount.
  public void setCurrentHealth(int amount)
  {
    currentHealth = amount;
    if (currentHealth > maxHealth)
      currentHealth = maxHealth;
  } // setCurrentHealth

  // Set character's current miracles as the given amount.
  public void setCurrentMiracles(int amount)
  {
    currentMiracles = amount;
    if (currentMiracles > maxMiracles)
      currentMiracles = maxMiracles;
  } // setCurrentMiracles

  // Character current health increases by given amount.
  public void healthIncreases(int amount)
  {
    currentHealth += amount;
    if (currentHealth > maxHealth)
      currentHealth = maxHealth;
  } // healthIncreases

  // Character current miracles increases by given amount.
  public void miraclesIncreases(int amount)
  {
    currentMiracles += amount;
    if (currentMiracles > maxMiracles)
      currentMiracles = maxMiracles;
  } // miraclesIncreases

  // Character current health increases by given percentage.
  public void healthIncreasesPercentage(int amount)
  {
    currentHealth += (maxHealth * amount / 100);
    if (currentHealth > maxHealth)
      currentHealth = maxHealth;
  } // healthIncreasesPercentage

  // Character current miracles increases by given percentage.
  public void miraclesIncreasesPercentage(int amount)
  {
    currentMiracles += (maxMiracles * amount / 100);
    if (currentMiracles > maxMiracles)
      currentMiracles = maxMiracles;
  } // miraclesIncreasesPercentage

  // Character current health decreases by given amount.
  public void healthDecreases(int amount)
  {
    currentHealth -= amount;
    if (currentHealth <= 0)
    {
      currentHealth = 0;
      isAlive = false;
    }
  } // healthDecreases

  // Character current miracles decreases by given amount.
  public void miraclesDecreases(int amount)
  {
    currentMiracles -= amount;
    if (currentMiracles <= 0)
      currentMiracles = 0;
  } // miraclesDecreases

  // Character current health decreases by given percentage.
  public void healthDecreasesPercentage(int amount)
  {
    currentHealth -= (maxHealth * amount / 100);
    if (currentHealth <= 0)
    {
      currentHealth = 0;
      isAlive = false;
    }
  } // healthDecreasesPercentage

  // Character current miracles decreases by given percentage.
  public void miraclesDecreasesPercentage(int amount)
  {
    currentMiracles -= (maxMiracles * amount / 100);
    if (currentMiracles <= 0)
      currentMiracles = 0;
  } // miraclesDecreasesPercentage

/* -------------------------------------------------------------------------
    ADD ITEMS TO INVENTORY
   ------------------------------------------------------------------------- */

  public void addItem(Item requiredItem)
  {
    inventory[noOfItems] = requiredItem;
    noOfItems++;
  } // addItem

/* -------------------------------------------------------------------------
    RETURN METHODS
   ------------------------------------------------------------------------- */

  // Return the name of the character.
  public String getName()
  {
    return name;
  } // getName

  // Return the status of the character.
  public boolean getStatus()
  {
    return isAlive;
  } // getStatus

  // Return the level of the character.
  public int getLevel()
  {
    return (int) level;
  } // getLevel

  // Return the currentEXP of the character.
  public int getCurrentEXP()
  {
    return currentEXP;
  } // getCurrentEXP

  // Return the maxEXP of the character.
  public int getMaxEXP()
  {
    return maxEXP;
  } // getMaxEXP

  // Return the currentHealth of the character.
  public int getCurrentHealth()
  {
    return (int) currentHealth;
  } // getCurrentHealth

  // Return the maxHealth of the character.
  public int getMaxHealth()
  {
    return (int) maxHealth;
  } // getMaxHealth

  // Return the currentMiracles of the character.
  public int getCurrentMiracles()
  {
    return (int) currentMiracles;
  } // getCurrentMiracles

  // Return the maxMiracles of the character.
  public int getMaxMiracles()
  {
    return (int) maxMiracles;
  } // getMaxMiracles

  // Return the damage of the character.
  public int getDamage()
  {
    return (int) damage;
  } // getDamage

  // Return the will of the character.
  public int getWill()
  {
    return (int) will;
  } // getWill

  // Return the focus of the character.
  public int getFocus()
  {
    return (int) focus;
  } // getFocus

  // Return the confidence of the character.
  public int getConfidence()
  {
    return (int) confidence;
  } // getConfidence

  // Return the confusion of the character.
  public int getConfusion()
  {
    return (int) confusion;
  } // getConfusion

  // Return the doubt of the character.
  public int getDoubt()
  {
    return (int) doubt;
  } // getDoubt

  // Return the despair of the character.
  public int getDespair()
  {
    return (int) despair;
  } // getDespair

  // Return the equipment of the character.
  public Equipment getEquipment()
  {
    return equipment;
  } // getEquipment

  // Return the inventory of the character.
  public Item[] getInventory()
  {
    return inventory;
  } // getInventory

  // Return the item in the inventory of the character.
  public Item getInventory(int requiredItem)
  {
    return inventory[requiredItem];
  } // getInventory

  // Return the number of items in the inventory.
  public int getNoOfItems()
  {
    return noOfItems;
  } // getNoOfItems

} // class Character
