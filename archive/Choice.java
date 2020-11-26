// The choice of the game.

public class Choice
{

/* -------------------------------------------------------------------------
    PRIVATE VARIABLES
   ------------------------------------------------------------------------- */

  // The choice option number.
  private int choiceNumber;

  // The choice option story.
  private String choiceStory;

/* -------------------------------------------------------------------------
    CONSTRUCTOR
   ------------------------------------------------------------------------- */

  // Create a choice without option number and story.
  public Choice()
  {
  } // Choice

  // Create a choice with option number but without story.
  public Choice(int requiredNumber)
  {
    choiceNumber = requiredNumber;
  } // Choice

  // Create a choice with option story but without number.
  public Choice(String requiredStory)
  {
    choiceStory = requiredStory;
  } // Choice

  // Create a choice with option number and story.
  public Choice(int requiredNumber, String requiredStory)
  {
    choiceNumber = requiredNumber;
    choiceStory = requiredStory;
  } // Choice

  // Create a choice with option number and story.
  public Choice(String requiredStory, int requiredNumber)
  {
    choiceStory = requiredStory;
    choiceNumber = requiredNumber;
  } // Choice

/* -------------------------------------------------------------------------
    SET METHODS
   ------------------------------------------------------------------------- */

  // Set the option number of the choice.
  public void setChoiceNumber(int requiredNumber)
  {
    choiceNumber = requiredNumber;
  } // setChoiceNumber

  // Set the option story of the choice.
  public void setChoiceStory(String requiredStory)
  {
    choiceStory = requiredStory;
  } // setChoiceStory

/* -------------------------------------------------------------------------
    RETURN METHODS
   ------------------------------------------------------------------------- */

  // Return the option number of the choice.
  public int getChoiceNumber()
  {
    return choiceNumber;
  } // getChoiceNumber

  // Return the option story of the choice.
  public String getChoiceStory()
  {
    return choiceStory;
  } // getChoiceStory

/* -------------------------------------------------------------------------
    RETURN THE REPRESENTATION OF THE CHOICE
   ------------------------------------------------------------------------- */

  public String toString()
  {
    return choiceStory;
  } // toString

} // Choice
