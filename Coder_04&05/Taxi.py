def solve():
    n = int(input())
    s = list(input().split())
    num = 0
    rec = []
    for i in range(0, n):
        rec.append(0)
        s[i] = int(s[i])

    for i in range(0, n):
        if s[i] == 4:
            num += 1
            rec[i] = 1

    for i in range(0, n):
        if rec[i] != 1 and i != n - 1:
            for j in range(i + 1, n):
                if rec[j] != 1 and s[i] + s[j] == 4:
                    num += 1
                    rec[i] = rec[j] = 1
                    break

    for i in range(0, n):
        sig = 0
        if rec[i] != 1 and i != n - 1:
            for j in range(i + 1, n):
                if rec[j] != 1 and j != n - 1:
                    for k in range(j + 1, n):
                        if rec[k] != 1 and s[i] + s[j] + s[k] == 4:
                            rec[i] = rec[j] = rec[k] = 1
                            num += 1
                            sig = 1
                            break
                    if sig:
                        break

    for i in range(0, n):
        sig = 0
        if rec[i] != 1 and i != n - 1:
            for j in range(i + 1, n):
                if rec[j] != 1 and j != n - 1:
                    for k in range(j + 1, n):
                        if rec[k] != 1 and k != n - 1:
                            for o in range(k + 1, n):
                                if rec[o] != 1 and s[i] + s[j] + s[k] + s[o] == 4:
                                    rec[i] = rec[j] = rec[k] = rec[o] = 1
                                    num += 1
                                    sig = 1
                                    break
                            if sig:
                                break
                    if sig:
                        break

    for i in range(0, n):
        sig = 0
        if rec[i] != 1 and i != n - 1:
            for j in range(i + 1, n):
                if rec[j] != 1 and j != n - 1:
                    for k in range(j + 1, n):
                        if rec[k] != 1 and s[i] + s[j] + s[k] < 4:
                            rec[i] = rec[j] = rec[k] = 1
                            num += 1
                            sig = 1
                            break
                    if sig:
                        break

    for i in range(0, n):
        if rec[i] != 1 and i != n - 1:
            for j in range(i + 1, n):
                if rec[j] != 1 and s[i] + s[j] < 4:
                    num += 1
                    rec[i] = rec[j] = 1
                    break

    for i in range(0, n):
        if rec[i] != 1:
            num += 1
            rec[i] = 1

    print(num)
    return


if __name__ == '__main__':
    solve()
