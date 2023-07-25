def isPetyaLanguage():
    def judge_the_gender(single_token):
        if single_token[-4:] == 'lios' or single_token[-3:] == 'etr' or single_token[-6:] == 'initis':
            return 'm'
        elif single_token[-5:] == 'liala' or single_token[-4:] == 'etra' or single_token[-6:] == 'inites':
            return 'f'
        else:
            return 'n'

    def isMasculine(whole_token):
        for j in whole_token:
            if judge_the_gender(j) != 'm':
                return False
        return True

    def isFeminine(whole_token):
        for j in whole_token:
            if judge_the_gender(j) != 'f':
                return False
        return True

    token = list(input().split())
    if not(isFeminine(token) or isMasculine(token)):
        print('NO')
    else:
        assign = []
        if isFeminine(token):
            for i in token:
                if i[-5:] == 'liala':
                    assign.append(0)
                elif i[-4:] == 'etra':
                    assign.append(1)
                elif i[-6:] == 'inites':
                    assign.append(2)
        elif isMasculine(token):
            for i in token:
                if i[-4:] == 'lios':
                    assign.append(0)
                elif i[-3:] == 'etr':
                    assign.append(1)
                elif i[-6:] == 'initis':
                    assign.append(2)
        is_yes = True
        sign = False
        if len(assign) == 1:
            print('YES')
        if len(assign) > 1:
            if assign[0] == 1:
                sign = True
            for i in range(1, len(assign)):
                if assign[i] == 1:
                    sign = True
                    if assign[i - 1] == 1:
                        is_yes = False
                        print('NO')
                        break
                if assign[i] < assign[i - 1]:
                    is_yes = False
                    print('NO')
                    break
            if is_yes and sign:
                print('YES')
            elif is_yes and (not sign):
                print('NO')

    return

