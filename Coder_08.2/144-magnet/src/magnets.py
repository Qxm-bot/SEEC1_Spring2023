"""write your code in method solve"""
def solve():
    n = int(input())
    groups = 1
    magnets = input().split()
    for i in range(0, n - 1):
        if magnets[i + 1] != magnets[i]:
            groups += 1
    print(groups)
    return