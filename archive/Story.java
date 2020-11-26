// The story of the game.
// It contains one main story and four choices.

public class Story
{

/* -------------------------------------------------------------------------
    PRIVATE VARIABLES
   ------------------------------------------------------------------------- */

  // The main story.
  private String story;

  // The story image.
  private InsertImage image;

  // The four choices of the story.
  private Choice choice1;
  private Choice choice2;
  private Choice choice3;
  private Choice choice4;

  // The number of choices tie to the story.
  private int numberOfChoices;

/* -------------------------------------------------------------------------
    CONSTRUCTOR
   ------------------------------------------------------------------------- */

  // Create a story without any choices.
  public Story(String requiredStory)
  {
    story = requiredStory;
    numberOfChoices = 0;
  } // Story

  // Create a story with two choices.
  public Story(String requiredStory, Choice requiredChoice1,
               Choice requiredChoice2)
  {
    story = requiredStory;
    choice1 = requiredChoice1;
    choice2 = requiredChoice2;
    numberOfChoices = 2;
  } // Story

  // Create a story with three choices.
  public Story(String requiredStory, Choice requiredChoice1,
               Choice requiredChoice2, Choice requiredChoice3)
  {
    story = requiredStory;
    choice1 = requiredChoice1;
    choice2 = requiredChoice2;
    choice3 = requiredChoice3;
    numberOfChoices = 3;
  } // Story

  // Create a story with four choices.
  public Story(String requiredStory, Choice requiredChoice1,
               Choice requiredChoice2, Choice requiredChoice3,
               Choice requiredChoice4)
  {
    story = requiredStory;
    choice1 = requiredChoice1;
    choice2 = requiredChoice2;
    choice3 = requiredChoice3;
    choice4 = requiredChoice4;
    numberOfChoices = 4;
  } // Story

/* -------------------------------------------------------------------------
    SET METHODS
   ------------------------------------------------------------------------- */

  // Change the story.
  public void setStory(String newStory)
  {
    story = newStory;
  } // setStory

  // Change the story image.
  public void setImage(String imageName)
  {
    image = new InsertImage(imageName);
    // Ratio is 17:10.
    image.setImageSize(728, 428);
  } // setImage

  // Change the choice of the story.
  public void setChoice(int choiceToChange, Choice newChoice)
  {
    if (choiceToChange == 1)
      choice1 = newChoice;
    if (choiceToChange == 2)
      choice2 = newChoice;
    if (choiceToChange == 3)
      choice3 = newChoice;
    if (choiceToChange == 4)
      choice4 = newChoice;
  } // setChoice

  // Add a new line to the story.
  public void addStory(String requiredStory)
  {
    story = story + "\n" + requiredStory;
  } // addStory

  // Add a new choice to the story.
  // Does nothing if there is already four choices to the story.
  public void addNewChoice(Choice newChoice)
  {
    if (numberOfChoices == 2)
    {
      choice3 = newChoice;
      numberOfChoices++;
    } // if
    if (numberOfChoices == 3)
    {
      choice4 = newChoice;
      numberOfChoices++;
    } // if
  } // addNewChoice

  // Remove the last choice from the story.
  // Does nothing if the number of choices tie to the story is less than 2.
  public void removeChoice()
  {
    if (numberOfChoices == 3)
    {
      choice3 = null;
      numberOfChoices--;
    } // if
    if (numberOfChoices == 4)
    {
      choice4 = null;
      numberOfChoices--;
    } // if
  } // removeChoice

/* -------------------------------------------------------------------------
    RETURN METHODS
   ------------------------------------------------------------------------- */

  // Return the story.
  public String getStory()
  {
    return story;
  } // getStory

  // Return the image.
  public InsertImage getImage()
  {
    return image;
  } // getImage

  // Return choice.
  public Choice getChoice(int choiceSelected)
  {
    if (choiceSelected == 1)
      return choice1;
    else if (choiceSelected == 2)
      return choice2;
    else if (choiceSelected == 3)
      return choice3;
    else
      return choice4;
  } // getChoice

/* -------------------------------------------------------------------------
    RETURN THE REPRESENTATION OF THE CHOICE
   ------------------------------------------------------------------------- */

  public String toString()
  {
    return "Story: " + story + "\n Choice 1: " + choice1
           + "\n Choice 2: " + choice2 + "\n Choice 3: " + choice3
           + "\n Choice 4: " + choice4;
  } // toString

} // class Story
