import csv
def getcommand(file):
    n = int(input())
    for i in range(1, n + 1):
        cmd = input()
        if cmd == 'SHOWALL':
            f = open(file)
            lNameMax = 0
            lTitleMax = 0
            lSalaryMax = 0
            rcd = []
            total = 0.0
            while True:
                line = f.readline()
                if len(line) == 0:
                    break
                items = line.strip().split(',')
                if len(items[0]) > lNameMax:
                    lNameMax = len(items[0])
                if len(items[1]) > lTitleMax:
                    lTitleMax = len(items[1])
                salary = float(items[2])
                rcd.append(salary)
                total += salary
            AVG = total / len(rcd)
            rcd.sort()
            f.close()

            print('Name'.ljust(lNameMax), 'Title'.ljust(lTitleMax), 'Salary')
            for j in range(0, len(rcd)):
                f = open(file)
                items = f.readline().strip().split(',')
                while float(items[-1]) != rcd[j]:
                    items = f.readline().strip().split(',')
                print(items[0].ljust(lNameMax), items[1].ljust(lTitleMax), '{:.2f}'.format(rcd[j]))
                f.close()
            print('AVG:{:.2f}'.format(AVG))
        else:
            add = (list(cmd.strip().split()))[1]
            f = open(file, mode='a')
            f.write('\n' + add)
