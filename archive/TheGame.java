// Class to run the game.
// It contains the correct, the story and the choices.

public class TheGame
{

/* -------------------------------------------------------------------------
    INITIAL VALUES
   ------------------------------------------------------------------------- */

  // The starting state.
  private Choice choice1 = new Choice(1, "");
  private Choice choice2 = new Choice(2, "");
  private Choice choice3 = new Choice(3, "");
  private Choice choice4 = new Choice(4, "");
  private final Story INITIAL_STORY = new Story("Create your character and start your adventure!", choice1, choice2, choice3, choice4); 

  // Booleans
  private boolean gameStarted = false;
  private boolean battleStarted = false;
  private boolean choice1Available = true;
  private boolean choice2Available = true;
  private boolean choice3Available = true;
  private boolean choice4Available = true;

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

  // The character.
  private Character character;

  // The story,
  private Story story = INITIAL_STORY;

  // The battle.
  private Battle battle;
  private Story battleStory = new Story("", choice1, choice2, choice3, choice4);

  // The current stage and state of the game.
  private int currentStage = 0;
  private String currentState = "1";
  private String previousState;

/* -------------------------------------------------------------------------
    CONSTRUCTOR
   ------------------------------------------------------------------------- */

  // Create the game without a character.
  public TheGame()
  {
  } // TheGame

  // Create the game with a character.
  public TheGame(Character requiredCharacter)
  {
    character = requiredCharacter;
  } // TheGame

/* -------------------------------------------------------------------------
    SET METHODS
   ------------------------------------------------------------------------- */

  // Change the character of the game.
  public void setCharacter(Character requiredCharacter)
  {
    character = requiredCharacter;
  } // setCharacter

  // Set the game started.
  public void setGameStarted(boolean started)
  {
    gameStarted = started;
  } // setGameStarted

  // Change the story of the game.
  public void setStory(Story requiredStory)
  {
    story = requiredStory;
  } // setStory

  public void setImage(String requiredString)
  {
    story.setImage(requiredString);
  } // setImage

  // Set the current stage of the game.
  public void setStage(int requiredStage)
  {
    currentStage = requiredStage;
  } // setStage

  // Set the current state of the game.
  public void setState(String requiredState)
  {
    currentState = requiredState;
  } // setState

  // Set choice available.
  public void setChoiceAvailable(int choiceNo, boolean choiceAvailable)
  {
    if (choiceNo == 1)
      choice1Available = choiceAvailable;
    else if (choiceNo == 2)
      choice2Available = choiceAvailable;
    else if (choiceNo == 3)
      choice3Available = choiceAvailable;
    else if (choiceNo == 4)
      choice4Available = choiceAvailable;
  } // setChoiceAvailable

/* -------------------------------------------------------------------------
    START GAME (STAGE 1)
   ------------------------------------------------------------------------- */

  public void startGame()
  {
    gameStarted = true;
    currentStage++;
    story.setStory("An arrow to the head...");
    story.setImage("arrow.jpg");
    story.getChoice(1).setChoiceStory("I can't breathe.");
    story.getChoice(2).setChoiceStory("I can't see.");
    story.getChoice(3).setChoiceStory("Plu....");
    story.getChoice(4).setChoiceStory("*Reach for the arrow*");
  } // startGame()

/* -------------------------------------------------------------------------
    TO NEXT STAGE
   ------------------------------------------------------------------------- */

