def formatting(s, k):
    lst = s.upper().split('-')
    s = ''.join(lst)
    s = s[::-1]
    formatted = []
    len_s = len(s)
    index = 0
    while index < len_s:
        count = 0
        while count < k and index < len_s:
            formatted.append(s[index])
            count += 1
            index += 1
        if index != len_s:
            formatted.append('-')
    formatted.reverse()
    formatted_str = ''.join(formatted)
    return formatted_str