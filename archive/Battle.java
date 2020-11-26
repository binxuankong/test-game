import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Class to run battles.
public class Battle
{

/* -------------------------------------------------------------------------
    PRIVATE VALUES
   ------------------------------------------------------------------------- */

  // The character in the battle.
  private Character character;

  // The monster in the battle.
  private Monster monster;

  // The status of battle.
  private boolean stillOngoing = false;

  // Character's turn or not.
  private boolean characterTurn;

/* -------------------------------------------------------------------------
    CONSTRUCTOR
   ------------------------------------------------------------------------- */

  // Create a battle with the character and the monster.
  public Battle(Character requiredCharacter, Monster requiredMonster)
  {
    character = requiredCharacter;
    monster = requiredMonster;
    stillOngoing = true;
    // Get random integer between 1 to character + monster level.
    int sumOfLevel = character.getLevel() + monster.getLevel();
    int randomInt = (int) Math.ceil(Math.random() * sumOfLevel);
    if (randomInt <= character.getLevel())
      characterTurn = true;
    else
      characterTurn = false;
  } // Battle

/* -------------------------------------------------------------------------
    BATTLE BETWEEN CHARACTER AND MONSTER
   ------------------------------------------------------------------------- */

  // Character attacks monster.
  public void characterAttack()
  {
    monster.healthDecreases(character.getDamage());
    characterTurn = !characterTurn;
    if (! monster.getStatus())
      stillOngoing = false;
  } // characterAttack

  // Monster attacks character.
  public void monsterAttack()
  {
    character.healthDecreases(monster.getDamage());
    characterTurn = !characterTurn;
    if (! character.getStatus())
      stillOngoing = false;
  } // monsterAttack

  // Character tries to run.
  // Return whether the character successfully runs or not.
  public boolean run()
  {
    // Get random integer between 1 to character +  monster level.
    int sumOfLevel = character.getLevel() + monster.getLevel();
    int randomInt = (int) Math.ceil(Math.random() * sumOfLevel);
    // If character level > monster level, easier to run.
    if (character.getLevel() > monster.getLevel())
    {
      randomInt -= 5;
      if (randomInt <= character.getLevel())
        stillOngoing = false;
      else
        characterTurn = !characterTurn;
    } // if
    // If character level < monster level, harder to run.
    if (character.getLevel() < monster.getLevel())
    {
      randomInt += 5;
      if (randomInt <= character.getLevel())
        stillOngoing = false;
      else
        characterTurn = !characterTurn;
    } // if
    return !stillOngoing;
  } // run

/* -------------------------------------------------------------------------
    RETURN METHODS
   ------------------------------------------------------------------------- */

  // Return the status of the battle.
  public boolean getStatus()
  {
    return stillOngoing;
  } // getStatus

  // Return whether it's the character's turn or not.
  public boolean getTurn()
  {
    return characterTurn;
  } // getTurn

  // Return the monster of the battle.
  public Monster getMonster()
  {
    return monster;
  } // getMonster

/* -------------------------------------------------------------------------
    RETURN METHODS
   ------------------------------------------------------------------------- */

  // Return the String representation of a battle.
  public String toString()
  {
    return "You encountered " + monster.getName() + ".";
  } // toString

  // Return the String representation of a character attack.
  public String characterLine()
  {
    return "You deal " + character.getDamage() + " damage to " + monster.getName() + ".";
  } // characterLine

  // Return the String representation of a monster attack.
  public String monsterLine()
  {
    return monster.getName() + " deals " + monster.getDamage() + " damage to you.";
  } // monsterLine

  // Return the String representation of run successfully.
  public String runSuccessLine()
  {
    return "You ran away!";
  } // runSuccessLine

  // Return the String representation of run fail.
  public String runFailLine()
  {
    return "You tried to run but you can't escape!";
  } // runFailLine

  // Return the String representation of an end battle.
  public String endLine()
  {
    if (character.getStatus())
      return "You defeated " + monster.getName() + "!";
    else
      return monster.getName() + " killed you!";
  } // endLine

} // class Battle
