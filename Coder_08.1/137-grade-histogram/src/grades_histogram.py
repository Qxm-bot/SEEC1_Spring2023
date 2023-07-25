"""write your code in method"""

def histogram(fileName):
    f = open(fileName)
    num = int(f.readline())
    grades = f.readline().strip().split()
    f.close()
    record = [0] * 10
    for i in grades:
        if int(i) != 100:
            record[int(i) // 10] += 1
        else:
            record[9] += 1
    for i in range(0, 10):
        print(record[i], end='')
        if i != 9:
            print(',', end='')
        else:
            print()
    j = 0
    while j <= 90:
        if j < 90:
            print("%2d -%3d:" % (j, j+9), end='')
        else:
            print('90 -100:', end='')
        k = 1
        while k <= record[j // 10]:
            print('*', end='')
            k += 1
        print()
        j += 10

    return