  public void nextStage(int choiceSelected)
  {

/* -------------------------------------------------------------------------
    STAGE 1
   ------------------------------------------------------------------------- */

    if (currentState == "1")
    {
      // Choice 1.
      if (choiceSelected == 1)
      {
        currentStage++;
        currentState = "1.1";
        story.setStory("You go into shock. The pain is too unbearable. Your breathing is affected.");
        story.getChoice(1).setChoiceStory("Let go, just rest for a little while...");
        story.getChoice(2).setChoiceStory("Plu!!!");
        story.getChoice(3).setChoiceStory("Reach for HOPE");
        story.getChoice(4).setChoiceStory("*Reach for the arrow*");
      } // if

      // Choice 2.
      else if (choiceSelected == 2)
      {
        currentStage++;
        currentState = "1.2";
        story.setStory("Blinded, you see nothing ahead. Your eyes are worthless now.");
        story.getChoice(1).setChoiceStory("Let the heavy lids close by themselves, just rest for a little while.");
        story.getChoice(2).setChoiceStory("Plu!!!");
        story.getChoice(3).setChoiceStory("Reach for HOPE");
        story.getChoice(4).setChoiceStory("*Reach for the arrow*");
      } // else if

      // Choice 3
      else if (choiceSelected == 3)
      {
        currentStage++;
        currentState = "1.3";
        story.setStory(
"You hear a strong bark from a distance. Under the circumstances, Plu still remains sturdy and unwavering."
+ "\nWhat is your excuse?"
        );
        story.getChoice(1).setChoiceStory("Nothing, I am worthless.");
        story.getChoice(2).setChoiceStory("PLU!!!!!!!!!!");
        story.getChoice(3).setChoiceStory("It hurts... so bad...");
        story.getChoice(4).setChoiceStory("It's coming!");
      } // else if

      // Choice 4
      else
      {
        currentStage++;
        currentState = "1.4";
        story.setStory(
"An arrow of darkness, fluid and formless, yet so solid. It pierces your head, yet you feel nothing."
+ "\nIt pierces, YOUR MIND, rather, conjuring all pain and suffering; to let you feel it all at once."
+ "\nThe temptation of giving in manifests under it's morbid and sinister influence."
        );
        story.getChoice(1).setChoiceStory("Succumb, to everlasting darkness!");
        story.getChoice(2).setChoiceStory("Plu!!!");
        story.getChoice(3).setChoiceStory("Resist, and reach for HOPE.");
        story.getChoice(4).setChoiceStory("It's coming...");
      } // else
    } // if

/* -------------------------------------------------------------------------
    STAGE 2 SCENARIO 1
   ------------------------------------------------------------------------- */

    else if (currentState == "1.1" || currentState == "1.2")
    {
      // Choice 1.
      if (choiceSelected == 1)
      {
        currentStage++;
        currentState = "1.1.1";
        story.setStory(
"Weariness drowns your senses, as a heavy feeling of relief start to overwhelm you. Plu runs towards"
+ "\nyou just as you start to lose consciousness. Such a loyal friend, unfortunately met with a weak master."
+ "\nWait! It cannot end this way!"
+ "\n\"HEY! We came too far for you to let go! We rely on each other. Now get my ass back up and fight!\""
+ "\nYour comrade chided you. She puts out her hand. They are fighting for their lives."
        );
        story.getChoice(1).setChoiceStory("*Accept her hand and stand back up*");
        story.getChoice(2).setChoiceStory("*Slap the hand that was presented to you*");
        story.getChoice(3).setChoiceStory("*Take one away and give two back*");
        story.getChoice(4).setChoiceStory("*Stand up on your own*");
      } // if

      // Choice 2.
      else if (choiceSelected == 2)
      {
        currentStage++;
        currentState = "1.1.2";
        story.setStory(
"Your excruciating call draws your loyal pet to you like a supermagnet would a metal ball."
+ "\nPlu! Still fighting and strong!"
+ "\nIts reliability and strength highlighted through this encounter, you are reminded of the reason the two"
+ "\nof you travelled together."
        );
        story.getChoice(1).setChoiceStory("");
        story.getChoice(2).setChoiceStory("");
        story.getChoice(3).setChoiceStory("");
        story.getChoice(4).setChoiceStory("");
      } // else if

      // Choice 3.
      else if (choiceSelected == 3)
      {
        currentStage++;
        currentState = "1.1.3";
        story.setStory(
"You try your best to see around you despite your distorted sight. There isn't much time left."
+ "\nIt's approaching. Holding tight to Plu, you close your eyes and wish for the best. You-"
        );
        story.getChoice(1).setChoiceStory("");
        story.getChoice(2).setChoiceStory("");
        story.getChoice(3).setChoiceStory("");
        story.getChoice(4).setChoiceStory("");
      } // else if

      // Choice 4
      else
      {
        currentStage++;
        currentState = "1.4";
        story.setStory(
"An arrow of darkness, fluid and formless, yet so solid. It pierces your head, yet you feel nothing."
+ "\nIt pierces, YOUR MIND, rather, conjuring all pain and suffering; to let you feel it all at once."
+ "\nThe temptation of giving in manifests under it's morbid and sinister influence."
        );
        story.getChoice(1).setChoiceStory("Succumb, to everlasting darkness!");
        story.getChoice(2).setChoiceStory("Plu!!!");
        story.getChoice(3).setChoiceStory("Resist, and reach for HOPE.");
        story.getChoice(4).setChoiceStory("It's coming...");
      } // else
    } // else if

/* -------------------------------------------------------------------------
    STAGE 2 SCENARIO 2
   ------------------------------------------------------------------------- */

    else if (currentState == "1.3")
    {
      // Choice 1.
      if (choiceSelected == 1)
      {
        currentStage++;
        currentState = "1.3.1";
        story.setStory(
"Always first to judge yourself before others. Is this really the right time to bathe in your self pity?"
+ "\nActing like this does not do you any justice, or rather Plu and us in this situation, Your comrade"
+ "\nchided you. She puts out her hand. They are fighting for their lives."
        );
        story.getChoice(1).setChoiceStory("*Accept her hand and stand back up*");
        story.getChoice(2).setChoiceStory("*Slap the hand that was presented to you*");
        story.getChoice(3).setChoiceStory("*Take one away and give two back*");
        story.getChoice(4).setChoiceStory("*Stand up on your own*");
      } // if

      // Choice 2.
      else if (choiceSelected == 2)
      {
        currentStage++;
        currentState = "1.1.2";
        story.setStory(
"Your excruciating call draws your loyal pet to you like a supermagnet would a metal ball."
+ "\nPlu! Still fighting and strong!"
+ "\nIts reliability and strength highlighted through this encounter, you are reminded of the reason the two"
+ "\nof you travelled together."
        );
        story.getChoice(1).setChoiceStory("");
        story.getChoice(2).setChoiceStory("");
        story.getChoice(3).setChoiceStory("");
        story.getChoice(4).setChoiceStory("");
      } // else if

      // Choice 3.
      else if (choiceSelected == 3)
      {
        currentStage++;
        currentState = "1.4";
        story.setStory(
"An arrow of darkness, fluid and formless, yet so solid. It pierces your head, yet you feel nothing."
+ "\nIt pierces, YOUR MIND, rather, conjuring all pain and suffering; to let you feel it all at once."
+ "\nThe temptation of giving in manifests under it's morbid and sinister influence."
        );
        story.getChoice(1).setChoiceStory("Succumb, to everlasting darkness!");
        story.getChoice(2).setChoiceStory("Plu!!!");
        story.getChoice(3).setChoiceStory("Resist, and reach for HOPE.");
        story.getChoice(4).setChoiceStory("It's coming...");
      } // else

      // Choice 4.
      else
      {
        currentStage++;
        currentState = "1.3.4";
        story.setStory(
"You're anxious. It's too late! You thought you were ready but you're not."
+ "\nReality strikes you like a train, as you get closer and closer to be overcome by it! You-"
        );
        story.getChoice(1).setChoiceStory("");
        story.getChoice(2).setChoiceStory("");
        story.getChoice(3).setChoiceStory("");
        story.getChoice(4).setChoiceStory("");
      } // else
    } // else if

/* -------------------------------------------------------------------------
    STAGE 2 SCENARIO 3
   ------------------------------------------------------------------------- */

    else if (currentState == "1.4")
    {
      // Choice 1.
      if (choiceSelected == 1)
      {
        currentStage++;
        currentState = "1.4.1";
        story.setStory(
"You give in. It envelopes you. Darkness, such a peaceful yet disturbing force, but you only chose"
+ "\nto acknowledge the peace that comes with. The suffering persisted, but came to a halt soon after you"
+ "\naccepted your fate- the unchanging path into the abyss..."
        );
        story.getChoice(1).setChoiceStory("");
        story.getChoice(2).setChoiceStory("");
        story.getChoice(3).setChoiceStory("");
        story.getChoice(4).setChoiceStory("");
      } // if

      // Choice 2.
      else if (choiceSelected == 2)
      {
        currentStage++;
        currentState = "1.1.2";
        story.setStory(
"Your excruciating call draws your loyal pet to you like a supermagnet would a metal ball."
+ "\nPlu! Still fighting and strong!"
+ "\nIts reliability and strength highlighted through this encounter, you are reminded of the reason the two"
+ "\nof you travelled together."
        );
        story.getChoice(1).setChoiceStory("");
        story.getChoice(2).setChoiceStory("");
        story.getChoice(3).setChoiceStory("");
        story.getChoice(4).setChoiceStory("");
      } // else if

      // Choice 3.
      else if (choiceSelected == 3)
      {
        currentStage++;
        currentState = "1.1.3";
        story.setStory(
"You try your best to see around you despite your distorted sight. There isn't much time left."
+ "\nIt's approaching. Holding tight to Plu, you close your eyes and wish for the best. You-"
        );
        story.getChoice(1).setChoiceStory("");
        story.getChoice(2).setChoiceStory("");
        story.getChoice(3).setChoiceStory("");
        story.getChoice(4).setChoiceStory("");
      } // else if

      // Choice 4.
      else
      {
        currentStage++;
        currentState = "1.1.4";
        story.setStory(
"You're anxious. It's too late! You thought you were ready but you're not."
+ "\nReality strikes you like a train, as you get closer and closer to be overcome by it! You-"
        );
        story.getChoice(1).setChoiceStory("");
        story.getChoice(2).setChoiceStory("");
        story.getChoice(3).setChoiceStory("");
        story.getChoice(4).setChoiceStory("");
      } // else
    } // else if

/* -------------------------------------------------------------------------
    STAGE 3 SCENARIO 1
   ------------------------------------------------------------------------- */

    else if (currentState == "1.1.1" || currentState == "1.3.1")
    {
      // Choice 1.
      if (choiceSelected == 1)
      {
        currentStage++;
        currentState = "1.1.1.1";
        story.setStory(
"You tightly grasp her slender hand presented to you. The firmness of your grip while Ade pulls "
+ "\nsubconsciously projects your appreciation for them, your friends."
+ "\nYou're up. You're running. With regained confidence, you hold the arrow's butt, and pulled it out "
+ "\neffortlessly with a triumphant roar; throwing it away as you start running."
+ "\nYou feel the dark streams whisk away in your wake, as you put all behind you, and STRIKE!"
        );
        story.getChoice(1).setChoiceStory("");
        story.getChoice(2).setChoiceStory("");
        story.getChoice(3).setChoiceStory("");
        story.getChoice(4).setChoiceStory("");
      } // if

      // Choice 2.
      else if (choiceSelected == 2)
      {
        currentStage++;
        currentState = "1.1.1.2";
        story.setStory(
"A pathetic choice done with pathetic strength, only to have her catch it and pull you up. Your "
+ "\nfriends will never let you down, you realised, only you will."
+ "\nBathed in self pity, you slowly get up when- *SLAP* You got slapped instead! \"You better wake up and "
+ "\nget my mind straight!\""
+ "\nHand throbbing, Ade hauled you up like a sack of potatoes. Hmm, potatoes, if only you could be so "
+ "\nmajestic and laid back."
+ "\nNonsense! You brush away your negative and useless thoughts, and renewed your focus and determination." 
+ "\nBravery followed suit, as you hold the arrow's butt, and pulled it out effortlessly with a triumphant "
+ "\nroar; throwing it away as you start running."
+ "\nYou feel the dark streams whisk away in your wake as you picked up pace, and STRIKE!"
        );
        story.getChoice(1).setChoiceStory("");
        story.getChoice(2).setChoiceStory("");
        story.getChoice(3).setChoiceStory("");
        story.getChoice(4).setChoiceStory("");
      } // else if

      // Choice 3.
      else if (choiceSelected == 3)
      {
        currentStage++;
        currentState = "1.1.1.3";
        story.setStory(
"The sign of comaradery between the both of you. You swiped at the air above her palm, reached into "
+ "\nyour pocket, and grabbed her outreached hand, discretely placing two tiny sand bags of blue and red "
+ "\nrespectively. A show of trust and belonging, and maybe a little obsessive ownership, but you dont "
+ "\nmind. It has never harmed you. Locking eyes, you both traded a nod of acknowledgement, and scurried "
+ "\nin different directions."
+ "\nYou're up. You're running. With regained confidence, you hold the arrow's butt, and pulled it out "
+ "\neffortlessly with a triumphant roar; throwing it away."
+ "\nYou feel the dark streams whisk away in your wake, as you put it all behind you, and STRIKE!"
        );
        story.getChoice(1).setChoiceStory("");
        story.getChoice(2).setChoiceStory("");
        story.getChoice(3).setChoiceStory("");
        story.getChoice(4).setChoiceStory("");
      } // else if

      // Choice 4
      else
      {
        currentStage++;
        currentState = "1.1.1.4";
        story.setStory(
"How could you let your friends down? Pathetic. You smirk at your own act, and a glint of renewed "
+ "\ndetermination sparks in your eyes as you picked yourself up."
+ "\nConfused at first, Ade now retracts her offered hand, as she spots that you'll be just fine, and "
+ "\nredirects her focus back at the enemy."
+ "\nSupport from your peers, that's all you needed, you thought, as you stared unawaringly at Ade, whom "
+ "\nis prancing gracefully around the battleground, masterfully wielding her bow and arrows. You engage in "
+ "\na sprint at the enemy as you collected yourself. Running, you hold the arrow's butt, and pulled it out "
+ "\neffortlessly with a triumphant roar; throwing it away behind you. You feel the dark streams whisk away "
+ "\nin your wake, as you close in on the enemy, and STRIKE!"
        );
        story.getChoice(1).setChoiceStory("Succumb, to everlasting darkness!");
        story.getChoice(2).setChoiceStory("Plu!!!");
        story.getChoice(3).setChoiceStory("Resist, and reach for HOPE.");
        story.getChoice(4).setChoiceStory("It's coming...");
      } // else
    } // else if

/* -------------------------------------------------------------------------
    STAGE 3 SCENARIO 2
   ------------------------------------------------------------------------- */

/*    else if (currentState == "2AA")
    {
      if (battleStarted)
      {
        startBattle();
        previousState = currentState;
        currentState = "BATTLE";
      } // if
      else
      {
        currentStage++;
        currentState = "2AAA";
        story.setStory("You continued your journey north after defeating the pack of wolves.");
        story.getChoice(1).setChoiceStory("Continue north.");
        story.getChoice(2).setChoiceStory("Go east.");
        story.getChoice(3).setChoiceStory("Go west.");
        story.getChoice(4).setChoiceStory("");
        choice2Available = true;
        choice3Available = true;;
        choice4Available = false;
      } // else
    } // else if

/* -------------------------------------------------------------------------
    BATTLE
   ------------------------------------------------------------------------- */

    else if (currentState == "BATTLE")
    {
      // Choice 1 (Attack).
      if (choiceSelected == 1)
      {
        battle.characterAttack();
        battleStory.setStory(battle.characterLine());
        battleStory.addStory("" + battle.getMonster());
        // If character/monster is still alive.
        if (battle.getStatus())
        {
          battle.monsterAttack();
          battleStory.addStory(battle.monsterLine());
          // Character dies.
          if (! battle.getStatus())
          {
            battleStory.addStory(battle.endLine());
            battleStarted = false;
          } // if
        } // if
        // Monster dies.
        else
        {
          battleStory.addStory(battle.endLine());
          endBattle();
          battleStarted = false;
          currentState = "ENDBATTLE";
        }
      } // if
    } // else if

/* -------------------------------------------------------------------------
    END BATTLE
   ------------------------------------------------------------------------- */

    else if (currentState == "ENDBATTLE")
    {
      story.setStory("You gained " + battle.getMonster().getExpYield() + " experience!");
      character.expGain(battle.getMonster().getExpYield());
      currentState = previousState;
    } // else if
  } // nextStage

/* -------------------------------------------------------------------------
    START BATTLE
   ------------------------------------------------------------------------- */

