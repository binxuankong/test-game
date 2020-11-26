from tkinter import Frame, Button, Label, Text, Entry, Canvas, PhotoImage, StringVar, Toplevel
from tkinter.ttk import Style, Progressbar
from tkinter.messagebox import showwarning
from PIL import Image, ImageTk
from adventure import Adventure
from monster import Monster
from tools import *
from mechanics import *

class Application(Frame):
    def __init__(self, master):
        super().__init__(master)

        # Dimensions of the whole application
        master_w = 1280
        master_h = 640

        # Dummy pixel for button size
        # self.pixel = PhotoImage(width=1, height=1)
        self.pixel = ImageTk.PhotoImage(Image.new('RGB', (1,1)))

        # Colour for frames
        infos_col = 'yellow'
        stats_col = 'red'
        input_col = 'purple'
        screen_col = 'green'

        # FRAMES
        # Left and right frames
        left_frame_w = master_w * 0.8
        right_frame_w = master_w * 0.2
        self.left_frame = Frame(master, width=left_frame_w, height=master_h)
        self.left_frame.grid(row=0, column=0)
        self.right_frame = Frame(master, width=right_frame_w, height=master_h)
        self.right_frame.grid(row=0, column=1)

        # Left frame (Infos, screen and stats)
        infos_frame_h = 0.15 * master_h
        screen_frame_h = 0.6 * master_h
        stats_frame_h = 0.25 * master_h
        self.infos_frame = Frame(self.left_frame, width=left_frame_w, height=infos_frame_h)
        self.infos_frame.grid(row=0, column=0)
        self.screen_frame = Frame(self.left_frame, width=left_frame_w, height=screen_frame_h)
        self.screen_frame.grid(row=1, column=0)
        self.screen_frame.grid_propagate(False)
        self.stats_frame = Frame(self.left_frame, width=left_frame_w, height=stats_frame_h)
        self.stats_frame.grid(row=2, column=0)

        # Right frame (Inputs and logs)
        input_frame_h = master_h * 0.4 - 8
        log_frame_h = master_h * 0.6 + 8
        self.input_frame = Frame(self.right_frame, width=right_frame_w, height=input_frame_h)
        self.input_frame.grid(row=0, column=0)
        self.log_frame = Frame(self.right_frame, width=right_frame_w, height=log_frame_h, bg='blue')
        self.log_frame.grid(row=1, column=0)
        self.log_frame.grid_propagate(False)

        # Infos frame (Icons, info and enemy)
        icons_frame_w = 378
        info_frame_w = (left_frame_w - icons_frame_w) / 2
        enemy_frame_w = (left_frame_w - icons_frame_w) / 2
        self.icons_frame = Frame(self.infos_frame, width=icons_frame_w, height=infos_frame_h, bg=infos_col)
        self.icons_frame.grid(row=0, column=0)
        self.icons_frame.grid_propagate(False)
        self.info_frame = Frame(self.infos_frame, width=info_frame_w, height=infos_frame_h, bg=infos_col)
        self.info_frame.grid(row=0, column=1)
        self.info_frame.grid_propagate(False)
        self.enemy_frame = Frame(self.infos_frame, width=enemy_frame_w, height=infos_frame_h, bg=infos_col)
        self.enemy_frame.grid(row=0, column=2)
        self.enemy_frame.grid_propagate(False)

        # Stats frame (Potrait, stat and actions)
        potrait_frame_w = left_frame_w * 0.2
        stat_frame_w = left_frame_w * 0.5
        actions_frame_w = left_frame_w * 0.3
        self.potrait_frame = Frame(self.stats_frame, width=potrait_frame_w, height=stats_frame_h, bg=stats_col)
        self.potrait_frame.grid(row=0, column=0)
        self.potrait_frame.grid_propagate(False)
        self.stat_frame = Frame(self.stats_frame, width=stat_frame_w, height=stats_frame_h, bg=stats_col)
        self.stat_frame.grid(row=0, column=1)
        self.stat_frame.grid_propagate(False)
        self.actions_frame = Frame(self.stats_frame, width=actions_frame_w, height=stats_frame_h, bg=stats_col)
        self.actions_frame.grid(row=0, column=2)
        self.actions_frame.grid_propagate(False)

        # Settings frame (entries and buttons)
        entries_frame_h = input_frame_h * 0.75
        buttons_frame_h = input_frame_h * 0.25
        self.entries_frame = Frame(self.input_frame, width=right_frame_w, height=entries_frame_h, bg=input_col)
        self.entries_frame.grid(row=0, column=0)
        self.entries_frame.grid_propagate(False)
        self.buttons_frame = Frame(self.input_frame, width=right_frame_w, height=buttons_frame_h, bg=input_col)
        self.buttons_frame.grid(row=1, column=0)
        self.buttons_frame.grid_propagate(False)

        # Icons frame
        # Dummy image for icons
        self.icon_pix = ImageTk.PhotoImage(Image.new('RGB', (86, 86), (255, 255, 255)))
        # Adventure icons
        self.adv1_btn = Button(self.icons_frame, text="", image=self.icon_pix, command=lambda: select_adv(self, 1), compound='c')
        self.adv1_btn.grid(row=0, column=0, padx=2, pady=2)
        self.adv2_btn = Button(self.icons_frame, text="", image=self.icon_pix, command=lambda: select_adv(self, 2), compound='c')
        self.adv2_btn.grid(row=0, column=1, padx=2, pady=2)
        self.adv3_btn = Button(self.icons_frame, text="", image=self.icon_pix, command=lambda: select_adv(self, 3), compound='c')
        self.adv3_btn.grid(row=0, column=2, padx=2, pady=2)
        self.adv4_btn = Button(self.icons_frame, text="", image=self.icon_pix, command=lambda: select_adv(self, 4), compound='c')
        self.adv4_btn.grid(row=0, column=3, padx=2, pady=2)
        # Adventure names
        self.adv1_name_lb = Label(self.info_frame, text="", bg=infos_col, anchor='w', width=16)
        self.adv1_name_lb.grid(row=0, column=0, rowspan=2, padx=(8,2))
        self.adv2_name_lb = Label(self.info_frame, text="", bg=infos_col, anchor='w', width=16)
        self.adv2_name_lb.grid(row=2, column=0, rowspan=2, padx=(8,2))
        self.adv3_name_lb = Label(self.info_frame, text="", bg=infos_col, anchor='w', width=16)
        self.adv3_name_lb.grid(row=4, column=0, rowspan=2, padx=(8,2))
        self.adv4_name_lb = Label(self.info_frame, text="", bg=infos_col, anchor='w', width=16)
        self.adv4_name_lb.grid(row=6, column=0, rowspan=2, padx=(8,2))
        # HP and MP bars
        # Style for bars
        s = Style()
        s.theme_use("default")
        s.configure("red.Horizontal.TProgressbar", foreground='red', background='red', thickness=2)
        s.configure("blue.Horizontal.TProgressbar", foreground='blue', background='blue', thickness=2)
        s.configure("green.Horizontal.TProgressbar", foreground='green', background='green', thickness=2)
        s.configure("orange.Horizontal.TProgressbar", foreground='orange', background='orange', thickness=2)
        # Padding for bars
        hp_pady = (4,0)
        mp_pady = (0,4)
        # Adventure 1
        self.adv1_hp_bar = Progressbar(self.info_frame, style="green.Horizontal.TProgressbar", orient="horizontal", length=150, \
            mode="determinate", maximum=100)
        self.adv1_hp_bar.grid(row=0, column=1, pady=hp_pady, sticky='w')
        self.adv1_mp_bar = Progressbar(self.info_frame, style="blue.Horizontal.TProgressbar", orient="horizontal", length=150, \
            mode="determinate", maximum=100)
        self.adv1_mp_bar.grid(row=1, column=1, pady=mp_pady, stick='w')
        # Adventure 2
        self.adv2_hp_bar = Progressbar(self.info_frame, style="green.Horizontal.TProgressbar", orient="horizontal", length=150, \
            mode="determinate", maximum=100)
        self.adv2_hp_bar.grid(row=2, column=1, pady=hp_pady, sticky='w')
        self.adv2_mp_bar = Progressbar(self.info_frame, style="blue.Horizontal.TProgressbar", orient="horizontal", length=150, \
            mode="determinate", maximum=100)
        self.adv2_mp_bar.grid(row=3, column=1, pady=mp_pady, stick='w')
        # Adventure 3
        self.adv3_hp_bar = Progressbar(self.info_frame, style="green.Horizontal.TProgressbar", orient="horizontal", length=150, \
            mode="determinate", maximum=100)
        self.adv3_hp_bar.grid(row=4, column=1, pady=hp_pady, sticky='w')
        self.adv3_mp_bar = Progressbar(self.info_frame, style="blue.Horizontal.TProgressbar", orient="horizontal", length=150, \
            mode="determinate", maximum=100)
        self.adv3_mp_bar.grid(row=5, column=1, pady=mp_pady, stick='w')
        # Adventure 4
        self.adv4_hp_bar = Progressbar(self.info_frame, style="green.Horizontal.TProgressbar", orient="horizontal", length=150, \
            mode="determinate", maximum=100)
        self.adv4_hp_bar.grid(row=6, column=1, pady=hp_pady, sticky='w')
        self.adv4_mp_bar = Progressbar(self.info_frame, style="blue.Horizontal.TProgressbar", orient="horizontal", length=150, \
            mode="determinate", maximum=100)
        self.adv4_mp_bar.grid(row=7, column=1, pady=mp_pady, stick='w')

        # Enemy frame
        self.mon1_btn = Button(self.enemy_frame, text="", image=self.icon_pix, command=lambda: select_adv(self, 5), compound='c')
        self.mon1_btn.grid(row=0, column=0, rowspan=4, padx=2, pady=2)
        self.mon1_name_lb = Label(self.enemy_frame, text="", bg=infos_col, anchor='w', width=24)
        self.mon1_name_lb.grid(row=0, column=1, padx=2, columnspan=2, sticky='w')
        self.mon1_level_lb = Label(self.enemy_frame, text="", bg=infos_col, anchor='w', width=24)
        self.mon1_level_lb.grid(row=1, column=1, padx=2, columnspan=2, sticky='w')
        # HP and MP bar style for enemy thicker
        s.configure("redThick.Horizontal.TProgressbar", foreground='red', background='red', thickness=6)
        s.configure("blueThick.Horizontal.TProgressbar", foreground='blue', background='blue', thickness=6)
        s.configure("greenThick.Horizontal.TProgressbar", foreground='green', background='green', thickness=6)
        s.configure("orangeThick.Horizontal.TProgressbar", foreground='orange', background='orange', thickness=6)
        # HP and MP bar
        Label(self.enemy_frame, text="HP", bg=infos_col, anchor='w').grid(row=2, column=1, padx=2, sticky='w')
        self.mon1_hp_bar = Progressbar(self.enemy_frame, style="greenThick.Horizontal.TProgressbar", orient="horizontal", \
            length=180, mode="determinate", maximum=100)
        self.mon1_hp_bar.grid(row=2, column=2, sticky='w')
        Label(self.enemy_frame, text="MP", bg=infos_col, anchor='w').grid(row=3, column=1, padx=2, sticky='w')
        self.mon1_mp_bar = Progressbar(self.enemy_frame, style="blueThick.Horizontal.TProgressbar", orient="horizontal", \
            length=180, mode="determinate", maximum=100)
        self.mon1_mp_bar.grid(row=3, column=2, sticky='w')

        # Screen frame
        canvas_h = 384
        canvas_w = 170
        self.screen1 = Canvas(self.screen_frame, height=canvas_h, width=canvas_w, bg=screen_col, bd=0, highlightthickness=0)
        self.screen1.grid(row=0, column=0, padx=(2,0))
        self.screen2 = Canvas(self.screen_frame, height=canvas_h, width=canvas_w, bg=screen_col, bd=0, highlightthickness=0)
        self.screen2.grid(row=0, column=1)
        self.screen3 = Canvas(self.screen_frame, height=canvas_h, width=canvas_w, bg=screen_col, bd=0, highlightthickness=0)
        self.screen3.grid(row=0, column=2)
        self.screen4 = Canvas(self.screen_frame, height=canvas_h, width=canvas_w, bg=screen_col, bd=0, highlightthickness=0)
        self.screen4.grid(row=0, column=3)
        self.screen5 = Canvas(self.screen_frame, height=canvas_h, width=canvas_w, bg=screen_col, bd=0, highlightthickness=0)
        self.screen5.grid(row=0, column=4)
        self.screen6 = Canvas(self.screen_frame, height=canvas_h, width=canvas_w, bg=screen_col, bd=0, highlightthickness=0)
        self.screen6.grid(row=0, column=5)

        # Potrait frame
        # Dummy image for potrait
        self.potrait_pix = ImageTk.PhotoImage(Image.new('RGB', (140, 140), (255, 255, 255)))
        self.potrait_lb = Label(self.potrait_frame, image=self.potrait_pix)
        self.potrait_lb.image = self.potrait_pix
        self.potrait_lb.grid(row=1, column=1)
        # Give empty row and column weights so they take up empty spaces
        self.potrait_frame.grid_rowconfigure(0, weight=1)
        self.potrait_frame.grid_rowconfigure(2, weight=1)
        self.potrait_frame.grid_columnconfigure(0, weight=1)
        self.potrait_frame.grid_columnconfigure(2, weight=1)

        # Stat frame
        text_w = 35
        text_h = 11
        self.stat1_text = Text(self.stat_frame, bg='orange', state='disabled', width=text_w, height=text_h, bd=0, \
            highlightthickness=0)
        self.stat1_text.grid(row=1, column=1)
        self.stat2_text = Text(self.stat_frame, bg='orange', state='disabled', width=text_w, height=text_h, bd=0, \
            highlightthickness=0)
        self.stat2_text.grid(row=1, column=2)
        # Give empty row and column weights so they take up empty spaces
        self.stat_frame.grid_rowconfigure(0, weight=1)
        self.stat_frame.grid_rowconfigure(2, weight=1)
        self.stat_frame.grid_columnconfigure(0, weight=1)
        self.stat_frame.grid_columnconfigure(3, weight=1)

        # Actions frame
        # Dummy image for action buttons
        self.action_pix = ImageTk.PhotoImage(Image.new('RGB', (70, 70), (255, 255, 255)))
        # Normal actions
        self.attack_btn = Button(self.actions_frame, text="Attack", image=self.action_pix, command=lambda: self.user_attack(), \
            compound='c')
        self.attack_btn.grid(row=1, column=1, padx=2, pady=2)
        self.focus_btn = Button(self.actions_frame, text="Focus", image=self.action_pix, \
            compound='c')
        self.focus_btn.grid(row=1, column=2, padx=2, pady=2)
        self.move_btn = Button(self.actions_frame, text="Move", image=self.action_pix, \
            compound='c')
        self.move_btn.grid(row=1, column=3, padx=2, pady=2)
        # Skills
        self.skill1_btn = Button(self.actions_frame, text="Skill 1", image=self.action_pix, \
            compound='c')
        self.skill1_btn.grid(row=2, column=1, padx=2, pady=2)
        self.skill2_btn = Button(self.actions_frame, text="Skill 2", image=self.action_pix, \
            compound='c')
        self.skill2_btn.grid(row=2, column=2, padx=2, pady=2)
        self.skill3_btn = Button(self.actions_frame, text="Skill 3", image=self.action_pix, \
            compound='c')
        self.skill3_btn.grid(row=2, column=3, padx=2, pady=2)
        # Give empty row and column weights so they take up empty spaces
        self.actions_frame.grid_rowconfigure(0, weight=1)
        self.actions_frame.grid_rowconfigure(3, weight=1)
        self.actions_frame.grid_columnconfigure(0, weight=1)
        self.actions_frame.grid_columnconfigure(4, weight=1)

        # Entries frame
        input_pad_x = (12,0)
        Label(self.entries_frame, text="Adventure", bg=input_col, anchor='w') \
            .grid(row=0, column=0, padx=input_pad_x, pady=(4,0), sticky='w')
        Label(self.entries_frame, text="Level", bg=input_col, anchor='w')\
            .grid(row=0, column=1, pady=(4,0), sticky='w')
        # String variables for name and level (adventures)
        self.adv1_name = StringVar(value='Daou')
        self.adv1_level = StringVar(value='80')
        self.adv2_name = StringVar(value='Luna')
        self.adv2_level = StringVar(value='80')
        self.adv3_name = StringVar(value='Hinata')
        self.adv3_level = StringVar(value='80')
        self.adv4_name = StringVar(value='Nix')
        self.adv4_level = StringVar(value='80')
         # Enemies
        self.mon1_name = StringVar(value='Straw Dummy')
        self.mon1_level = StringVar(value='10')
        # Name entries
        name_entry_w = 17
        self.adv1_name_entry = Entry(self.entries_frame, textvariable=self.adv1_name, width=name_entry_w, bd=0, \
            highlightthickness=0)
        self.adv1_name_entry.grid(row=1, column=0, padx=input_pad_x)
        self.adv2_name_entry = Entry(self.entries_frame, textvariable=self.adv2_name, width=name_entry_w, bd=0, \
            highlightthickness=0)
        self.adv2_name_entry.grid(row=2, column=0, padx=input_pad_x)
        self.adv3_name_entry = Entry(self.entries_frame, textvariable=self.adv3_name, width=name_entry_w, bd=0, \
            highlightthickness=0)
        self.adv3_name_entry.grid(row=3, column=0, padx=input_pad_x)
        self.adv4_name_entry = Entry(self.entries_frame, textvariable=self.adv4_name, width=name_entry_w, bd=0, \
            highlightthickness=0)
        self.adv4_name_entry.grid(row=4, column=0, padx=input_pad_x)
        # Level entries
        level_entry_w = 5
        self.adv1_level_entry = Entry(self.entries_frame, textvariable=self.adv1_level, width=level_entry_w, bd=0, \
            highlightthickness=0)
        self.adv1_level_entry.grid(row=1, column=1, padx=4)
        self.adv2_level_entry = Entry(self.entries_frame, textvariable=self.adv2_level, width=level_entry_w, bd=0, \
            highlightthickness=0)
        self.adv2_level_entry.grid(row=2, column=1, padx=4)
        self.adv3_level_entry = Entry(self.entries_frame, textvariable=self.adv3_level, width=level_entry_w, bd=0, \
            highlightthickness=0)
        self.adv3_level_entry.grid(row=3, column=1, padx=4)
        self.adv4_level_entry = Entry(self.entries_frame, textvariable=self.adv4_level, width=level_entry_w, bd=0, \
            highlightthickness=0)
        self.adv4_level_entry.grid(row=4, column=1, padx=4)
        # Dummy image for action buttons
        self.check_info_pix = ImageTk.PhotoImage(Image.new('RGB', (20, 20), (255, 255, 255)))
        # Check info button
        self.adv1_check_info = Button(self.entries_frame, text="C", image=self.check_info_pix, compound='c', \
            command=lambda: self.show_info_adventure(self.adv1_name, self.adv1_level))
        self.adv1_check_info.grid(row=1, column=2, padx=2)
        self.adv2_check_info = Button(self.entries_frame, text="C", image=self.check_info_pix, compound='c', \
            command=lambda: self.show_info_adventure(self.adv2_name, self.adv2_level))
        self.adv2_check_info.grid(row=2, column=2, padx=2)
        self.adv3_check_info = Button(self.entries_frame, text="C", image=self.check_info_pix, compound='c', \
            command=lambda: self.show_info_adventure(self.adv3_name, self.adv3_level))
        self.adv3_check_info.grid(row=3, column=2, padx=2)
        self.adv4_check_info = Button(self.entries_frame, text="C", image=self.check_info_pix, compound='c', \
            command=lambda: self.show_info_adventure(self.adv4_name, self.adv4_level))
        self.adv4_check_info.grid(row=4, column=2, padx=2)
        # Monster
        Label(self.entries_frame, text="Monster", bg=input_col, anchor='w') \
            .grid(row=5, column=0, padx=input_pad_x, pady=(4,0), sticky='w')
        Label(self.entries_frame, text="Level", bg=input_col, anchor='w') \
            .grid(row=5, column=1, pady=(4,0), sticky='w')
        self.mon1_name_entry = Entry(self.entries_frame, textvariable=self.mon1_name, width=name_entry_w, bd=0, \
            highlightthickness=0)
        self.mon1_name_entry.grid(row=6, column=0, padx=input_pad_x)
        self.mon1_level_entry = Entry(self.entries_frame, textvariable=self.mon1_level, width=level_entry_w, bd=0, \
            highlightthickness=0)
        self.mon1_level_entry.grid(row=6, column=1, padx=4)
        self.mon1_check_info = Button(self.entries_frame, text="C", image=self.check_info_pix, \
            compound='c')
        self.mon1_check_info.grid(row=6, column=2, padx=2)

        # Buttons frame
        self.lock_in_btn = Button(self.buttons_frame, text="Lock In", width=10, command=lambda: lock_in(self))
        self.lock_in_btn.grid(row=1, column=1, padx=8, pady=(0,8))
        self.clear_all_btn = Button(self.buttons_frame, text="Clear All", width=10, command=lambda: clear_entries(self))
        self.clear_all_btn.grid(row=1, column=2, padx=8, pady=(0,8))
        self.begin_battle_btn = Button(self.buttons_frame, text="Begin Battle", width=10, command=self.begin_battle)
        self.begin_battle_btn.grid(row=2, column=1, padx=8, pady=(0,4))
        self.reset_battle_btn = Button(self.buttons_frame, text="Reset Battle", width=10, command=lambda: reset_battle(self))
        self.reset_battle_btn.grid(row=2, column=2, padx=8, pady=(0,4))
        # Give empty row and column weights so they take up empty spaces
        self.buttons_frame.grid_rowconfigure(0, weight=1)
        self.buttons_frame.grid_rowconfigure(3, weight=1)
        self.buttons_frame.grid_columnconfigure(0, weight=1)
        self.buttons_frame.grid_columnconfigure(3, weight=1)

        # Log frame
        self.log = Text(self.log_frame, state = 'disabled', width = 38, height = 24)
        self.log.grid(column=1, row=1, sticky = 'n')
        self.log.configure(font = 'times 12', background = 'gray26', foreground = 'snow')
        self.clear_log_btn = Button(self.log_frame, text = "Clear Log", command=lambda: clear_log(self))
        self.clear_log_btn.grid(column=1, row = 2)
        # Index to keep track of log position
        self.logger_index = 0.0
        # Give empty row and column weights so they take up empty spaces
        self.log_frame.grid_rowconfigure(0, weight=1)
        self.log_frame.grid_rowconfigure(2, weight=1)
        self.log_frame.grid_columnconfigure(0, weight=1)
        self.log_frame.grid_columnconfigure(3, weight=1)

        # Entity objects
        self.adv1 = None
        self.adv2 = None
        self.adv3 = None
        self.adv4 = None
        self.mon1 = None
        self.list_adv = []
        self.list_mon = []
        self.slots = [None, None, None, None, None, None]

        # Battle situation
        self.battle_ongoing = False
        self.selected_adv = None
        self.curr_turn = None
        self.turn_order = []
        self.turn_count = 0

        # Rubbish collection
        self.rubbish = []

        # Buttons and entires initial state
        disable_icons(self)
        disable_actions(self)
        # Others
        self.begin_battle_btn.configure(state='disabled')


    # Start the battle
    def begin_battle(self):
        self.battle_ongoing = True
        # Get the units ready for battle
        self.adv1.battle()
        self.adv2.battle()
        self.adv3.battle()
        self.adv4.battle()
        self.mon1.battle()
        # Add the units to list
        self.list_adv = [self.adv1, self.adv2, self.adv3, self.adv4]
        self.list_mon = [self.mon1]

        # Put the units in their respective slots
        self.adv1.curr_slot = 2
        self.adv2.curr_slot = 1
        self.adv3.curr_slot = 1
        self.adv4.curr_slot = 0
        self.mon1.curr_slot = 4
        self.slots[2] = self.adv1
        self.slots[1] = [self.adv2, self.adv3]
        self.slots[0] = self.adv4
        self.slots[4] = self.mon1

        # Check who starts first
        self.curr_turn, self.turn_order = initial_turn(self.list_adv + self.list_mon)
        # Check if user start first, if not select the next one
        if type(self.curr_turn) is Adventure:
            auto_select_adv(self, self.curr_turn)
        else:
            auto_select_adv(self, self.turn_order[0][0])
        self.turn_count = 0

        # Change state of buttons and entries
        battle_start(self)
        # Refresh/Display selfs
        refresh_all(self)
        display_screen(self)
        display_potrait(self, self.selected_adv)
        # Log message
        write_to_log(self, "Battle begin!")
        self.display_turn()


    # User's turn: Attack
    def user_attack(self):
        self.attack(self.selected_adv, self.mon1)
        if self.battle_ongoing:
            # Next turn
            self.curr_turn, self.turn_order = speed_calculate(self.turn_order)
            self.display_turn()
            # If it is still user's turn, switch to that adventure
            if type(self.curr_turn) is Adventure:
                auto_select_adv(self, self.curr_turn)
            # It's enemy's turn. Perform enemy's action and go to the next turn
            else:
                self.enemy_attack()
        else:
            stop_battle(self)
    
    # Enemy's turn
    def enemy_attack(self):
        # Enemy will attack a random target, more likely to hit nearer units
        rand = random.randint(0, 99)
        if rand < 10:
            target = self.adv4
        elif rand < 20:
            target = self.adv3
        elif rand < 50:
            target = self.adv2
        else:
            target = self.adv1
        self.attack(self.mon1, target)
        if self.battle_ongoing:
            # Next turn
            self.curr_turn, self.turn_order = speed_calculate(self.turn_order)
            self.display_turn()
            # If it is still user's turn, switch to that adventure
            if type(self.curr_turn) is Adventure:
                auto_select_adv(self, self.curr_turn)
            # It's enemy's turn. Perform enemy's action and go to the next turn
            else:
                self.enemy_attack()
        else:
            stop_battle(self)
        refresh_all(self)
        self.check_battle_status()

    # Attack action
    def attack(self, user, target):
        damage = damage_calculate(user, target)
        # Roll for critical
        damage, critical = critical_roll(user, damage)
        target.lose_hp(damage)
        if critical:
            write_to_log(self, "Critical strike! {} dealt {} damage to {}.".format(user, damage, target))
        else:
            write_to_log(self, "{} dealt {} damage to {}.".format(user, damage, target))
        # Roll for multistrike
        multistrike = multiattack_roll(user, target)
        if user.is_alive and target.is_alive and multistrike is not None:
            write_to_log(self, "{} multi strikes!".format(user))
            target.lose_hp(multistrike)
            write_to_log(self, "{} dealt {} damage to {}".format(user, multistrike, target))
        # Roll for counterattack
        counterattack = counterattack_roll(target, user)
        if user.is_alive and target.is_alive and counterattack is not None:
            write_to_log(self, "{} counterattacks!".format(target))
            user.lose_hp(counterattack)
            write_to_log(self, "{} dealt {} damage to {}".format(target, counterattack, user))
        refresh_all(self)
        self.check_battle_status()
    
    # Check if any units have died, and update battle status
    def check_battle_status(self):
        for adv in self.list_adv:
            if not adv.is_alive:
                write_to_log(self, "{} has died.".format(adv))
                self.list_adv.remove(adv)
        if len(self.list_adv) == 0:
            write_to_log(self, "You lost! Play again?")
            self.battle_ongoing = False
        for mon in self.list_mon:
            if not mon.is_alive:
                write_to_log(self, "{} has died.".format(mon))
                self.list_mon.remove(mon)
        if len(self.list_mon) == 0:
            write_to_log(self, "You won! Play again?")
            self.battle_ongoing = False
        # Check turn order
        self.check_turn_order()
    
    # Remove unit from turn order list if they are dead
    def check_turn_order(self):
        for unit in self.turn_order:
            if not unit[0].is_alive:
                self.turn_order.remove(unit)

    # Pop up window to show the info of the adventure
    def show_info_adventure(self, name, level):
        try:
            adv = Adventure(name.get())
            adv.set_level(int(level.get()))
        except:
            showwarning("Cannot Show Info", "No such adventure {} exists!".format(name.get()))
            return
        
        win = Toplevel()
        win.wm_title("Window")
        # Popup info width and height
        w = 420
        h = 320
        # Get screen width and height
        ws = self.winfo_screenwidth()
        hs = self.winfo_screenheight()
        # Calculate x and y coordinates for the Tk root window
        x = (ws/2) - (w/2)
        y = (hs/2) - (h/2)
        win.geometry('%dx%d+%d+%d' % (w, h, x, y))

        img = Image.open('sprites/' + adv.name + '.png')
        img = ImageTk.PhotoImage(pad_image(img, 100))
        self.rubbish.append(img)
        stats = \
        """{}\t\t\t    Level: {}
Element: {}\t\t\t    Class: {}
Weapon: {}\t\t\t    Range: {}
HP: {}\t\t\t    MP: {}
Attack: {}\t\t\t    Defence: {}
Speed: {}\t\t\t    Recovery Potency: {}%
Critical Chance: {}%\t\t\t    Critical Damage: {}
Multistrike Chance: {}%\t\t\t   Multistrike Damage: {}%
Counterattack Chance: {}%\t\t\t Counterattack Damage: {}%
Skills:\t\t\t    Abilities:
{}\t\t\t    {}
{}\t\t\t    {}
Skill3\t\t\t    {}""".format(adv.name, adv.level, adv.element, adv._class, adv.weapon, adv.range, adv.hp, adv.mp, adv.attack, \
                             adv.defence, adv.speed, adv.recovery_potency, adv.critical_chance, adv.critical_damage, \
                             adv.multistrike_chance, adv.multistrike_damage, adv.counterattack_chance, adv.counterattack_damage, \
                             adv.skill1, adv.ability1, adv.skill2, adv.ability2, adv.ability3)

        # Image
        img_l = Label(win, text="", image=img)
        img_l.grid(row=1, column=1)
        # Stats
        stat_t = Text(win, width=54, height=13, bd=0, highlightthickness=0)
        stat_t.grid(row=2, column=1)
        stat_t.insert(0.0, stats)
        stat_t.configure(state='disabled')
        # Exit
        done_b = Button(win, text="Done", command=win.destroy)
        done_b.grid(row=3, column=1, pady=8)
        # Give empty row and column weights so they take up empty spaces
        win.grid_rowconfigure(0, weight=1)
        win.grid_rowconfigure(4, weight=1)
        win.grid_columnconfigure(0, weight=1)
        win.grid_columnconfigure(2, weight=1)
    
    # Write to log turn count and units turn, increment turn count afterwards
    def display_turn(self):
        self.turn_count += 1
        write_to_log(self, "Turn {}: {}'s turn".format(self.turn_count, self.curr_turn))