from tempfile import NamedTemporaryFile
import shutil
import csv
import numpy as np

adventure = ''
hp = 54594
mp = 1038
atk = 4873
_def = 5211
spd = 487

hp_1 = int(hp * 0.1)
hp_x = round(np.log(hp * 0.9 / 79), 4)
mp_1 = int(mp / 1000 * 200)
mp_x = round((mp - mp_1) / 79, 2)
atk_1 = int(atk * 0.1)
atk_x = round(np.log(atk * 0.9 / 79), 4)
def_1 = int(_def * 0.1)
def_x = round(np.log(_def * 0.9 / 79), 4)
spd_1 = int(spd * 100 / 480)
spd_x = round((spd - spd_1) / 79, 3)
growths = "[{},{},{},{},{}]".format(hp_x, mp_x, atk_x, def_x, spd_x)

adventures = []

filename = 'data/adventures.csv'
tempfile = NamedTemporaryFile(mode='w', delete=False)

fields = ['ID', 'Name', 'Element', 'Gender', 'Class', 'Weapon', 'Range', 'HP', 'MP', 'Attack', 'Defence', 'Speed', \
    'Skill 1', 'Skill 2', 'Ability 1', 'Ability 2', 'Ability 3', 'Level Up']

with open(filename, 'r') as csvfile, tempfile:
    reader = csv.DictReader(csvfile, fieldnames=fields)
    writer = csv.DictWriter(tempfile, fieldnames=fields)
    for row in reader:
        if row['Name'] == adventure:
            print('Updating row', row['Name'])
            row['HP'] = hp_1
            row['MP'] = mp_1
            row['Attack'] = atk_1
            row['Defence'] = def_1
            row['Speed'] = spd_1
            row['Level Up'] = growths
            print('New row: {}'.format(row))
        # row = {'ID': row['ID'], 'Name': row['Name'], 'Course': row['Course'], 'Year': row['Year']}
        writer.writerow(row)

shutil.move(tempfile.name, filename)