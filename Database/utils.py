import sqlite3
import os

def open_database(name):
    try:
        conn = sqlite3.connect(name)
    except Exception as e:
        print ("Failed to open database: %s" %e)
        return 1
    return conn

def close_database(conn):
    try:
        conn.commit()
        conn.close()
    except Exception as e:
        print ("Failed to close database: %s" %e)
        return 1
    return 0

def delete_database(name):
    try:
        os.remove(name)
    except Exception as e:
        print ("Failed to delete database: %s" %e)
        return 1
    return 0

def create_table(conn, command):
    try:
        c = conn.cursor()
        c.execute(command)
    except Exception as e:
        print("Failed to create table: %s" %e)
        return 1
    return 0

def insert_entry(conn, table, values):
    try:
        c = conn.cursor()
        count_values(values)
        c.execute('insert into ' + table + ' values ' + count_values(values) , values)
    except Exception as e:
        print ("Failed to insert entry: %s" %e)
        return 1
    return 0

def count_values(values):
    length = len(values)
    fields = '(' + ('?,' * length) + ')'
    fields = fields.replace(',)', ') ')
    return fields

def load_data(conn, table, type):
        path = os.getcwd() + "\\data\\" + table

        with open(path, 'r') as f:
            content = f.readlines()

        content = [x.strip() for x in content]
        id = 0
        for entry in content:
            entry = entry.replace(", ", ",")
            insert_entry(conn, table, [id] + entry.split(',') + [type])
            id+=1


def load_data_no_type(conn, table):
    path = os.getcwd() + "\\data\\" + table

    with open(path, 'r') as f:
        content = f.readlines()

    content = [x.strip() for x in content]
    id = 0
    for entry in content:
        entry = entry.replace(", ", ",")
        insert_entry(conn, table, [id] + entry.split(','))
        id += 1