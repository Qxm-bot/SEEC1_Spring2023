"""write your code in following methods"""
file_path = './tasks.txt'
def to_do():
    command = input()
    while command != 'todo -quit':
        if command[5:7] == '-a' and command[7] != 'l':
            command = command[8:]
            command = (command.replace(' "', '')).strip('"')
            token = command.split('"')
            f = open(file_path, 'a')
            for i in range(0, len(token)):
                s = token[i]
                f.write('todo:' + s + '\n')
            f.close()
        elif command[5:7] == '-d':
            command = command[8:]
            command = (command.replace(' "', '')).strip('"')
            token = list(command.split('"'))
            f = open(file_path)
            lines = f.readlines()
            for i in range(0, len(token)):
                for j in range(0, len(lines)):
                    if (lines[j].strip())[-len(token[i]):] == token[i]:
                        del lines[j]
                        break
            f.close()
            f = open(file_path, 'w+')
            f.writelines(lines)
            f.close()
        elif command[5:7] == '-c':
            command = command[8:]
            command = (command.replace('" ', '')).strip('"')
            token = command.split('"')
            f = open(file_path)
            t = f.readlines()
            for i in range(0, len(token)):
                s = token[i]
                for j in range(0, len(t)):
                    if (t[j].strip())[-len(s):] == s:
                        t[j] = 'completed:' + s + '\n'
                        break
            f.close()
            f = open(file_path, 'w')
            f.writelines(t)
        elif command[5:7] == '-f':
            command = command[8:]
            f = open(file_path)
            line = f.readline()
            while len(line) != 0:
                if line[0:len(command)] == command:
                    print(line, end='')
                line = f.readline()
            f.close()
        elif command[5:9] == '-all':
            f = open(file_path)
            line = f.readline()
            while len(line) != 0:
                print(line, end='')
                line = f.readline()
            f.close()
        command = input()
    return
