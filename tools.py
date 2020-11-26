from PIL import Image, ImageTk
from adventure import Adventure
from monster import Monster


# -----------------------------------------------------------------------------------------------------------------------------
#   TO PREPARE FOR BATTLE
# -----------------------------------------------------------------------------------------------------------------------------

# Lock in the units for the battle
def lock_in(gui):
    # Clear everything
    clear_all(gui)
    # Try creating adventures
    try:
        gui.adv1 = Adventure(gui.adv1_name.get())
        gui.adv1.set_level(int(gui.adv1_level.get()))
    except:
        write_to_log(gui, "Cannot create adventure {}.".format(gui.adv1_name.get()))
        return
    try:
        gui.adv2 = Adventure(gui.adv2_name.get())
        gui.adv2.set_level(int(gui.adv2_level.get()))
    except:
        write_to_log(gui, "Cannot create adventure {}.".format(gui.adv2_name.get()))
        return
    try:
        gui.adv3 = Adventure(gui.adv3_name.get())
        gui.adv3.set_level(int(gui.adv3_level.get()))
    except:
        write_to_log(gui, "Cannot create adventure {}.".format(gui.adv3_name.get()))
        return
    try:
        gui.adv4 = Adventure(gui.adv4_name.get())
        gui.adv4.set_level(int(gui.adv4_level.get()))
    except:
        write_to_log(gui, "Cannot create adventure {}.".format(gui.adv4_name.get()))
        return
    # Enemies
    try:
        gui.mon1 = Monster(gui.mon1_name.get())
        # gui.mon1.set_level(int(gui.mon1_level.get()))
    except:
        write_to_log(gui, "Cannot create monster {}.".format(gui.mon1_name.get()))
        return
    
    # Change state of buttons and entries
    locked_in(gui)
    # Refresh/Display GUIs
    display_icons(gui)
    display_infos(gui)
    # Log message
    write_to_log(gui, "Successfully locked in")

# Clear all entries
def clear_entries(gui):
    # Names
    gui.adv1_name_entry.delete(0, 'end')
    gui.adv2_name_entry.delete(0, 'end')
    gui.adv3_name_entry.delete(0, 'end')
    gui.adv4_name_entry.delete(0, 'end')
    gui.mon1_name_entry.delete(0, 'end')
    # Levels
    gui.adv1_level_entry.delete(0, 'end')
    gui.adv2_level_entry.delete(0, 'end')
    gui.adv3_level_entry.delete(0, 'end')
    gui.adv4_level_entry.delete(0, 'end')
    gui.mon1_level_entry.delete(0, 'end')

# Stop the battle when win/lose
def stop_battle(gui):
    gui.curr_turn = None
    disable_actions(gui)
    # Refresh/Display selfs
    refresh_all(gui)
    display_screen(gui)
    display_potrait(gui, gui.selected_adv)

# Reset everything
def reset_battle(gui):
    # Clear everything
    clear_all(gui)
    # Objects
    gui.adv1 = None
    gui.adv2 = None
    gui.adv3 = None
    gui.adv4 = None
    gui.mon1 = None
    gui.list_adv = []
    gui.list_mon = []
    gui.slots = [None, None, None, None, None]
    # Situations
    gui.battle_ongoing = False
    gui.selected_adv = None
    gui.curr_turn = None
    gui.turn_order = None
    gui.turn_count = 0
    gui.rubbish = []
    # Change state of buttons and entries
    not_locked_in(gui)
    # Log message
    write_to_log(gui, "Reset.")


# -----------------------------------------------------------------------------------------------------------------------------
#   FOR EVERYTHING
# -----------------------------------------------------------------------------------------------------------------------------

# Refresh everything
def refresh_all(gui):
    # Refresh HP/MP bars
    display_infos(gui)
    # Refresh screen
    display_screen(gui)
    # Refresh stats
    refresh_stats(gui)

# Clear everything
def clear_all(gui):
    # Clear icons
    clear_icons(gui)
    # Clear infos
    clear_infos(gui)
    # Clear screen
    clear_screen(gui)
    # Clear potrait
    clear_potrait(gui)
    # Clear stats
    clear_stats(gui)


# -----------------------------------------------------------------------------------------------------------------------------
#   INFOS
# -----------------------------------------------------------------------------------------------------------------------------

