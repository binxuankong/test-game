class Entity():
    def __init__(self, info):
        self.__id = info['ID']

        self.name = info['Name']
        self.element = info['Element']
        self.gender = info['Gender']
        self.weapon = info['Weapon']
        self.range = info['Range']

        # Base final stats
        self._hp = int(info['HP'])
        self._mp = int(info['MP'])
        self._attack = int(info['Attack'])
        self._defence = int(info['Defence'])
        self._speed = int(info['Speed'])

        # Base stats
        self.base_hp = self._hp
        self.base_mp = self._mp
        self.base_attack = self._attack
        self.base_defence = self._defence
        self.base_speed = self._speed
        self.base_critical_chance = 5
        self.base_multistrike_chance = 5
        self.base_counterattack_chance = 5
        self.base_recovery_potency = 100
        self.base_critical_damage = 200
        self.base_multistrike_damage = 100
        self.base_counterattack_damage = 100

        # In battle stats
        self.hp = self.base_hp
        self.max_hp = self.base_hp
        self.mp = self.base_mp
        self.max_mp = self.base_mp
        self.attack = self.base_attack
        self.defence = self.base_defence
        self.speed = self.base_speed
        self.critical_chance = self.base_critical_chance
        self.multistrike_chance = self.base_multistrike_chance
        self.counterattack_chance = self.base_counterattack_chance
        self.recovery_potency = self.base_recovery_potency
        self.critical_damage = self.base_critical_damage
        self.multistrike_damage = self.base_multistrike_damage
        self.counterattack_damage = self.base_counterattack_damage

        # For battle use
        self.is_alive = False
        self.curr_slot = -1
        self.buffs = []
        self.debuffs = []
        self.status = []
    

    # Ready to battle
    def battle(self):
        self.is_alive = True
        self.reset_stats()
    
    # Reset battle stats to base stats
    def reset_stats(self):
        self.hp = self.base_hp
        self.max_hp = self.base_hp
        self.mp = self.base_mp
        self.max_mp = self.base_mp
        self.attack = self.base_attack
        self.defence = self.base_defence
        self.speed = self.base_speed
        self.critical_chance = self.base_critical_chance
        self.multistrike_chance = self.base_multistrike_chance
        self.counterattack_chance = self.base_counterattack_chance
        self.recovery_potency = self.base_recovery_potency
        self.critical_damage = self.base_critical_damage
        self.multistrike_damage = self.base_multistrike_damage
        self.counterattack_damage = self.base_counterattack_damage
    

    # Lose hit points
    def lose_hp(self, value):
        self.hp -= value
        if self.hp <= 0:
            self.hp = 0
            self.is_alive = False
    
    # Gain hit points
    def gain_hp(self, value):
        self.hp += value
        if self.hp > self.max_hp:
            self.hp = self.max_hp
    
    # Get percentage of hit points
    def get_hpp(self):
        return int(self.hp / self.max_hp * 100)

    # Lose mana points
    def lose_mp(self, value):
        self.mp -= value
        if self.mp <= 0:
            self.mp = 0

    # Gain mana points
    def gain_mp(self, value):
        self.mp += value
        if self.mp > self.max_hp:
            self.mp = self.max_hp
    
    # Get percentage of mana points
    def get_mpp(self):
        return int(self.mp / self.max_mp * 100)


    # Use the name to represent an entity
    def __repr__(self):
        return self.name