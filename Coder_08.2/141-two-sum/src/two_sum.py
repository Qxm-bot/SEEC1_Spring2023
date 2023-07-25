"""write your code in method"""

def twoSum(nums, target):
    len_nums = len(nums)
    m, n = 0, 0
    for i in range(0, len_nums - 1):
        sign = 0
        for j in range(i + 1, len_nums):
            if nums[i] + nums[j] == target:
                sign = 1
                m, n = i, j
                break
        if sign:
            break

    return [m, n]