# Display all adventures and monsters on icons
def display_icons(gui):
    display_icon(gui.adv1_btn, gui.adv1)
    display_icon(gui.adv2_btn, gui.adv2)
    display_icon(gui.adv3_btn, gui.adv3)
    display_icon(gui.adv4_btn, gui.adv4)
    display_icon_monster(gui, gui.mon1)

# Display the given adventure on the given icon
def display_icon(icon, adv):
    name = adv.name.lower().replace(' ', '_')
    img = Image.open('sprites/' + name + '.png')
    # img = ImageTk.PhotoImage(pad_image(img, 86))
    img = ImageTk.PhotoImage(resize_image(img, 86))
    icon.configure(image=img)
    icon.image = img

# Display the given monster on its icon
def display_icon_monster(gui, mon):
    name = mon.name.lower().replace(' ', '_')
    img = Image.open('sprites/' + name + '.png')
    # img = ImageTk.PhotoImage(pad_image(img, 86))
    img = ImageTk.PhotoImage(resize_image(img, 86))
    gui.mon1_btn.configure(image=img)
    gui.mon1_btn.image = img

# Select the adventure to display its stats (for icon click)
def select_adv(gui, num):
    if num == 1:
        gui.selected_adv = gui.adv1
    elif num == 2:
        gui.selected_adv = gui.adv2
    elif num == 3:
        gui.selected_adv = gui.adv3
    elif num == 4:
        gui.selected_adv = gui.adv4
    if num != 5:
        display_potrait(gui, gui.selected_adv)
        write_stats_adv(gui, gui.selected_adv)
        # Only can perform action if it is the current turn of the selected adventure (and battle is ongoing)
        if gui.curr_turn == gui.selected_adv and gui.battle_ongoing:
            enable_actions(gui)
        else:
            disable_actions(gui)
    else:
        display_potrait(gui, gui.mon1)
        write_stats_mon(gui, gui.mon1)
        disable_actions(gui)
    display_screen(gui)

# Automatically select the adventure to display (for when its turn)
def auto_select_adv(gui, adv):
    gui.selected_adv = adv
    display_potrait(gui, gui.selected_adv)
    write_stats_adv(gui, gui.selected_adv)
    display_screen(gui)


# Display the HP and MP bars of all adventures and monsters
def display_infos(gui):
    # Adventures names
    gui.adv1_name_lb.config(text=gui.adv1)
    gui.adv2_name_lb.config(text=gui.adv2)
    gui.adv3_name_lb.config(text=gui.adv3)
    gui.adv4_name_lb.config(text=gui.adv4)
    # Adventures HP bar
    set_adv_hp_bar(gui.adv1_hp_bar, gui.adv1.get_hpp())
    set_adv_hp_bar(gui.adv2_hp_bar, gui.adv2.get_hpp())
    set_adv_hp_bar(gui.adv3_hp_bar, gui.adv3.get_hpp())
    set_adv_hp_bar(gui.adv4_hp_bar, gui.adv4.get_hpp())
    # Adventures MP bar
    gui.adv1_mp_bar.config(value=gui.adv1.get_mpp())
    gui.adv2_mp_bar.config(value=gui.adv2.get_mpp())
    gui.adv3_mp_bar.config(value=gui.adv3.get_mpp())
    gui.adv4_mp_bar.config(value=gui.adv4.get_mpp())
    # Monster
    gui.mon1_name_lb.config(text=gui.mon1)
    gui.mon1_level_lb.config(text="LV. " + str(gui.mon1.level))
    set_mon_hp_bar(gui.mon1_hp_bar, gui.mon1.get_hpp())
    gui.mon1_mp_bar.config(value=gui.mon1.get_mpp())

# Clear all icons
def clear_icons(gui):
    # Adventures
    gui.adv1_btn.configure(image=gui.icon_pix)
    gui.adv1_btn.image = gui.icon_pix
    gui.adv2_btn.configure(image=gui.icon_pix)
    gui.adv2_btn.image = gui.icon_pix
    gui.adv3_btn.configure(image=gui.icon_pix)
    gui.adv3_btn.image = gui.icon_pix
    gui.adv4_btn.configure(image=gui.icon_pix)
    gui.adv4_btn.image = gui.icon_pix
    # Monster
    gui.mon1_btn.configure(image=gui.icon_pix)
    gui.mon1_btn.image = gui.icon_pix

