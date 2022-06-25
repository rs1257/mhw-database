# Table Names
MONSTER_LIST_TABLE = 'monsters_list'
WEAPON_TYPE_TABLE = 'weapon_type'
LOCATION_LIST_TABLE = 'location_list'
SKILLS_LIST_TABLE = 'skills_list'
DECORATION_LIST_TABLE = "decoration_list"
QUEST_LIST_TABLE = "quest_list"
CHARM_LIST_TABLE = "charm_list"
ITEM_LIST_TABLE = "item_list"
ARMOR_LIST_TABLE = "armor_list"
TOOLS_LIST_TABLE = "tools_list"
LIFE_LIST_TABLE = "life_list"
PALICO_GADGET_LIST = "palico_gadget_list"
PALICO_WEAPON_LIST = "palico_weapon_list"
PALICO_ARMOR_LIST = "palico_armor_list"
COMBINATION_LIST = "combination_list"
ACHIEVEMENTS_LIST = "achievements_list"
FOOD_SKILLS_LIST = "food_skills_list"
FOOD_INGREDIENTS_LIST = "food_ingredients_list"


# Table Fields
CREATE_MONSTER_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, size integer, species text, type text)' % MONSTER_LIST_TABLE
CREATE_WEAPON_TYPE_TABLE = 'CREATE TABLE %s (_id integer primary key, name text)' % WEAPON_TYPE_TABLE
CREATE_LOCATION_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, type text)' % LOCATION_LIST_TABLE
CREATE_SKILLS_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, colour text, type text)' % SKILLS_LIST_TABLE
CREATE_DECORATION_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, colour text, type text)' % DECORATION_LIST_TABLE
CREATE_QUEST_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, stars integer, questType text, type text)' % QUEST_LIST_TABLE
CREATE_CHARM_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, rarity integer, type text)' % CHARM_LIST_TABLE
CREATE_ITEM_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, type text)' % ITEM_LIST_TABLE
CREATE_ARMOR_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, rank text, rarity integer, position integer, type text)' % ARMOR_LIST_TABLE
CREATE_TOOLS_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, type text)' % TOOLS_LIST_TABLE
CREATE_LIFE_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, species text, type text)' % LIFE_LIST_TABLE
CREATE_PALICO_GADGET_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, description text, obtain text, type text)' % PALICO_GADGET_LIST
CREATE_PALICO_WEAPON_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, type text)' % PALICO_WEAPON_LIST
CREATE_PALICO_ARMOR_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, armorType text, type text)' % PALICO_ARMOR_LIST
CREATE_COMBINATION_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, result text, item1 text, item2 text, type text)' % COMBINATION_LIST
CREATE_ACHIEVEMENTS_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, description text, type text)' % ACHIEVEMENTS_LIST
CREATE_FOOD_SKILLS_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, type text)' % FOOD_SKILLS_LIST
CREATE_FOOD_INGREDIENTS_LIST_TABLE = 'CREATE TABLE %s (_id integer primary key, name text, foodSubType text, foodType text, type text)' % FOOD_INGREDIENTS_LIST