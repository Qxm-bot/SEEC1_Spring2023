if __name__ == '__main__':
    x = input().split()
    lst = []
    _len = 0
    for i in x:
        lst.append(int(i))
        _len += 1
    maximum = lst[_len - 1] - lst[_len - 2]
    j = _len - 1
    while j > 0:
        i = j - 1
        while i >= 0:
            if lst[j] - lst[i] > maximum:
                maximum = lst[j] - lst[i]
            i -= 1
        j -= 1
    if maximum <= 0:
        print("-1", end="")
    else:
        print("%d" % maximum, end="")