# Clear all infos (HP and MP bars)
def clear_infos(gui):
    # Adventures names
    gui.adv1_name_lb.config(text="")
    gui.adv2_name_lb.config(text="")
    gui.adv3_name_lb.config(text="")
    gui.adv4_name_lb.config(text="")
    # Adventures HP bar
    gui.adv1_hp_bar.config(value=0)
    gui.adv2_hp_bar.config(value=0)
    gui.adv3_hp_bar.config(value=0)
    gui.adv4_hp_bar.config(value=0)
    # Adventures MP bar
    gui.adv1_mp_bar.config(value=0)
    gui.adv2_mp_bar.config(value=0)
    gui.adv3_mp_bar.config(value=0)
    gui.adv4_mp_bar.config(value=0)
    # Monster
    gui.mon1_name_lb.config(text="")
    gui.mon1_level_lb.config(text="")
    gui.mon1_hp_bar.config(value=0)
    gui.mon1_mp_bar.config(value=0)


# -----------------------------------------------------------------------------------------------------------------------------
#   SCREEN
# -----------------------------------------------------------------------------------------------------------------------------

# Display the screen
def display_screen(gui):
    # Clear screen first
    clear_screen(gui)
    for slot, units in enumerate(gui.slots):
        if units is None:
            pass
        elif type(units) is not list:
            posx = 170 / 2 # Canvas width
            posy = 384 / 2 # Canvas height
            draw_screen(gui, slot, units, posx, posy)
        elif len(units) > 1:
            posx = 170 / 2 # Canvas width
            posy = 384 / 3 # Canvas height
            draw_screen(gui, slot, units[0], posx, posy)
            posy = 384 * 2 / 3 # Canvas height
            draw_screen(gui, slot, units[1], posx, posy)

# Draw to the given screen, take screen number, unit and position as argument
def draw_screen(gui, num, unit, posx, posy):
    name = unit.name.lower().replace(' ', '_')
    # The unit whose current turn has different image
    if gui.curr_turn == unit and type(unit) is Adventure:
        img = ImageTk.PhotoImage(Image.open('sprites/' + name + '_attack.png'))
    # The unit is dead, no longer in battle
    elif not unit.is_alive and type(unit) is Adventure:
        img = ImageTk.PhotoImage(Image.open('sprites/' + name + '_dead.png'))
    else:
        img = ImageTk.PhotoImage(Image.open('sprites/' + name + '_battle.png'))
    gui.rubbish.append(img)
    if num == 0:
        gui.screen1.create_image(posx, posy, image=img)
    elif num == 1:
        gui.screen2.create_image(posx, posy, image=img)
    elif num == 2:
        gui.screen3.create_image(posx, posy, image=img)
    elif num == 3:
        gui.screen4.create_image(posx, posy, image=img)
    elif num == 4:
        gui.screen5.create_image(posx, posy, image=img)
    elif num == 5:
        gui.screen6.create_image(posx, posy, image=img)

# Clear all screen
def clear_screen(gui):
    gui.screen1.delete('all')
    gui.screen2.delete('all')
    gui.screen3.delete('all')
    gui.screen4.delete('all')
    gui.screen5.delete('all')
    gui.screen6.delete('all')


# -----------------------------------------------------------------------------------------------------------------------------
#   STATS
# -----------------------------------------------------------------------------------------------------------------------------

# Display potrait of the selected unit
def display_potrait(gui, unit):
    name = unit.name.lower().replace(' ', '_')
    img = Image.open('sprites/' + name + '.png')
    img = expand_image(img, 1.5)
    img = ImageTk.PhotoImage(pad_image(img, 140))
    # img = ImageTk.PhotoImage(resize_image(img, 140))
    gui.potrait_lb.configure(image=img)
    gui.potrait_lb.image = img