  public void startBattle()
  {
    battleStory.setStory("" + battle);
    battleStory.addStory("" + battle.getMonster());

    battleStory.getChoice(1).setChoiceStory("Attack");
    battleStory.getChoice(2).setChoiceStory("Spell");
    battleStory.getChoice(3).setChoiceStory("Item");
    battleStory.getChoice(4).setChoiceStory("Run");
    choice1Available = true;
    choice2Available = true;
    choice3Available = true;
    choice4Available = true;

    // Monster attacks first.
    if (! battle.getTurn());
    {
      battle.monsterAttack();
      battleStory.addStory(battle.monsterLine());
    } // if
  } // startBattle

/* -------------------------------------------------------------------------
    END BATTLE
   ------------------------------------------------------------------------- */

  public void endBattle()
  {
    battleStory.getChoice(1).setChoiceStory("Continue.");
    battleStory.getChoice(2).setChoiceStory("");
    battleStory.getChoice(3).setChoiceStory("");
    battleStory.getChoice(4).setChoiceStory("");
    choice1Available = true;
    choice2Available = false;
    choice3Available = false;
    choice4Available = false;
  }

/* -------------------------------------------------------------------------
    RETURN METHODS
   ------------------------------------------------------------------------- */

  // Return the story.
  public Story getStory()
  {
    return story;
  } // getStory

  // Return the battle story.
  public Story getBattleStory()
  {
    return battleStory;
  } // getBattleStory

  // Return the character.
  public Character getCharacter()
  {
    return character;
  } // getCharacter

  // Return the battle.
  public Battle getBattle()
  {
    return battle;
  } // getBattle

  // Return the status of the game.
  public boolean getGameStatus()
  {
    return gameStarted;
  } // getGameStatus

  // Return whether battle is going.
  public boolean getBattleStarted()
  {
    return battleStarted;
  } // getBattleStarted

  // Return the current stage.
  public int getCurrentStage()
  {
    return currentStage;
  } // getCurrentStage

  // Return the current state.
  public String getCurrentState()
  {
    return currentState;
  } // getCurrentState

  // Return the availability of choice.
  public Boolean getChoiceAvailable(int choiceSelected)
  {
    if (choiceSelected == 1)
      return choice1Available;
    else if (choiceSelected == 2)
      return choice2Available;
    else if (choiceSelected == 3)
      return choice3Available;
    else
      return choice4Available;
  } // getChoiceAvailable

} // class TheGame
