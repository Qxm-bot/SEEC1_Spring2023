from datetime import datetime
def calculate():
    age_now = int(input('What is your current age?'))
    age_retire = int(input('At what age would you like to retire?'))
    current_year = int((datetime.now()).year)
    if age_now <= age_retire:
        print('You have', (age_retire - age_now), 'years left until you can retire.')
        print('It\'s ' + str(current_year) + ',' + ' so you can retire in ' + str(current_year + age_retire - age_now) + '.')
    else:
        print('You have 0 years left until you can retire.')
        print('It\'s ' + str(current_year) + ',' + ' so you can retire in ' + str(current_year + age_retire - age_now) + '.')

if __name__ == "__main__":
    calculate()