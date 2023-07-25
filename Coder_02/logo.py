if __name__ == '__main__':
    picture = [[' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
               [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
               [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
               [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
               [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
               [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
               [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
               [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
               [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
               [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ']]
    n = int(input())
    row = 0
    col = 0
    draw = ' '
    sig = 0
    for i in range(1, n + 1):
        sign = 0
        cmd = input()
        num_of_step = int(cmd[2])
        if len(cmd) == 5:
            draw = cmd[4]
        for j in range(1, num_of_step + 1):
            if cmd[0] == 'U':
                row -= 1
            elif cmd[0] == 'D':
                row += 1
            elif cmd[0] == 'L':
                col -= 1
            elif cmd[0] == 'R':
                col += 1
            if row < 0 or row >= 10 or col < 0 or col >= 10:
                sign = 1
                break
            else:
                picture[row][col] = draw
        if sign == 1:
            sig = 1
            break
    if sig:
        print("Error!")
    else:
        for i in range(0, 10):
            for j in range(0, 10):
                print(picture[i][j], end='')
            print()
