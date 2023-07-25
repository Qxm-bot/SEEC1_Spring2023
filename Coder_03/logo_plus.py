def logo_play():
    draw_enable = 1
    draw = ' '
    row = 0
    col = 0
    sig = 0
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

    def drawing(num, dire, r, c):
        for t in range(1, num + 1):
            if dire == 'U':
                r -= 1
            elif dire == 'D':
                r += 1
            elif dire == 'L':
                c -= 1
            elif dire == 'R':
                c += 1
            if r < 0 or r >= 10 or c < 0 or c >= 10:
                return 0
            picture[r][c] = draw
        return 1

    command = input()
    command = list(command.split())
    while command[0] != 'end':
        if command[0] == 'pen_up':
            draw_enable = 0
        elif command[0] == 'pen_down':
            draw_enable = 1
        elif command[0] == 'move':
            direction = command[1]
            num_of_step = int(command[2])
            if draw_enable == 0:
                if direction == 'U':
                    row -= num_of_step
                elif direction == 'D':
                    row += num_of_step
                elif direction == 'L':
                    col -= num_of_step
                elif direction == 'R':
                    col += num_of_step
                if row < 0 or row >= 10 or col < 0 or col >= 10:
                    sig = 1
                    break
            elif draw_enable == 1:
                if len(command) != 3:
                    draw = command[-1]
                if drawing(num_of_step, direction, row, col) == 0:
                    sig = 1
                    break
                else:
                    if direction == 'U':
                        row -= num_of_step
                    elif direction == 'D':
                        row += num_of_step
                    elif direction == 'L':
                        col -= num_of_step
                    elif direction == 'R':
                        col += num_of_step
        elif command[0] == 'cross' and draw_enable == 1:
            num_of_step = int(command[1])
            if len(command) != 2:
                draw = command[-1]
            picture[row][col] = draw
            if drawing(num_of_step, 'U', row, col) == 0:
                sig = 1
                break
            if drawing(num_of_step, 'R', row, col) == 0:
                sig = 1
                break
            if drawing(num_of_step, 'D', row, col) == 0:
                sig = 1
                break
            if drawing(num_of_step, 'L', row, col) == 0:
                sig = 1
                break
        elif command[0] == 'rect_f' and draw_enable == 1:
            if len(command) != 3:
                draw = command[-1]
            sign = 0
            for i in range(0, int(command[2])):
                picture[row + i][col] = draw
                if drawing(int(command[1]) - 1, 'R', row + i, col) == 0:
                    sign = 1
                    break
            if sign == 1:
                sig = 1
                break
        elif command[0] == 'rect' and draw_enable == 1:
            if len(command) != 3:
                draw = command[-1]
            picture[row][col] = draw
            if drawing(int(command[1]) - 1, 'R', row, col) == 0:
                sig = 1
                break
            if drawing(int(command[2]) - 1, 'D', row, col) == 0:
                sig = 1
                break
            if drawing(int(command[1]) - 1, 'R', row + int(command[2]) - 1, col) == 0:
                sig = 1
                break
            if drawing(int(command[2]) - 1, 'D', row, col + int(command[1]) - 1) == 0:
                sig = 1
                break
        command = input()
        command = list(command.split())

    if sig:
        print('Error!')
    else:
        for i in range(0, 10):
            for j in range(0, 10):
                print(picture[i][j], end='')
            print()

    """write your code here :)"""
    return


if __name__ == '__main__':
    logo_play()
