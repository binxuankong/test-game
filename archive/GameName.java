import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameName extends JFrame implements ActionListener
{

/* -------------------------------------------------------------------------
    PRIVATE VARIABLES
   ------------------------------------------------------------------------- */

  // The game.
  private static GameName gameName;

  // JTextField for the name of character.
  private final JTextField characterNameJTextField = new JTextField(25);

  // Image for the story.
  private InsertImage loadingImage = new InsertImage("loading.png");
  private JLabel storyImage;

  // JTextArea for the story.
  private final JTextArea storyJTextArea = new JTextArea(6, 60);

  // JPanel for the story image.
  private JPanel imageJPanel = new JPanel();

  // JTextArea for the character's inventory.
  private final JTextArea characterInventoryJTextArea = new JTextArea(32, 16);

  // JTextFields for the choices.
  private final JTextField choice1JTextField = new JTextField(88);
  private final JTextField choice2JTextField = new JTextField(88);
  private final JTextField choice3JTextField = new JTextField(88);
  private final JTextField choice4JTextField = new JTextField(88);

  // JButtons for start, restart, new game, save and load and exit.
  private final JButton startJButton = new JButton("Start");
  private final JButton restartJButton = new JButton("Restart");
  private final JButton newGameJButton = new JButton("New Game");
  private final JButton saveJButton = new JButton("Save Game");
  private final JButton loadJButton = new JButton("Load Game");
  private final JButton exitJButton = new JButton("Exit");

  // JButtons for the choices.
  private final JButton choice1JButton = new JButton("");
  private final JButton choice2JButton = new JButton("");
  private final JButton choice3JButton = new JButton("");
  private final JButton choice4JButton = new JButton("");

  // JLabels for the character's stats.
  private final JLabel characterStatsLabelJLabel = new JLabel("Character's Stats");
  private final JLabel characterHeading1LabelJLabel = new JLabel("~~~~~~~~~~~~~~~");
  private final JLabel characterHeading2LabelJLabel = new JLabel("~~~~~~~~~~~~~~~");
  private final JLabel characterHeading3LabelJLabel = new JLabel("~~~~~~~~~~~~~~~");
  private final JLabel characterNameLabelJLabel = new JLabel("Name");
  private final JLabel characterLevelLabelJLabel = new JLabel("Level");
  private final JLabel characterExperienceLabelJLabel = new JLabel("Experience");
  private final JLabel characterHealthLabelJLabel = new JLabel("Health");
  private final JLabel characterMiraclesLabelJLabel = new JLabel("Miracles");
  private final JLabel characterDamageLabelJLabel = new JLabel("Damage");
  private final JLabel characterWillLabelJLabel = new JLabel("Will");
  private final JLabel characterFocusLabelJLabel = new JLabel("Focus");
  private final JLabel characterConfidenceLabelJLabel = new JLabel("Confidence");
  private final JLabel characterConfusionLabelJLabel = new JLabel("Confusion");
  private final JLabel characterDoubtLabelJLabel = new JLabel("Doubt");
  private final JLabel characterDespairLabelJLabel = new JLabel("Despair");
  private final JLabel characterHeading1DataJLabel = new JLabel("~~~~~~~~~~~~~~~~~~~");
  private final JLabel characterHeading2DataJLabel = new JLabel("~~~~~~~~~~~~~~~~~~~");
  private final JLabel characterHeading3DataJLabel = new JLabel("~~~~~~~~~~~~~~~~~~~");
  private final JLabel characterNameDataJLabel = new JLabel();
  private final JLabel characterLevelDataJLabel = new JLabel();
  private final JLabel characterExperienceDataJLabel = new JLabel();
  private final JLabel characterHealthDataJLabel = new JLabel();
  private final JLabel characterMiraclesDataJLabel = new JLabel();
  private final JLabel characterDamageDataJLabel = new JLabel();
  private final JLabel characterWillDataJLabel = new JLabel();
  private final JLabel characterFocusDataJLabel = new JLabel();
  private final JLabel characterConfidenceDataJLabel = new JLabel();
  private final JLabel characterConfusionDataJLabel = new JLabel();
  private final JLabel characterDoubtDataJLabel = new JLabel();
  private final JLabel characterDespairDataJLabel = new JLabel();

  // JLabels for the character's equipment.
  private final JLabel characterHeadJLabel = new JLabel();
  private final JLabel characterNeckJLabel = new JLabel();
  private final JLabel characterRightHandJLabel = new JLabel();
  private final JLabel characterLeftHandJLabel = new JLabel();
  private final JLabel characterHandsJLabel = new JLabel();
  private final JLabel characterBodyJLabel = new JLabel();
  private final JLabel characterLegJLabel = new JLabel();
  private final JLabel characterBackJLabel = new JLabel();
  private final JLabel characterFeetJLabel = new JLabel();
  private final JLabel characterRing1JLabel = new JLabel();
  private final JLabel characterRing2JLabel = new JLabel();

  // Determine whether the game is started or not.
  private boolean gameStarted = false;
  private TheGame theGame;

  // The character of the game.
  private Character character;

  // Determine whether the battle has started.
  private boolean battleStarted = false;

/* -------------------------------------------------------------------------
    CONSTRUCTOR
   ------------------------------------------------------------------------- */

  public GameName()
  {
    setTitle("The Game Name");

    Container contents = getContentPane();
    contents.setLayout(new BorderLayout());

/* -------------------------------------------------------------------------
    JPANELS FOR THE MAIN GRID
   ------------------------------------------------------------------------- */

    // A JPanel for the top part of the main grid with a FlowLayout.
    // This is for the character name, start and stop button.
    JPanel topPartJPanel = new JPanel();
    contents.add(topPartJPanel, BorderLayout.NORTH);
    topPartJPanel.setLayout(new FlowLayout());

    // A JPanel for the middle center part of the main grid with a BorderLayout.
    // This is for the story page.
    JPanel middlePartJPanel = new JPanel();
    contents.add(middlePartJPanel, BorderLayout.CENTER);
    middlePartJPanel.setLayout(new BorderLayout());

    // A JPanel for the middle left part of the main grid with a BorderLayout.
    // This is for the character's inventory.
    JPanel leftPartJPanel = new JPanel();
    contents.add(leftPartJPanel, BorderLayout.WEST);
    leftPartJPanel.setLayout(new BorderLayout());

    // A JPanel for the middle right part of the main grid with a GridLayout.
    // This is for the character's stats and equipments.
    JPanel rightPartJPanel = new JPanel();
    contents.add(rightPartJPanel, BorderLayout.EAST);
    rightPartJPanel.setLayout(new GridLayout(2, 1));

    // A JPanel for the bottom part of the main grid.
    // This will have a layout of 4 by 1.
    // This is for the choices.
    JPanel bottomPartJPanel = new JPanel();
    contents.add(bottomPartJPanel, BorderLayout.SOUTH);
    bottomPartJPanel.setLayout(new GridLayout(4, 1));

/* -------------------------------------------------------------------------
    TOP PART OF THE MAIN GRID
   ------------------------------------------------------------------------- */

    // Insert image of logo.
    InsertImage gameLogo = new InsertImage("logo.png");
    gameLogo.setImageSize(50, 50);
    topPartJPanel.add(gameLogo.getImage());

    // One label, one text fields and two buttons for the top JPanel.
    // This is for the character name.
    JLabel characterNameTitleJLabel = new JLabel("Character Name: ");
    topPartJPanel.add(characterNameTitleJLabel);
    topPartJPanel.add(characterNameJTextField);

    // This is for the start and restart button.
    topPartJPanel.add(startJButton);
    startJButton.addActionListener(this);
    topPartJPanel.add(restartJButton);
    restartJButton.addActionListener(this);
    restartJButton.setEnabled(false);
    topPartJPanel.add(newGameJButton);
    newGameJButton.addActionListener(this);
    newGameJButton.setEnabled(false);
    topPartJPanel.add(saveJButton);
    saveJButton.addActionListener(this);
    saveJButton.setEnabled(false);
    topPartJPanel.add(loadJButton);
    loadJButton.addActionListener(this);
    topPartJPanel.add(exitJButton);
    exitJButton.addActionListener(this);

/* -------------------------------------------------------------------------
    MIDDLE CENTER PART OF THE MAIN GRID
   ------------------------------------------------------------------------- */

    // One image and text area for the middle JPanel.
    // This is for the story.
    middlePartJPanel.add(imageJPanel, BorderLayout.CENTER);
    loadingImage.setImageSize(728, 428);
    storyImage = loadingImage.getImage();
    imageJPanel.add(storyImage);
    middlePartJPanel.add(new JScrollPane(storyJTextArea), BorderLayout.SOUTH);
    storyJTextArea.setText("Create your character and start your adventure!");
    storyJTextArea.setEditable(false);

/* -------------------------------------------------------------------------
    MIDDLE LEFT PART OF THE MAIN GRID
   ------------------------------------------------------------------------- */

    // A JLabel for the label of character inventory.
    JLabel characterInventoryJLabel = new JLabel("   Inventory");
    leftPartJPanel.add(characterInventoryJLabel, BorderLayout.NORTH);

    // A JTextArea for the character inventory.
    leftPartJPanel.add(new JScrollPane(characterInventoryJTextArea),
                       BorderLayout.CENTER);
    characterInventoryJTextArea.setEditable(false);
    characterInventoryJTextArea.setText("");

/* -------------------------------------------------------------------------
    MIDDLE RIGHT PART OF THE MAIN GRID
   ------------------------------------------------------------------------- */

    // A JPanel for the character stats.
    JPanel characterStatsJPanel = new JPanel();
    rightPartJPanel.add(characterStatsJPanel);
    characterStatsJPanel.setLayout(new FlowLayout());

    // A JPanel for the character stats label.
    JPanel characterStatsLabelJPanel = new JPanel();
    characterStatsJPanel.add(characterStatsLabelJPanel);
    characterStatsLabelJPanel.setLayout(new GridLayout(0, 1));

    // A JPanel for the character stats data.
    JPanel characterStatsDataJPanel = new JPanel();
    characterStatsJPanel.add(characterStatsDataJPanel);
    characterStatsDataJPanel.setLayout(new GridLayout(0, 1));

    // A JPanel for the character equipment.
    JPanel characterEquipmentJPanel = new JPanel();
    rightPartJPanel.add(characterEquipmentJPanel);
    characterEquipmentJPanel.setLayout(new FlowLayout());

    // A JPanel for the character equipment label.
    JPanel characterEquipmentLabelJPanel = new JPanel();
    characterEquipmentJPanel.add(characterEquipmentLabelJPanel);
    characterEquipmentLabelJPanel.setLayout(new GridLayout(0, 1));

    // A JPanel for the character equipment data.
    JPanel characterEquipmentDataJPanel = new JPanel();
    characterEquipmentJPanel.add(characterEquipmentDataJPanel);
    characterEquipmentDataJPanel.setLayout(new GridLayout(0, 1));

/* -------------------------------------------------------------------------
    CHARACTER STATS
   ------------------------------------------------------------------------- */

    // JLabels for the character stats label.
    characterStatsLabelJPanel.add(characterHeading1LabelJLabel);
    characterStatsLabelJPanel.add(characterStatsLabelJLabel);
    characterStatsLabelJPanel.add(characterHeading2LabelJLabel);
    characterStatsLabelJPanel.add(characterNameLabelJLabel);
    characterStatsLabelJPanel.add(characterLevelLabelJLabel);
    characterStatsLabelJPanel.add(characterExperienceLabelJLabel);
    characterStatsLabelJPanel.add(characterHealthLabelJLabel);
    characterStatsLabelJPanel.add(characterMiraclesLabelJLabel);
    characterStatsLabelJPanel.add(characterDamageLabelJLabel);
    characterStatsLabelJPanel.add(characterWillLabelJLabel);
    characterStatsLabelJPanel.add(characterFocusLabelJLabel);
    characterStatsLabelJPanel.add(characterConfidenceLabelJLabel);
    characterStatsLabelJPanel.add(characterConfusionLabelJLabel);
    characterStatsLabelJPanel.add(characterDoubtLabelJLabel);
    characterStatsLabelJPanel.add(characterDespairLabelJLabel);
    characterStatsLabelJPanel.add(characterHeading3LabelJLabel);

    // JLabel for the character stats data.
    characterStatsDataJPanel.add(characterHeading1DataJLabel);
    characterStatsDataJPanel.add(new JLabel());
    characterStatsDataJPanel.add(characterHeading2DataJLabel);
    characterStatsDataJPanel.add(characterNameDataJLabel);
    characterStatsDataJPanel.add(characterLevelDataJLabel);
    characterStatsDataJPanel.add(characterExperienceDataJLabel);
    characterStatsDataJPanel.add(characterHealthDataJLabel);
    characterStatsDataJPanel.add(characterMiraclesDataJLabel);
    characterStatsDataJPanel.add(characterDamageDataJLabel);
    characterStatsDataJPanel.add(characterWillDataJLabel);
    characterStatsDataJPanel.add(characterFocusDataJLabel);
    characterStatsDataJPanel.add(characterConfidenceDataJLabel);
    characterStatsDataJPanel.add(characterConfusionDataJLabel);
    characterStatsDataJPanel.add(characterDoubtDataJLabel);
    characterStatsDataJPanel.add(characterDespairDataJLabel);
    characterStatsDataJPanel.add(characterHeading3DataJLabel);

/* -------------------------------------------------------------------------
    CHARACTER EQUIPMENT
   ------------------------------------------------------------------------- */

    // JLabels for the character equipment label.
    characterEquipmentLabelJPanel.add(new JLabel("-----------"));
    characterEquipmentLabelJPanel.add(new JLabel("Equipment"));
    characterEquipmentLabelJPanel.add(new JLabel("-----------"));
    characterEquipmentLabelJPanel.add(new JLabel("Head"));
    characterEquipmentLabelJPanel.add(new JLabel("Neck"));
    characterEquipmentLabelJPanel.add(new JLabel("Right Hand"));
    characterEquipmentLabelJPanel.add(new JLabel("Left Hand"));
    characterEquipmentLabelJPanel.add(new JLabel("Hands"));
    characterEquipmentLabelJPanel.add(new JLabel("Body"));
    characterEquipmentLabelJPanel.add(new JLabel("Leg"));
    characterEquipmentLabelJPanel.add(new JLabel("Back"));
    characterEquipmentLabelJPanel.add(new JLabel("Feet"));
    characterEquipmentLabelJPanel.add(new JLabel("Ring 1"));
    characterEquipmentLabelJPanel.add(new JLabel("Ring 2"));
    characterEquipmentLabelJPanel.add(new JLabel("-----------"));

    // JLabel for the character equipment data.
    characterEquipmentDataJPanel.add(new JLabel("-----------------------"));
    characterEquipmentDataJPanel.add(new JLabel());
    characterEquipmentDataJPanel.add(new JLabel("-----------------------"));
    characterEquipmentDataJPanel.add(characterHeadJLabel);
    characterEquipmentDataJPanel.add(characterNeckJLabel);
    characterEquipmentDataJPanel.add(characterRightHandJLabel);
    characterEquipmentDataJPanel.add(characterLeftHandJLabel);
    characterEquipmentDataJPanel.add(characterHandsJLabel);
    characterEquipmentDataJPanel.add(characterBodyJLabel);
    characterEquipmentDataJPanel.add(characterLegJLabel);
    characterEquipmentDataJPanel.add(characterBackJLabel);
    characterEquipmentDataJPanel.add(characterFeetJLabel);
    characterEquipmentDataJPanel.add(characterRing1JLabel);
    characterEquipmentDataJPanel.add(characterRing2JLabel);
    characterEquipmentDataJPanel.add(new JLabel("-----------------------"));

/* -------------------------------------------------------------------------
    BOTTOM PART OF THE MAIN GRID
   ------------------------------------------------------------------------- */

    // One JPanel for each choices, with a FlowLayout.
    // It consists of a button and a text field.
    JPanel choice1JPanel = new JPanel();
    bottomPartJPanel.add(choice1JPanel);
    choice1JPanel.setLayout(new FlowLayout());
    JPanel choice2JPanel = new JPanel();
    bottomPartJPanel.add(choice2JPanel);
    choice2JPanel.setLayout(new FlowLayout());
    JPanel choice3JPanel = new JPanel();
    bottomPartJPanel.add(choice3JPanel);
    choice3JPanel.setLayout(new FlowLayout());
    JPanel choice4JPanel = new JPanel();
    bottomPartJPanel.add(choice4JPanel);
    choice4JPanel.setLayout(new FlowLayout());

/* -------------------------------------------------------------------------
    JPANEL FOR CHOICES
   ------------------------------------------------------------------------- */

    choice1JPanel.add(choice1JButton);
    choice1JButton.addActionListener(this);
    choice1JButton.setEnabled(false);
    choice1JPanel.add(choice1JTextField);
    choice1JTextField.setEditable(false);
    choice2JPanel.add(choice2JButton);
    choice2JButton.addActionListener(this);
    choice2JButton.setEnabled(false);
    choice2JPanel.add(choice2JTextField);
    choice2JTextField.setEditable(false);
    choice3JPanel.add(choice3JButton);
    choice3JButton.addActionListener(this);
    choice3JButton.setEnabled(false);
    choice3JPanel.add(choice3JTextField);
    choice3JTextField.setEditable(false);
    choice4JPanel.add(choice4JButton);
    choice4JButton.addActionListener(this);
    choice4JButton.setEnabled(false);
    choice4JPanel.add(choice4JTextField);
    choice4JTextField.setEditable(false);

/* -------------------------------------------------------------------------
    COLOURS
   ------------------------------------------------------------------------- */

    // Main parts.
    topPartJPanel.setBackground(Color.black);
    middlePartJPanel.setBackground(Color.black);
    imageJPanel.setBackground(Color.black);
    leftPartJPanel.setBackground(Color.black);
    rightPartJPanel.setBackground(Color.black);
    bottomPartJPanel.setBackground(Color.black);

    // Body part.
    characterNameTitleJLabel.setForeground(Color.white);
    storyJTextArea.setBackground(Color.white);
    characterInventoryJLabel.setForeground(Color.white);
    characterInventoryJTextArea.setBackground(Color.lightGray);

    // Character stats.
    characterStatsJPanel.setBackground(Color.black);
    characterStatsLabelJPanel.setBackground(Color.black);
    characterStatsDataJPanel.setBackground(Color.black);

    // Character stats label.
    characterStatsLabelJLabel.setForeground(Color.white);
    characterHeading1LabelJLabel.setForeground(Color.white);
    characterHeading2LabelJLabel.setForeground(Color.white);
    characterHeading3LabelJLabel.setForeground(Color.white);
    characterNameLabelJLabel.setForeground(Color.white);
    characterLevelLabelJLabel.setForeground(Color.white);
    characterExperienceLabelJLabel.setForeground(Color.white);
    characterHealthLabelJLabel.setForeground(Color.white);
    characterMiraclesLabelJLabel.setForeground(Color.white);
    characterDamageLabelJLabel.setForeground(Color.white);
    characterWillLabelJLabel.setForeground(Color.white);
    characterFocusLabelJLabel.setForeground(Color.white);
    characterConfidenceLabelJLabel.setForeground(Color.white);
    characterConfusionLabelJLabel.setForeground(Color.white);
    characterDoubtLabelJLabel.setForeground(Color.white);
    characterDespairLabelJLabel.setForeground(Color.white);

    // Character stats data.
    characterHeading1DataJLabel.setForeground(Color.white);
    characterHeading2DataJLabel.setForeground(Color.white);
    characterHeading3DataJLabel.setForeground(Color.white);
    characterNameDataJLabel.setForeground(Color.lightGray);
    characterLevelDataJLabel.setForeground(Color.lightGray);
    characterExperienceDataJLabel.setForeground(Color.lightGray);
    characterHealthDataJLabel.setForeground(Color.lightGray);
    characterMiraclesDataJLabel.setForeground(Color.lightGray);
    characterDamageDataJLabel.setForeground(Color.lightGray);
    characterWillDataJLabel.setForeground(Color.lightGray);
    characterFocusDataJLabel.setForeground(Color.lightGray);
    characterConfidenceDataJLabel.setForeground(Color.lightGray);
    characterConfusionDataJLabel.setForeground(Color.lightGray);
    characterDoubtDataJLabel.setForeground(Color.lightGray);
    characterDespairDataJLabel.setForeground(Color.lightGray);

    // Character equipment.
    characterEquipmentJPanel.setBackground(Color.lightGray);
    characterEquipmentLabelJPanel.setBackground(Color.lightGray);
    characterEquipmentDataJPanel.setBackground(Color.lightGray);
    characterHeadJLabel.setForeground(Color.blue);
    characterNeckJLabel.setForeground(Color.blue);
    characterRightHandJLabel.setForeground(Color.blue);
    characterLeftHandJLabel.setForeground(Color.blue);
    characterHandsJLabel.setForeground(Color.blue);
    characterBodyJLabel.setForeground(Color.blue);
    characterLegJLabel.setForeground(Color.blue);
    characterBackJLabel.setForeground(Color.blue);
    characterFeetJLabel.setForeground(Color.blue);
    characterRing1JLabel.setForeground(Color.blue);
    characterRing2JLabel.setForeground(Color.blue);

    // Choices.
    choice1JPanel.setBackground(Color.black);
    choice1JTextField.setBackground(Color.white);
    choice2JPanel.setBackground(Color.black);
    choice2JTextField.setBackground(Color.white);
    choice3JPanel.setBackground(Color.black);
    choice3JTextField.setBackground(Color.white);
    choice4JPanel.setBackground(Color.black);
    choice4JTextField.setBackground(Color.white);
    
/* -------------------------------------------------------------------------
    END OF THE CODE
   ------------------------------------------------------------------------- */

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  } // gameName

/* -------------------------------------------------------------------------
    ACTIONS FOR THE BUTTONS
   ------------------------------------------------------------------------- */

  public void actionPerformed(ActionEvent event)
  {
    // Start button
    if (event.getSource() == startJButton)
    {
      if (characterNameJTextField.getText().equals("")
          || characterNameJTextField.getText().equals(" ")
          || characterNameJTextField.getText().equals("  ")
          || characterNameJTextField.getText().equals("   ")
          || characterNameJTextField.getText().equals("    ")
          || characterNameJTextField.getText().equals("     "))
      {
        storyJTextArea.setText("Please insert your character's name.");
      } // if
      else
      {
        startGame();
      } // else
    } // if

    // restart Button
    else if (event.getSource() == restartJButton)
    {
      gameStarted = false;
      startGame();
    } // else if

    // New Game Button
    else if (event.getSource() == newGameJButton)
    {
      newGame();
    } // else if

    // Choice 1
    else if (event.getSource() == choice1JButton)
    {
      // Battle started already.
      if (battleStarted)
      {
        battle(1);
        refresh();
      } // if
      // Start the battle
      else if (theGame.getBattleStarted())
      {
        startBattle();
        refresh();
      } // else if
      else
      {
        choiceSelect(1);
      } // else
    } // else if

    // Choice 2
    else if (event.getSource() == choice2JButton)
    {
      // Battle started already.
      if (battleStarted)
      {
        battle(2);
        refresh();
      } // if
      // Start the battle
      else if (theGame.getBattleStarted())
      {
        startBattle();
        refresh();
      } // else if
      else
      {
        choiceSelect(2);
      } // else
    } // else if

    // Choice 3
    else if (event.getSource() == choice3JButton)
    {
      // Battle started already.
      if (battleStarted)
      {
        battle(3);
        refresh();
      } // if
      // Start the battle
      else if (theGame.getBattleStarted())
      {
        startBattle();
        refresh();
      } // else if
      else
      {
        choiceSelect(3);
      } // else
    } // else if

    // Choice 4
    else if (event.getSource() == choice4JButton)
    {
      // Battle started already.
      if (battleStarted)
      {
        battle(4);
        refresh();
      } // if
      // Start the battle
      else if (theGame.getBattleStarted())
      {
        startBattle();
        refresh();
      } // else if
      else
      {
        choiceSelect(4);
      } // else
    } // else if

    // Save Button
    else if (event.getSource() == saveJButton)
    {
      saveGame();
    } // else if

    // Load Button
    else if (event.getSource() == loadJButton)
    {
      loadGame();
    } // else if

    // Exit Button
    else if (event.getSource() == exitJButton)
    {
      System.exit(0);
    } // else if

  } // actionPerformed

/* -------------------------------------------------------------------------
    START GAME
   ------------------------------------------------------------------------- */

  public void startGame()
  {
    // Set booleans.
    gameStarted = true;
    startJButton.setEnabled(false);
    restartJButton.setEnabled(true);
    newGameJButton.setEnabled(true);
    saveJButton.setEnabled(true);
    loadJButton.setEnabled(false);
    choice1JButton.setEnabled(true);
    choice2JButton.setEnabled(true);
    choice3JButton.setEnabled(true);
    choice4JButton.setEnabled(true);

    // Create the character.
    String characterName = characterNameJTextField.getText();
    character = new Character(characterName);
    characterNameJTextField.setEnabled(false);
    characterNameDataJLabel.setText(character.getName());

    // Create the game.
    theGame = new TheGame(character);
    theGame.startGame();

    // Display the character's stats.
    characterLevelDataJLabel.setText("" + character.getLevel());
    characterExperienceDataJLabel.setText(character.getCurrentEXP() + "/"
                                      + character.getMaxEXP());
    characterHealthDataJLabel.setText(character.getCurrentHealth() + "/"
                              + character.getMaxHealth());
    characterMiraclesDataJLabel.setText(character.getCurrentMiracles() + "/"
                              + character.getMaxMiracles());
    characterDamageDataJLabel.setText("" + character.getDamage());
    characterWillDataJLabel.setText("" + character.getWill());
    characterFocusDataJLabel.setText("" + character.getFocus());
    characterConfidenceDataJLabel.setText("" + character.getConfidence());
    characterConfusionDataJLabel.setText("" + character.getConfusion());
    characterDoubtDataJLabel.setText("" + character.getDoubt());
    characterDespairDataJLabel.setText("" + character.getDespair());

    // Display the character's equipment.
    characterHeadJLabel.setText("" + character.getEquipment().getHead());
    characterNeckJLabel.setText("" + character.getEquipment().getNeck());
    characterRightHandJLabel.setText("" + character.getEquipment().getRightHand());
    characterLeftHandJLabel.setText("" + character.getEquipment().getLeftHand());
    characterHandsJLabel.setText("" + character.getEquipment().getHands());
    characterBodyJLabel.setText("" + character.getEquipment().getBody());
    characterLegJLabel.setText("" + character.getEquipment().getLeg());
    characterBackJLabel.setText("" + character.getEquipment().getBack());
    characterFeetJLabel.setText("" + character.getEquipment().getFeet());
    characterRing1JLabel.setText("" + character.getEquipment().getRing1());
    characterRing2JLabel.setText("" + character.getEquipment().getRing2());

    // Display the character's inventory.
    characterInventoryJTextArea.setText("");
    for (int index = 0; index < character.getNoOfItems(); index++)
      characterInventoryJTextArea.append("" + character.getInventory(index) + "\n");

    // Set the story and choices.
    storyJTextArea.setText("");
    setStory(storyJTextArea);
    imageJPanel.remove(storyImage);
    storyImage = theGame.getStory().getImage().getImage();
    imageJPanel.add(storyImage);
  } // startGame

/* -------------------------------------------------------------------------
    NEW GAME
   ------------------------------------------------------------------------- */

  public void newGame()
  {
    gameStarted = false;
    startJButton.setEnabled(true);
    restartJButton.setEnabled(false);
    newGameJButton.setEnabled(false);
    saveJButton.setEnabled(false);
    loadJButton.setEnabled(true);
    choice1JButton.setEnabled(false);
    choice2JButton.setEnabled(false);
    choice3JButton.setEnabled(false);
    choice4JButton.setEnabled(false);
      
    // Reset character.
    character.characterReset();
    characterNameJTextField.setText("");
    characterNameJTextField.setEnabled(true);
    characterNameDataJLabel.setText("");

    // Reset the character's stats.
    characterLevelDataJLabel.setText("");
    characterExperienceDataJLabel.setText("");
    characterHealthDataJLabel.setText("");
    characterMiraclesDataJLabel.setText("");
    characterDamageDataJLabel.setText("");
    characterWillDataJLabel.setText("");
    characterFocusDataJLabel.setText("");
    characterConfidenceDataJLabel.setText("");
    characterConfusionDataJLabel.setText("");
    characterDoubtDataJLabel.setText("");
    characterDespairDataJLabel.setText("");

    // Reset the character's equipment.
    characterHeadJLabel.setText("");
    characterNeckJLabel.setText("");
    characterRightHandJLabel.setText("");
    characterLeftHandJLabel.setText("");
    characterHandsJLabel.setText("");
    characterBodyJLabel.setText("");
    characterLegJLabel.setText("");
    characterBackJLabel.setText("");
    characterFeetJLabel.setText("");
    characterRing1JLabel.setText("");
    characterRing2JLabel.setText("");

    // Reset the character's inventory.
    characterInventoryJTextArea.setText("");

    // Reset the story and choices.
    storyJTextArea.setText("Create your character and start your adventure.");
    imageJPanel.remove(storyImage);
    storyImage = loadingImage.getImage();
    imageJPanel.add(storyImage);
    choice1JTextField.setText("");
    choice2JTextField.setText("");
    choice3JTextField.setText("");
    choice4JTextField.setText("");
  } // newGame

/* -------------------------------------------------------------------------
    CHOICE SELECTED
   ------------------------------------------------------------------------- */

  public void choiceSelect(int choiceSelected)
  {
    theGame.nextStage(choiceSelected);

    // Set the story and choices.
    imageJPanel.remove(storyImage);
    storyImage = theGame.getStory().getImage().getImage();
    imageJPanel.add(storyImage);
    setStory(storyJTextArea);

    // If the game ended.
    if (!theGame.getGameStatus())
    {
      storyJTextArea.append("\nYou died!\nRestart or create a new character to start again.");

      gameStarted = false;
      saveJButton.setEnabled(false);
      loadJButton.setEnabled(true);
      choice1JButton.setEnabled(false);
      choice2JButton.setEnabled(false);
      choice3JButton.setEnabled(false);
      choice4JButton.setEnabled(false);
    } // if
  } // choiceSelect

/* -------------------------------------------------------------------------
    START BATTLE
   ------------------------------------------------------------------------- */

  public void startBattle()
  {
    // Display the monster on the JTextArea.
    theGame.nextStage(1);
    storyJTextArea.setText(theGame.getBattleStory().getStory());
    imageJPanel.remove(storyImage);
    storyImage = loadingImage.getImage();
    imageJPanel.add(storyImage);
    battleStarted = true;
    if (! theGame.getBattle().getTurn());
      refreshStats();
  } // startBattle

/* -------------------------------------------------------------------------
    BATTLE
   ------------------------------------------------------------------------- */

  public void battle(int requiredChoice)
  {
    theGame.nextStage(requiredChoice);
    storyJTextArea.append("\n" + theGame.getBattleStory().getStory());
    battleStarted = theGame.getBattleStarted();

    // If the game ended.
    if (!theGame.getGameStatus())
    {
      storyJTextArea.append("\nYou died!\nRestart or create a new character to start again.");

      gameStarted = false;
      saveJButton.setEnabled(false);
      loadJButton.setEnabled(true);
      choice1JButton.setEnabled(false);
      choice2JButton.setEnabled(false);
      choice3JButton.setEnabled(false);
      choice4JButton.setEnabled(false);
    } // if
  } // battle

/* -------------------------------------------------------------------------
    REFRESH THE CHARACTER'S STAT
   ------------------------------------------------------------------------- */

  public void refreshStats()
  {
    characterLevelDataJLabel.setText("" + character.getLevel());
    characterExperienceDataJLabel.setText(character.getCurrentEXP() + "/"
                                      + character.getMaxEXP());
    characterHealthDataJLabel.setText(character.getCurrentHealth() + "/"
                              + character.getMaxHealth());
    characterMiraclesDataJLabel.setText(character.getCurrentMiracles() + "/"
                              + character.getMaxMiracles());
    characterDamageDataJLabel.setText("" + character.getDamage());
    characterWillDataJLabel.setText("" + character.getWill());
    characterFocusDataJLabel.setText("" + character.getFocus());
    characterConfidenceDataJLabel.setText("" + character.getConfidence());
    characterConfusionDataJLabel.setText("" + character.getConfusion());
    characterDoubtDataJLabel.setText("" + character.getDoubt());
    characterDespairDataJLabel.setText("" + character.getDespair());
  } // refreshStats

/* -------------------------------------------------------------------------
    REFRESH THE CHARACTER'S EQUIPMENT
   ------------------------------------------------------------------------- */

  public void refreshEquipment()
  {
    characterHeadJLabel.setText("" + character.getEquipment().getHead());
    characterNeckJLabel.setText("" + character.getEquipment().getNeck());
    characterRightHandJLabel.setText("" + character.getEquipment().getRightHand());
    characterLeftHandJLabel.setText("" + character.getEquipment().getLeftHand());
    characterHandsJLabel.setText("" + character.getEquipment().getHands());
    characterBodyJLabel.setText("" + character.getEquipment().getBody());
    characterLegJLabel.setText("" + character.getEquipment().getLeg());
    characterBackJLabel.setText("" + character.getEquipment().getBack());
    characterFeetJLabel.setText("" + character.getEquipment().getFeet());
    characterRing1JLabel.setText("" + character.getEquipment().getRing1());
    characterRing2JLabel.setText("" + character.getEquipment().getRing2());

    // Refresh the character's inventory.
    characterInventoryJTextArea.setText("");
    for (int index = 0; index < character.getNoOfItems(); index++)
      characterInventoryJTextArea.append("" + character.getInventory(index) + "\n");
  } // refreshEquipment

/* -------------------------------------------------------------------------
    REFRESH THE JBUTTONS
   ------------------------------------------------------------------------- */

  public void refreshButtons()
  {
    // Set buttons to the battle mode.
    if (theGame.getBattleStarted())
    {
      // Rename the choices.
      choice1JTextField.setText(theGame.getBattleStory().getChoice(1).getChoiceStory());
      choice2JTextField.setText(theGame.getBattleStory().getChoice(2).getChoiceStory());
      choice3JTextField.setText(theGame.getBattleStory().getChoice(3).getChoiceStory());
      choice4JTextField.setText(theGame.getBattleStory().getChoice(4).getChoiceStory());

      // Set choice buttons availability.
      choice1JButton.setEnabled(theGame.getChoiceAvailable(1));
      choice2JButton.setEnabled(theGame.getChoiceAvailable(2));
      choice3JButton.setEnabled(theGame.getChoiceAvailable(3));
      choice4JButton.setEnabled(theGame.getChoiceAvailable(4));
    } // if
    // Set buttons to normal mode.
    else
    {
      // Rename the choices.
      choice1JTextField.setText(theGame.getStory().getChoice(1).getChoiceStory());
      choice2JTextField.setText(theGame.getStory().getChoice(2).getChoiceStory());
      choice3JTextField.setText(theGame.getStory().getChoice(3).getChoiceStory());
      choice4JTextField.setText(theGame.getStory().getChoice(4).getChoiceStory());

      // Set choice buttons availability.
      choice1JButton.setEnabled(theGame.getChoiceAvailable(1));
      choice2JButton.setEnabled(theGame.getChoiceAvailable(2));
      choice3JButton.setEnabled(theGame.getChoiceAvailable(3));
      choice4JButton.setEnabled(theGame.getChoiceAvailable(4));
    } // else 
  } // refreshButtons

/* -------------------------------------------------------------------------
    REFRESH PAGE
   ------------------------------------------------------------------------- */

  public void refresh()
  {
    refreshStats();
    refreshEquipment();
    refreshButtons();
  } // refresh

/* -------------------------------------------------------------------------
    SAVE THE GAME
   ------------------------------------------------------------------------- */

  public void saveGame()
  {
    SaveGame saveGame = new SaveGame(theGame);
    saveGame.saveGame();
  } // saveGame

/* -------------------------------------------------------------------------
    LOAD GAME
   ------------------------------------------------------------------------- */

  public void loadGame()
  {
    LoadGame loadGame = new LoadGame();
    loadGame.loadGame();

    // Set booleans.
    gameStarted = true;
    startJButton.setEnabled(false);
    restartJButton.setEnabled(true);
    saveJButton.setEnabled(true);
    loadJButton.setEnabled(false);

    // Create the character.
    character = loadGame.getCharacter();
    characterNameJTextField.setEnabled(false);
    characterNameJTextField.setText(character.getName());
    characterNameDataJLabel.setText(character.getName());

    // Create the game.
    theGame = loadGame.getGame();

    // Display the character's stats.
    characterLevelDataJLabel.setText("" + character.getLevel());
    characterExperienceDataJLabel.setText(character.getCurrentEXP() + "/"
                                      + character.getMaxEXP());
    characterHealthDataJLabel.setText(character.getCurrentHealth() + "/"
                              + character.getMaxHealth());
    characterMiraclesDataJLabel.setText(character.getCurrentMiracles() + "/"
                              + character.getMaxMiracles());
    characterDamageDataJLabel.setText("" + character.getDamage());
    characterWillDataJLabel.setText("" + character.getWill());
    characterFocusDataJLabel.setText("" + character.getFocus());
    characterConfidenceDataJLabel.setText("" + character.getConfidence());
    characterConfusionDataJLabel.setText("" + character.getConfusion());
    characterDoubtDataJLabel.setText("" + character.getDoubt());
    characterDespairDataJLabel.setText("" + character.getDespair());

    // Display the character's equipment.
    characterHeadJLabel.setText("" + character.getEquipment().getHead());
    characterNeckJLabel.setText("" + character.getEquipment().getNeck());
    characterRightHandJLabel.setText("" + character.getEquipment().getRightHand());
    characterLeftHandJLabel.setText("" + character.getEquipment().getLeftHand());
    characterHandsJLabel.setText("" + character.getEquipment().getHands());
    characterBodyJLabel.setText("" + character.getEquipment().getBody());
    characterLegJLabel.setText("" + character.getEquipment().getLeg());
    characterBackJLabel.setText("" + character.getEquipment().getBack());
    characterFeetJLabel.setText("" + character.getEquipment().getFeet());
    characterRing1JLabel.setText("" + character.getEquipment().getRing1());
    characterRing2JLabel.setText("" + character.getEquipment().getRing2());

    // Display the character's inventory.
    characterInventoryJTextArea.setText("");
    for (int index = 0; index < character.getNoOfItems(); index++)
      characterInventoryJTextArea.append("" + character.getInventory(index) + "\n");

    // Set the story and choices.
    storyJTextArea.setText(theGame.getStory().getStory());
    imageJPanel.remove(storyImage);
    // storyImage = theGame.getStory().getImage().getImage();
    // imageJPanel.add(storyImage);
    choice1JTextField.setText(theGame.getStory().getChoice(1).getChoiceStory());
    choice2JTextField.setText(theGame.getStory().getChoice(2).getChoiceStory());
    choice3JTextField.setText(theGame.getStory().getChoice(3).getChoiceStory());
    choice4JTextField.setText(theGame.getStory().getChoice(4).getChoiceStory());

    // Set choice buttons availability.
    choice1JButton.setEnabled(theGame.getChoiceAvailable(1));
    choice2JButton.setEnabled(theGame.getChoiceAvailable(2));
    choice3JButton.setEnabled(theGame.getChoiceAvailable(3));
    choice4JButton.setEnabled(theGame.getChoiceAvailable(4));
  } // loadGame

/* -------------------------------------------------------------------------
    METHOD TO ANIMATE THE STORY
   ------------------------------------------------------------------------- */

  private int charIndex = 0;
  private boolean textRunning = false;

  private void setStory(JTextArea storyTextArea)
  {
    String theStory = theGame.getStory().getStory();
    charIndex = 0;
    textRunning = true;
    storyTextArea.setText("");
    choice1JTextField.setText("");
    choice2JTextField.setText("");
    choice3JTextField.setText("");
    choice4JTextField.setText("");
    choice1JButton.setEnabled(false);
    choice2JButton.setEnabled(false);
    choice3JButton.setEnabled(false);
    choice4JButton.setEnabled(false);
    restartJButton.setEnabled(false);

    Timer timer = new Timer(25, new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        String currentChar = "" + theStory.charAt(charIndex);
        storyTextArea.append(currentChar);
        charIndex++;
        if (!gameStarted)
        {
          ((Timer)e.getSource()).stop();
          storyTextArea.setText("");
          textRunning = false;
        } // if
        if (charIndex >= theStory.length())
        {
          ((Timer)e.getSource()).stop();
          restartJButton.setEnabled(true);
          textRunning = false;
          refresh();
        } // if
      } // actionPerformed
    }); // timer

    timer.start();
  } // setStory

/* -------------------------------------------------------------------------
    MAIN METHOD TO CREATE THE GAME
   ------------------------------------------------------------------------- */

  public static void main(String args[])
  {
    gameName = new GameName();
    gameName.setVisible(true);
  } // main

} // class GameName
