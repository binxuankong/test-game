import java.io.*;
import java.util.Random;

// Save the game.
public class SaveGame
{

  // The special string of characters for the save file.
  private final String list = "0123456789!@#$%^&*()ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  private final int listLength = list.length();
  private Random code = new Random();

  // The game to be saved.
  private TheGame theGame;

  // Constructor.
  public SaveGame(TheGame requiredGame)
  {
    theGame = requiredGame;
  } // SaveGame

  // The method to save the game.
  public void saveGame()
  {
    PrintWriter output = null;
    try
    {
      // The file name.
      output = new PrintWriter(new FileWriter("SaveFile.txt"));
      output.println("/////---------------START---------------/////");

      // Generate the character codes.
      String characterCode1 = "";
      for (int index = 0; index < 16; index++)
      {
        characterCode1 += list.charAt(code.nextInt(listLength));
      } // for
      String characterCode2 = "";
      for (int index = 0; index < 16; index++)
      {
        characterCode2 += list.charAt(code.nextInt(listLength));
      } // for
      String characterCode3 = "";
      for (int index = 0; index < 16; index++)
      {
        characterCode3 += list.charAt(code.nextInt(listLength));
      } // for

      // The character part.
      // The character's stats.
      String characterName = theGame.getCharacter().getName();
      String characterLevel = "" + theGame.getCharacter().getLevel();
      String characterCurrentEXP = "" + theGame.getCharacter().getCurrentEXP();
      String characterMaxEXP = "" + theGame.getCharacter().getMaxEXP();
      String characterCurrentHealth = "" + theGame.getCharacter().getCurrentHealth();
      String characterMaxHealth = "" + theGame.getCharacter().getMaxHealth();
      String characterCurrentMiracles = "" + theGame.getCharacter().getCurrentMiracles();
      String characterMaxMiracles = "" + theGame.getCharacter().getMaxMiracles();
      String characterDamage = "" + theGame.getCharacter().getDamage();
      String characterWill = "" + theGame.getCharacter().getWill();
      String characterFocus = "" + theGame.getCharacter().getFocus();
      String characterConfidence = "" + theGame.getCharacter().getConfidence();
      String characterConfusion = "" + theGame.getCharacter().getConfusion();
      String characterDoubt = "" + theGame.getCharacter().getDoubt();
      String characterDespair = "" + theGame.getCharacter().getDespair();

      // Print out in the output file.
      output.println(characterCode1);
      output.println(characterCode1 + characterName + characterCode1);
      output.println(characterCode1 + characterLevel + characterCode1);
      output.println(characterCode1 + characterCurrentEXP + characterCode1);
      output.println(characterCode1 + characterMaxEXP + characterCode1);
      output.println(characterCode1 + characterCurrentHealth + characterCode1);
      output.println(characterCode1 + characterMaxHealth + characterCode1);
      output.println(characterCode1 + characterCurrentMiracles + characterCode1);
      output.println(characterCode1 + characterMaxMiracles + characterCode1);
      output.println(characterCode1 + characterDamage + characterCode1);
      output.println(characterCode1 + characterWill + characterCode1);
      output.println(characterCode1 + characterFocus + characterCode1);
      output.println(characterCode1 + characterConfidence + characterCode1);
      output.println(characterCode1 + characterConfusion + characterCode1);
      output.println(characterCode1 + characterDoubt + characterCode1);
      output.println(characterCode1 + characterDespair + characterCode1);
      output.println("/////---------------END---------------/////");

      // The character's equipment.
      String characterHead = "" + theGame.getCharacter().getEquipment().getHead();
      String characterNeck = "" + theGame.getCharacter().getEquipment().getNeck();
      String characterRightHand = "" + theGame.getCharacter().getEquipment().getRightHand();
      String characterLeftHand = "" + theGame.getCharacter().getEquipment().getLeftHand();
      String characterHands = "" + theGame.getCharacter().getEquipment().getHands();
      String characterBody = "" + theGame.getCharacter().getEquipment().getBody();
      String characterLeg = "" + theGame.getCharacter().getEquipment().getLeg();
      String characterBack = "" + theGame.getCharacter().getEquipment().getBack();
      String characterFeet = "" + theGame.getCharacter().getEquipment().getFeet();
      String characterRing1 = "" + theGame.getCharacter().getEquipment().getRing1();
      String characterRing2 = "" + theGame.getCharacter().getEquipment().getRing2();

      // Print out in the output file.
      output.println(characterCode2);
      output.println(characterCode2 + characterHead + characterCode2);
      output.println(characterCode2 + characterNeck + characterCode2);
      output.println(characterCode2 + characterRightHand + characterCode2);
      output.println(characterCode2 + characterLeftHand + characterCode2);
      output.println(characterCode2 + characterHands + characterCode2);
      output.println(characterCode2 + characterBody + characterCode2);
      output.println(characterCode2 + characterLeg + characterCode2);
      output.println(characterCode2 + characterBack + characterCode2);
      output.println(characterCode2 + characterFeet + characterCode2);
      output.println(characterCode2 + characterRing1 + characterCode2);
      output.println(characterCode2 + characterRing2 + characterCode2);
      output.println("/////---------------END---------------/////");

      // The character's inventory.
      int characterNoOfItems = theGame.getCharacter().getNoOfItems();
      Item[] characterInventory = theGame.getCharacter().getInventory();

      // Print out in the output file.
      output.println(characterCode3);
      output.println(characterCode3 + characterNoOfItems);
      for (int index = 0; index < characterNoOfItems; index++)
        output.println(characterCode3 + characterInventory[index] + characterCode3);
      output.println("/////---------------END---------------/////");

      // Generate the story codes.
      String storyCode = "";
      for (int index = 0; index < 16; index++)
      {
        storyCode += list.charAt(code.nextInt(listLength));
      } // for
      String choiceCode1 = "";
      for (int index = 0; index < 16; index++)
      {
        choiceCode1 += list.charAt(code.nextInt(listLength));
      } // for
      String choiceCode2 = "";
      for (int index = 0; index < 16; index++)
      {
        choiceCode2 += list.charAt(code.nextInt(listLength));
      } // for


      // The story part.
      int currentStage = theGame.getCurrentStage();
      String currentState = theGame.getCurrentState();
      String story = theGame.getStory().getStory();
      String[] storyLines = story.split("\r\n|\r|\n");
      int noOfLines = storyLines.length;

      // Print out in the output file.
      output.println(storyCode);
      output.println(storyCode + currentStage + storyCode);
      output.println(storyCode + currentState + storyCode);
      output.println(storyCode + noOfLines + storyCode);
      for (int index = 0; index < noOfLines; index++)
        output.println(storyCode + storyLines[index] + storyCode);
      output.println("/////---------------END---------------/////");

      // The choice part.
      String choice1 = "" + theGame.getStory().getChoice(1);
      String choice2 = "" + theGame.getStory().getChoice(2);
      String choice3 = "" + theGame.getStory().getChoice(3);
      String choice4 = "" + theGame.getStory().getChoice(4);

      // Print out in the output file.
      output.println(choiceCode1);
      output.println(choiceCode1 + choice1 + choiceCode1);
      output.println(choiceCode1 + choice2 + choiceCode1);
      output.println(choiceCode1 + choice3 + choiceCode1);
      output.println(choiceCode1 + choice4 + choiceCode1);
      output.println("/////---------------END---------------/////");

      // The choice availability.
      String choice1Available;
      if (theGame.getChoiceAvailable(1))
        choice1Available = "TRUE";
      else
        choice1Available = "FALSE";
      String choice2Available;
      if (theGame.getChoiceAvailable(2))
        choice2Available = "TRUE";
      else
        choice2Available = "FALSE";
      String choice3Available;
      if (theGame.getChoiceAvailable(3))
        choice3Available = "TRUE";
      else
        choice3Available = "FALSE";
      String choice4Available;
      if (theGame.getChoiceAvailable(4))
        choice4Available = "TRUE";
      else
        choice4Available = "FALSE";

      // Print out in the output file.
      output.println(choiceCode2);
      output.println(choiceCode2 + choice1Available + choiceCode2);
      output.println(choiceCode2 + choice2Available + choiceCode2);
      output.println(choiceCode2 + choice3Available + choiceCode2);
      output.println(choiceCode2 + choice4Available + choiceCode2);
      output.println("/////---------------END---------------/////");
      
    } // try
    catch (IOException exception)
    {
      System.err.println(exception);
    } // catch
    finally
    {
      if (output != null)
      {
        output.close();
        if (output.checkError())
          System.err.println("Something went wrong with the output");
      } // if
    } // finally
  } // saveGame

} // class SaveGame