# Write the stats of the selected adventure to display
def write_stats_adv(gui, adv):
    # Displayed stats
    stat1 = \
    """
    {}
    Element: {}
    Weapon: {}
    HP: {}/{}
    Attack: {}
    Speed: {}
    Critical Chance: {}%
    Multistrike Chance: {}%
    Counterattack Chance: {}%
    """.format(adv.name, adv.element, adv.weapon, adv.hp, adv.max_hp, adv.attack, adv.speed, adv.critical_chance, \
        adv.multistrike_chance, adv.counterattack_chance)
    stat2 = \
    """
    Level: {}
    Class: {}
    Range: {}
    MP: {}/{}
    Defence: {}
    Recovery Potency: {}%
    Critical Damage: {}%
    Multistrike Damage: {}%
    Counterattack Damage: {}%
    """.format(adv.level, adv._class, adv.range, adv.mp, adv.max_mp, adv.defence, adv.recovery_potency, adv.critical_damage, \
        adv.multistrike_damage, adv.counterattack_damage)
    # Insert into GUI
    write_text(gui.stat1_text, stat1)
    write_text(gui.stat2_text, stat2)

# Write the stats of the selected enemy to display
def write_stats_mon(gui, mon):
    # Displayed stats
    stat1 = \
    """
    {}
    Element: {}
    Weapon: {}
    HP: {}/{}
    Attack: {}
    Speed: {}
    """.format(mon.name, mon.element, mon.weapon, mon.hp, mon.max_hp, mon.attack, mon.speed)
    stat2 = \
    """
    Level: {}
    Type: {}
    Range: {}
    MP: {}/{}
    Defence: {}
    """.format(mon.level, mon.type, mon.range, mon.mp, mon.max_mp, mon.defence)
    # Insert into GUI
    write_text(gui.stat1_text, stat1)
    write_text(gui.stat2_text, stat2)

# Refresh the stats (of the selected adventure)
def refresh_stats(gui):
    write_stats_adv(gui, gui.selected_adv)

# Clear the potrait
def clear_potrait(gui):
    gui.potrait_lb.configure(image=gui.potrait_pix)
    gui.potrait_lb.image = gui.potrait_pix

# Clear the stats
def clear_stats(gui):
    write_text(gui.stat1_text, "")
    write_text(gui.stat2_text, "")


# -----------------------------------------------------------------------------------------------------------------------------
#   ENTRIES
# -----------------------------------------------------------------------------------------------------------------------------

# -----------------------------------------------------------------------------------------------------------------------------
#   LOG
# -----------------------------------------------------------------------------------------------------------------------------

# Write to the log
def write_to_log(gui, msg):
    gui.log.configure(state='normal')
    gui.logger_index += 1.0
    gui.log.insert(gui.logger_index, msg + "\n")
    gui.log.configure(state='disabled')
    gui.log.see('end')

# Clear the log
def clear_log(gui):
    # Reset index
    gui.logger_index = 0.0
    gui.log.configure(state='normal')
    gui.log.delete(1.0, 'end')
    gui.log.configure(state='disabled')


# -----------------------------------------------------------------------------------------------------------------------------
#   BUTTONS AND ENTRIES
# -----------------------------------------------------------------------------------------------------------------------------

# Enable icons and battle
# Disable actions and entries
def locked_in(gui):
    enable_icons(gui)
    disable_actions(gui)
    gui.begin_battle_btn.configure(state='normal')
    disable_entries(gui)

# Enable icons and actions
# Disable entires and battle
def battle_start(gui):
    enable_icons(gui)
    enable_actions(gui)
    gui.begin_battle_btn.configure(state='disabled')
    disable_entries(gui)

# Enable entires
# Disable icons, actions and battle
def not_locked_in(gui):
    disable_icons(gui)
    disable_actions(gui)
    gui.begin_battle_btn.configure(state='disabled')
    enable_entries(gui)

# Enable icon buttons
def enable_icons(gui):
    gui.adv1_btn.configure(state='normal')
    gui.adv2_btn.configure(state='normal')
    gui.adv3_btn.configure(state='normal')
    gui.adv4_btn.configure(state='normal')
    gui.mon1_btn.configure(state='normal')

# Enable actions
def enable_actions(gui):
    gui.attack_btn.configure(state='normal')
    gui.focus_btn.configure(state='normal')
    gui.move_btn.configure(state='normal')
    gui.skill1_btn.configure(state='normal')
    gui.skill2_btn.configure(state='normal')
    gui.skill3_btn.configure(state='normal')

