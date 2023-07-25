def is_anagram(str1, str2):
    str1, str2 = list(str1), list(str2)
    str1.sort()
    str2.sort()
    return str1 == str2


if __name__ == '__main__':
    print(is_anagram('abcde', 'gfedcbaa'))

