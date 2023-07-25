def special_typing():
    q = int(input())
    for i in range(1, q + 1):
        s = input()
        t = input()
        len_s, len_t = len(s), len(t)
        i, j = len_s - 1, len_t - 1
        check = 1
        while j >= 0:
            if i < 0:
                check = 0
                break
            if s[i] == t[j]:
                i -= 1
                j -= 1
            else:
                i -= 2
        if check:
            print('YES')
        else:
            print('NO')


if __name__ == '__main__':
    special_typing()
