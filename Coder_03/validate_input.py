import re

def validate():
    first_name = input('Enter the first name:')
    last_name = input('Enter the last name:')
    ZIP = input("Enter the ZIP code:")
    ID = input('Enter an employee ID:')
    if len(first_name) == 0:
        print('The first name must be filled in.')
    else:
        num = 0
        for i in first_name:
            if i.isalpha():
                num += 1
        if num < 2:
            print('"' + first_name + '"', 'is not a valid first name. It is too short.')
    if len(last_name) == 0:
        print('The last name must be filled in.')
    else:
        num = 0
        for i in last_name:
            if i.isalpha():
                num += 1
        if num < 2:
            print('"' + last_name + '"', 'is not a valid last name. It is too short.')
    if not(ZIP.isdigit()):
        print('The ZIP code must be numeric.')
    if not(len(ID) == 7 and ID[0:2].isupper() and ID[2] == '-' and ID[3:7].isdigit()):
        print(ID, 'is not a valid ID.')

if __name__ == "__main__":
    validate()
