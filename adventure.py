import csv
import ast
import numpy as np
from entity import Entity

class Adventure(Entity):
    ADVENTURE_DICTIONARY = {}

    # Take the name of an adventure as input
    def __init__(self, adventure):
        # Load the adventure dictionary if already have not
        if len(Adventure.ADVENTURE_DICTIONARY) == 0:
            with open('data/adventures.csv', 'r') as file:
                reader = csv.DictReader(file)
                for row in reader:
                    Adventure.ADVENTURE_DICTIONARY[row['Name']] = row
        
        # Get the info of given character
        info = Adventure.ADVENTURE_DICTIONARY[adventure]
        super().__init__(info)

        # Adventures only stuff
        self._class = info['Class']
        self.level = 1

        # Skills
        self.skill1 = info['Skill 1']
        self.skill2 = info['Skill 2']

        # Abilities
        self.ability1 = info['Ability 1']
        self.ability2 = info['Ability 2']
        self.ability3 = info['Ability 3']

        # Growth of stats when level up
        growth = ast.literal_eval(info['Level Up'])
        self.__hp_up = growth[0]
        self.__mp_up = growth[1]
        self.__atk_up = growth[2]
        self.__def_up = growth[3]
        self.__spd_up = growth[4]
     

    # Set level of the adventure
    def set_level(self, level):
        self.level = level
        self.base_hp = self._hp + self.exp_growth(level, self.__hp_up)
        self.base_mp = self._mp + self.lin_growth(level, self.__mp_up)
        self.base_attack = self._attack + self.exp_growth(level, self.__atk_up)
        self.base_defence = self._defence + self.exp_growth(level, self.__def_up)
        self.base_speed = self._speed + self.lin_growth(level, self.__spd_up)
        self.reset_stats()

    # Functions for level up stats growth
    def exp_growth(self, level, value):
        return int((level - 1) * np.exp(value))
    
    def lin_growth(self, level, value):
        return int((level - 1) * value)