# Enable text entries, disable lock in and clear all button
def enable_entries(gui):
    # Name
    gui.adv1_name_entry.configure(state='normal')
    gui.adv2_name_entry.configure(state='normal')
    gui.adv3_name_entry.configure(state='normal')
    gui.adv4_name_entry.configure(state='normal')
    gui.mon1_name_entry.configure(state='normal')
    # Level
    gui.adv1_level_entry.configure(state='normal')
    gui.adv2_level_entry.configure(state='normal')
    gui.adv3_level_entry.configure(state='normal')
    gui.adv4_level_entry.configure(state='normal')
    gui.mon1_level_entry.configure(state='normal')
    # Lock in button
    gui.lock_in_btn.configure(state='normal')
    gui.clear_all_btn.configure(state='normal')

# Disable icon buttons
def disable_icons(gui):
    gui.adv1_btn.configure(state='disabled')
    gui.adv2_btn.configure(state='disabled')
    gui.adv3_btn.configure(state='disabled')
    gui.adv4_btn.configure(state='disabled')
    gui.mon1_btn.configure(state='disabled')

# Enable actions
def disable_actions(gui):
    gui.attack_btn.configure(state='disabled')
    gui.focus_btn.configure(state='disabled')
    gui.move_btn.configure(state='disabled')
    gui.skill1_btn.configure(state='disabled')
    gui.skill2_btn.configure(state='disabled')
    gui.skill3_btn.configure(state='disabled')

# Disable text entries, enable lock in and clear all button
def disable_entries(gui):
    # Name
    gui.adv1_name_entry.configure(state='disabled')
    gui.adv2_name_entry.configure(state='disabled')
    gui.adv3_name_entry.configure(state='disabled')
    gui.adv4_name_entry.configure(state='disabled')
    gui.mon1_name_entry.configure(state='disabled')
    # Level
    gui.adv1_level_entry.configure(state='disabled')
    gui.adv2_level_entry.configure(state='disabled')
    gui.adv3_level_entry.configure(state='disabled')
    gui.adv4_level_entry.configure(state='disabled')
    gui.mon1_level_entry.configure(state='disabled')
    # Lock in button
    gui.lock_in_btn.configure(state='disabled')
    gui.clear_all_btn.configure(state='disabled')


# -----------------------------------------------------------------------------------------------------------------------------
#   MIS
# -----------------------------------------------------------------------------------------------------------------------------

# HP bar for adventures (Thin)
def set_adv_hp_bar(bar, value):
    bar.config(value=value)
    if value > 50:
        bar.config(style="green.Horizontal.TProgressbar")
    elif value > 20:
        bar.config(style="orange.Horizontal.TProgressbar")
    else:
        bar.config(style="red.Horizontal.TProgressbar")

# HP bar for enemies (Thick)
def set_mon_hp_bar(bar, value):
    bar.config(value=value)
    if value > 50:
        bar.config(style="greenThick.Horizontal.TProgressbar")
    elif value > 20:
        bar.config(style="orangeThick.Horizontal.TProgressbar")
    else:
        bar.config(style="redThick.Horizontal.TProgressbar")

# Write to a disabled text (Clear previous ones first)
def write_text(text, msg):
    text.configure(state='normal')
    text.delete(1.0, 'end')
    text.insert(1.0, msg)
    text.configure(state='disabled')

# Pad the image to a square (withou resizing)
def pad_image(img, size):
    # Create a new image and paste the image on it
    new_img = Image.new("RGB", (size, size), (255, 255, 255, 0))
    new_img.paste(img, ((size - img.size[0]) // 2, (size - img.size[1]) // 2), mask=img)
    return new_img

# Resize the image by multiplying the given value. Keeps the aspect ratio
def expand_image(img, const):
    new_size = tuple([int(x * const) for x in img.size])
    new_img = img.resize(new_size, Image.ANTIALIAS)
    return new_img

# Resize image to a square with desired size
def resize_image(img, size):
    old_size = img.size
    ratio = float(size) / max(old_size)
    new_size = tuple([int(x * ratio) for x in old_size])
    img = img.resize(new_size, Image.ANTIALIAS)
    # Create a new image and paste the resized on it
    new_img = Image.new("RGB", (size, size), (255, 255, 255, 0))
    new_img.paste(img, ((size - new_size[0]) // 2, (size - new_size[1]) // 2), mask=img)
    return new_img