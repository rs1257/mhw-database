import sqlite3
from utils import *
from globals import *
import shutil
import os

DATABASE_LOCATION = os.getcwd()
DATABASE_NAME = 'MHWORLD.db'
DATABASE = DATABASE_LOCATION + "\\" + DATABASE_NAME

def generate_database():
    try:
        conn = open_database(DATABASE)

        create_tables(conn)
        load_all_data(conn)

        close_database(conn)

    except Exception as e:
        print("Error in main: %s" % e)
        return 1

    return 0


def create_tables(conn):
    # Create tables
    create_table(conn, CREATE_MONSTER_LIST_TABLE)
    create_table(conn, CREATE_WEAPON_TYPE_TABLE)
    create_table(conn, CREATE_LOCATION_LIST_TABLE)
    create_table(conn, CREATE_SKILLS_LIST_TABLE)
    create_table(conn, CREATE_DECORATION_LIST_TABLE)
    create_table(conn, CREATE_ARMOR_LIST_TABLE)
    create_table(conn, CREATE_CHARM_LIST_TABLE)
    create_table(conn, CREATE_ITEM_LIST_TABLE)
    create_table(conn, CREATE_LIFE_LIST_TABLE)
    create_table(conn, CREATE_QUEST_LIST_TABLE)
    create_table(conn, CREATE_TOOLS_LIST_TABLE)

    create_table(conn, CREATE_PALICO_GADGET_LIST_TABLE)
    create_table(conn, CREATE_PALICO_WEAPON_LIST_TABLE)
    create_table(conn, CREATE_PALICO_ARMOR_LIST_TABLE)
    create_table(conn, CREATE_COMBINATION_LIST_TABLE)
    create_table(conn, CREATE_ACHIEVEMENTS_LIST_TABLE)
    create_table(conn, CREATE_FOOD_SKILLS_LIST_TABLE)
    create_table(conn, CREATE_FOOD_INGREDIENTS_LIST_TABLE)


def load_all_data(conn):
    # Populate data entries
    load_data(conn, MONSTER_LIST_TABLE, "Monster")
    load_data_no_type(conn, WEAPON_TYPE_TABLE)
    load_data(conn, LOCATION_LIST_TABLE, "Location")
    load_data(conn, SKILLS_LIST_TABLE, "Skill")
    load_data(conn, DECORATION_LIST_TABLE, "Decoration")
    load_data(conn, ARMOR_LIST_TABLE, "Armor")
    load_data(conn, CHARM_LIST_TABLE, "Charm")
    load_data(conn, ITEM_LIST_TABLE, "Item")
    load_data(conn, LIFE_LIST_TABLE, "Endemic Life")
    load_data(conn, QUEST_LIST_TABLE, "Quest")
    load_data(conn, TOOLS_LIST_TABLE, "Hunter Tool")
    load_data(conn, PALICO_GADGET_LIST, "Palico")
    load_data(conn, PALICO_WEAPON_LIST, "Palico")
    load_data(conn, PALICO_ARMOR_LIST, "Palico")
    load_data(conn, COMBINATION_LIST, "Combination")
    load_data(conn, ACHIEVEMENTS_LIST, "Achievement")
    load_data(conn, FOOD_SKILLS_LIST, "Food")
    load_data(conn, FOOD_INGREDIENTS_LIST, "Food")


if __name__ == '__main__':
    print("Creating Database")
    generate_database()
    current_path = os.getcwd()
    des = current_path + "/../app/src/main/assets/databases/MHWORLD.db"
    src = current_path + "/MHWORLD.db"
    print("Copying Database to Assets Folder")
    shutil.move(src, des)