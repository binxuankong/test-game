import random
from adventure import Adventure

# Constants
# Damage multiplier of each class
DAMAGE_MULTIPLIERS = {'Warrior': 2.2, 'Knight': 2.1, 'Ranger': 1.9, 'Rogue': 2.3, 'Magician': 1.7, 'Cleric': 1.7}
# Defence multiplier of each class
DEFENCE_MULTIPLIERS = {'Warrior': 1.3, 'Knight': 1.3, 'Ranger': 1.1, 'Rogue': 1.1, 'Magician': 1.0, 'Cleric': 1.0}
# Distance to reach to gain a turn (move distance based on speed)
DISTANCE = 2000
# Overshoot multiplier to account for when rejoining the queue
OVER_DISTANCE_MULTIPLIER = 0.25
# Own distance multiplier to for when rejoining the queue
SELF_DISTANCE_MULTIPLIER = 0.25
# Elemental advatange multiplier
ELEMENTAL_ADV_MULTIPLIER = 2
# Elemental disadvantage multiplier
ELEMENTAL_DIS_MULTIPLIER = 0.5

# Damage calculate
def damage_calculate(user, target):
    atk = user.attack
    _def = target.defence
    if type(user) is Adventure:
        atk_m = DAMAGE_MULTIPLIERS[user._class]
        def_m = target.defence_multiplier
    else:
        atk_m = user.damage_multiplier
        def_m = DEFENCE_MULTIPLIERS[target._class]
    damage = (atk * atk * atk_m) / (atk + _def * def_m)
    # Add randomness to damage (+-5%)
    damage = add_noise(damage, 5)
    # Check for type advantage
    damage = damage * element_check(user, target)
    return int(damage)

# Initial turn order
# Arg: List of units in battle
# Return: Ordered list [(Units, Distance)] as turn order
def initial_turn(units):
    order = [(unit, unit.speed) for unit in units]
    turn, order = speed_calculate(order)
    return turn, order

# Speed calculate
def speed_calculate(order):
    while (order[0][1] < DISTANCE):
        order = [(tup[0], tup[1] + tup[0].speed) for tup in order]
        order.sort(key=lambda tup: tup[1], reverse=True)
    first = order.pop(0)
    new_dist = OVER_DISTANCE_MULTIPLIER * (first[1] - DISTANCE) + SELF_DISTANCE_MULTIPLIER * first[0].speed
    order.append((first[0], new_dist))
    order.sort(key=lambda tup: tup[1], reverse=True)
    return first[0], order

# Check for element advantages
def element_check(user, target):
    if user.element == 'Ruby':
        if target.element == 'Sapphire':
            return ELEMENTAL_DIS_MULTIPLIER
        elif target.element == 'Emerald':
            return ELEMENTAL_ADV_MULTIPLIER
    elif user.element == 'Sapphire':
        if target.element == 'Emerald':
            return ELEMENTAL_DIS_MULTIPLIER
        elif target.element == 'Ruby':
            return ELEMENTAL_ADV_MULTIPLIER
    elif user.element == 'Emerald':
        if target.element == 'Ruby':
            return ELEMENTAL_DIS_MULTIPLIER
        elif target.element == 'Sapphire':
            return ELEMENTAL_ADV_MULTIPLIER
    elif user.element == 'Topaz':
        if target.element == 'Onyx':
            if type(user) is Adventure:
                return ELEMENTAL_ADV_MULTIPLIER
            else:
                return ELEMENTAL_DIS_MULTIPLIER
    elif user.element == 'Onyx':
        if target.element == 'Topaz':
            if type(user) is Adventure:
                return ELEMENTAL_ADV_MULTIPLIER
            else:
                return ELEMENTAL_DIS_MULTIPLIER
    else:
        return 1
    return 1

# Critical hit
def critical_roll(user, damage):
    critical = dice_roll(user.critical_chance)
    if critical:
        damage = damage * user.critical_damage / 100
    return int(damage), critical

# Multiattack
def multiattack_roll(user, target):
    multiattack = dice_roll(user.multistrike_chance)
    if multiattack:
        damage = damage_calculate(user, target)
        damage = damage * user.multistrike_damage / 100
        return int(damage)

# Counterattack
def counterattack_roll(user, target):
    counterattack = dice_roll(user.counterattack_chance)
    if counterattack:
        damage = damage_calculate(user, target)
        damage = damage * user.counterattack_damage / 100
        return int(damage)

# Add noise to include randomness, given limit of noise boundary
def add_noise(value, limit):
    noise = random.randint(-1 * limit, limit)
    value = value * (100 + noise) / 100
    return int(value)

# Roll dice
def dice_roll(value):
    rand = random.randint(0, 99)
    if rand < value:
        return True
    else:
        return False