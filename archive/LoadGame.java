import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

// Load the game.
public class LoadGame
{
  // The saved game.
  private TheGame theGame;

  // The saved character.
  private Character character;

  // Constructor.
  public LoadGame()
  {
  } // LoadGame

  // The moethod to load the game.
  public void loadGame()
  {
    Scanner input = null;
    try
    {
      input = new Scanner(new BufferedReader(new FileReader("SaveFile.txt")));

      // START.
      input.nextLine();

      // Get the character stats code.
      String characterCode1 = input.nextLine();

      // Read the character's stats.
      String characterName = input.nextLine().replace(characterCode1, "");
      int characterLevel = Integer.parseInt(input.nextLine().replace(characterCode1, ""));
      int characterCurrentEXP = Integer.parseInt(input.nextLine().replace(characterCode1, ""));
      int characterMaxEXP = Integer.parseInt(input.nextLine().replace(characterCode1, ""));
      int characterCurrentHealth = Integer.parseInt(input.nextLine().replace(characterCode1, ""));
      int characterMaxHealth = Integer.parseInt(input.nextLine().replace(characterCode1, ""));
      int characterCurrentMiracles = Integer.parseInt(input.nextLine().replace(characterCode1, ""));
      int characterMaxMiracles = Integer.parseInt(input.nextLine().replace(characterCode1, ""));
      int characterDamage = Integer.parseInt(input.nextLine().replace(characterCode1, ""));
      int characterWill = Integer.parseInt(input.nextLine().replace(characterCode1, ""));
      int characterFocus = Integer.parseInt(input.nextLine().replace(characterCode1, ""));
      int characterConfidence = Integer.parseInt(input.nextLine().replace(characterCode1, ""));
      int characterConfusion = Integer.parseInt(input.nextLine().replace(characterCode1, ""));
      int characterDoubt = Integer.parseInt(input.nextLine().replace(characterCode1, ""));
      int characterDespair = Integer.parseInt(input.nextLine().replace(characterCode1, ""));

      // Create the character and set the stats.
      character = new Character(characterName);
      character.levelUp(characterLevel - 1);
      character.expGain(characterCurrentEXP);
      character.setMaxHealth(characterMaxHealth);
      character.setCurrentHealth(characterCurrentHealth);
      character.setMaxMiracles(characterMaxMiracles);
      character.setCurrentMiracles(characterCurrentMiracles);
      character.setDamage(characterDamage);
      character.setWill(characterWill);
      character.setFocus(characterFocus);
      character.setConfidence(characterConfidence);
      character.setConfusion(characterConfusion);
      character.setDoubt(characterDoubt);
      character.setDespair(characterDespair);

      // END
      input.nextLine();

      // Get the character equpment code.
      String characterCode2 = input.nextLine();

      // Read the character's equipment.
      Item head = new Item(input.nextLine().replace(characterCode2, ""), 1);
      Item neck = new Item(input.nextLine().replace(characterCode2, ""), 2);
      Item rightHand = new Item(input.nextLine().replace(characterCode2, ""), 3);
      Item leftHand = new Item(input.nextLine().replace(characterCode2, ""), 4);
      Item hands = new Item(input.nextLine().replace(characterCode2, ""), 5);
      Item body = new Item(input.nextLine().replace(characterCode2, ""), 6);
      Item leg = new Item(input.nextLine().replace(characterCode2, ""), 7);
      Item back = new Item(input.nextLine().replace(characterCode2, ""), 8);
      Item feet = new Item(input.nextLine().replace(characterCode2, ""), 9);
      Item ring1 = new Item(input.nextLine().replace(characterCode2, ""), 10);
      Item ring2 = new Item(input.nextLine().replace(characterCode2, ""), 10);

      // Set the equipments for the character.
      character.getEquipment().setHead(head);
      character.getEquipment().setNeck(neck);
      character.getEquipment().setRightHand(rightHand);
      character.getEquipment().setLeftHand(leftHand);
      character.getEquipment().setHands(hands);
      character.getEquipment().setBody(body);
      character.getEquipment().setLeg(leg);
      character.getEquipment().setBack(back);
      character.getEquipment().setFeet(feet);
      character.getEquipment().setRing1(ring1);
      character.getEquipment().setRing2(ring2);

      // END
      input.nextLine();

      // Get the character inventory code.
      String characterCode3 = input.nextLine();

      // Read the character's inventory.
      int noOfItems = Integer.parseInt(input.nextLine().replace(characterCode3, ""));
      for (int index = 0; index < noOfItems; index++)
        character.addItem(new Item(input.nextLine().replace(characterCode3, ""), 11));

      // END
      input.nextLine();

      // Get the story code.
      String storyCode = input.nextLine();

      // Read the story stage/code.
      int currentStage = Integer.parseInt(input.nextLine().replace(storyCode, ""));
      String currentState = input.nextLine().replace(storyCode, "");

      // Read the story.
      int noOfLines = Integer.parseInt(input.nextLine().replace(storyCode, ""));
      String thisStory = input.nextLine().replace(storyCode, "");
      for (int index = 1; index < noOfLines; index++)
        thisStory += "\n" + input.nextLine().replace(storyCode, "");

      // Create the game.
      theGame = new TheGame(character);
      Story story = new Story(thisStory);
      theGame.setGameStarted(true);
      theGame.setStory(story);
      theGame.setStage(currentStage);
      theGame.setState(currentState);

      // END
      input.nextLine();

      // Get the choice code.
      String choiceCode1 = input.nextLine();

      // Get the choice.
      Choice choice1 = new Choice(input.nextLine().replace(choiceCode1, ""), 1);
      Choice choice2 = new Choice(input.nextLine().replace(choiceCode1, ""), 2);
      Choice choice3 = new Choice(input.nextLine().replace(choiceCode1, ""), 3);
      Choice choice4 = new Choice(input.nextLine().replace(choiceCode1, ""), 4);

      // Set the choice to the story.
      story.setChoice(1, choice1);
      story.setChoice(2, choice2);
      story.setChoice(3, choice3);
      story.setChoice(4, choice4);

      // END
      input.nextLine();

      // Get the choice available code.
      String choiceCode2 = input.nextLine();

      // Get the choice available.
      String choice1Available = input.nextLine().replace(choiceCode2, "");
      String choice2Available = input.nextLine().replace(choiceCode2, "");
      String choice3Available = input.nextLine().replace(choiceCode2, "");
      String choice4Available = input.nextLine().replace(choiceCode2, "");

      // Set choice available.
      theGame.setChoiceAvailable(1, (choice1Available.startsWith("T")));
      theGame.setChoiceAvailable(2, (choice2Available.startsWith("T")));
      theGame.setChoiceAvailable(3, (choice3Available.startsWith("T")));
      theGame.setChoiceAvailable(4, (choice4Available.startsWith("T")));

      // END
      input.nextLine();
    } // try
    catch (IOException exception)
    {
      System.err.println(exception);
    } // catch
    finally
    {
      if (input != null) input.close();
    } // finally
  } // loadGame

  // Return the game.
  public TheGame getGame()
  {
    return theGame;
  } // getGame

  // Return the character.
  public Character getCharacter()
  {
    return character;
  } // getCharacter
} // class LoadGame
