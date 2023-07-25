"""write your code in method solve"""
def solve():
    n = int(input())
    times = input().strip().split()
    times = [int(s) for s in times]
    total = sum(times)
    add = 0
    idx = 0
    for i in range(0, n):
        if add <= total // 2 <= add + times[i]:
            idx = i
            break
        else:
            add += times[i]
    if 2 * add + times[idx] == total or add < total - add - times[idx]:
        print(idx + 1, n - idx - 1)
    else:
        print(idx, n - idx)
    return