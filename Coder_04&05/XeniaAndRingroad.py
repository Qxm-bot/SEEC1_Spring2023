def solve():
    n, m = input().split()
    n, m = int(n), int(m)
    a = input().split()
    time = 0
    for i in range(0, m):
        if i == 0:
            time += int(a[i]) - 1
        elif int(a[i]) >= int(a[i - 1]):
            time += int(a[i]) - int(a[i - 1])
        else:
            time += n + int(a[i]) - int(a[i - 1])
    print(time, end='')


if __name__ == '__main__':
    solve()



