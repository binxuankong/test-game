import csv
from entity import Entity

class Monster(Entity):
    MONSTER_DICTIONARY = {}

    # Take the name of an monster as input
    def __init__(self, monster):
        # Load the Monster dictionary if already have not
        if len(Monster.MONSTER_DICTIONARY) == 0:
            with open('data/monsters.csv', 'r') as file:
                reader = csv.DictReader(file)
                for row in reader:
                    Monster.MONSTER_DICTIONARY[row['Name']] = row
        
        # Get the info of given monster
        info = Monster.MONSTER_DICTIONARY[monster]
        super().__init__(info)

        # Monsters only stuff
        self.level = int(info['Level'])
        self.type = info['Type']
        self.damage_multiplier = float(info['Damage Multiplier'])
        self.defence_multiplier = float(info['Defence Multiplier'])