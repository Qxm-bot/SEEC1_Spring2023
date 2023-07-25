"""write your code in method locate_car_problem"""


def locate_car_problem():
    a1 = input('Is the car silent when you turn the key?')
    if a1 == 'y':
        a2 = input('Are the battery terminals corroded?')
        if a2 == 'y':
            print('Clean terminals and try starting again.')
        else:
            print('Replace cables and try again.')
    else:
        a2 = input('Does the car make a clicking noise?')
        if a2 == 'y':
            print('Replace the battery.')
        else:
            a3 = input('Does the car crank up but fail to start?')
            if a3 == 'y':
                print('Check spark plug connections.')
            else:
                a4 = input('Does the engine start and then die?')
                if a4 == 'y':
                    a5 = input('Does your car have fuel injection?')
                    if a5 == 'y':
                        print('Get it in for service.')
                    else:
                        print('Check to ensure the choke is opening and closing.')
    return
