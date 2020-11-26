// The monsters of the game.

public class Monster
{

/* -------------------------------------------------------------------------
    PRIVATE VALUES
   ------------------------------------------------------------------------- */

  // The name of the monster.
  private String name;

  // The stats of the monster.
  private int level;
  private int expYield;
  private int maxHealth;
  private int currentHealth;
  private int damage;

  // Monster alive status.
  private boolean isAlive = true;

/* -------------------------------------------------------------------------
    CONSTRUCTOR
   ------------------------------------------------------------------------- */

  // Create a monster with name.
  public Monster(String requiredName)
  {
    name = requiredName;
  } // Monster

  // Create a monster with name, level, expYield, health and damage.
  public Monster(String requiredName, int requiredLevel, int requiredExpYield,
                 int requiredHealth, int requiredDamage)
  {
    name = requiredName;
    level = requiredLevel;
    expYield = requiredExpYield;
    maxHealth = requiredHealth;
    currentHealth = maxHealth;
    damage = requiredDamage;
  } // Monster

/* -------------------------------------------------------------------------
    SET METHODS
   ------------------------------------------------------------------------- */

  // Set monster's level.
  public void setLevel(int requiredLevel)
  {
    level = requiredLevel;
  } // setLevel

  // Set monster's expYield.
  public void setExpYield(int requiredExpYield)
  {
    expYield = requiredExpYield;
  } // setExpYield

  // Set monster's maximum health.
  public void setMaxHealth(int requiredHealth)
  {
    maxHealth = requiredHealth;
  } // setMaxHealth

  // Set monster's damage.
  public void setDamage(int requiredDamage)
  {
    damage = requiredDamage;
  } // setDamage

/* -------------------------------------------------------------------------
    INCREASE/DECREASE METHODS
   ------------------------------------------------------------------------- */

  // Monster's current health increases by given amount.
  public void healthIncreases(int amount)
  {
    currentHealth += amount;
    if (currentHealth > maxHealth)
      currentHealth = maxHealth;
  } // healthIncreases

  // Monster's current health decreases by given amount.
  public void healthDecreases(int amount)
  {
    currentHealth -= amount;
    if (currentHealth <= 0)
    {
      currentHealth = 0;
      isAlive = false;
    } // if
  } // healthIncreases

  // Monster's damage increases by given amount.
  public void damageIncreases(int amount)
  {
    damage += amount;
  } // damageIncreases

  // Monster's damage decreases by given amount.
  public void damageDecreases(int amount)
  {
    damage -= amount;
    if (damage < 1)
      damage = 1;
  } // damageDecreases

/* -------------------------------------------------------------------------
    RETURN METHODS
   ------------------------------------------------------------------------- */

  // Return the name of the monster.
  public String getName()
  {
    return name;
  } // getName

  // Return the status of the monster.
  public boolean getStatus()
  {
    return isAlive;
  } // getStatus

  // Return the level of the monster.
  public int getLevel()
  {
    return level;
  } // getLevel

  // Return the experience yield of the monster.
  public int getExpYield()
  {
    // Return a random percent from 1 to 10%.
    int randomPercent = (int) Math.ceil(Math.random() * 10) / 100;
    int randomExpYield = expYield + expYield * randomPercent;
    return randomExpYield;
  } // getExpYield

  // Return the current health of the monster.
  public int getCurrentHealth()
  {
    return currentHealth;
  } // getCurrentHealth

  // Return the maximum health of the monster.
  public int getMaxHealth()
  {
    return maxHealth;
  } // getMaxHealth

  // Return the damage of the monster.
  public int getDamage()
  {
    return damage;
  } // getDamage

  // Return the string representation of a monster.
  public String toString()
  {
    return name + "\nLevel: " + level + "\nHealth: " + currentHealth
           + "/" + maxHealth + "\nDamage: " + damage;
  } // toString

} // class
