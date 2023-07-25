def process(param):
    rstr = ''
    rlist = []
    for s in param:
        if len(s) != 1:
            rlist.append(s.title())
    for s in rlist:
        if s != rlist[-1]:
            rstr = rstr + s + ','
        else:
            rstr = rstr + s
    return rstr


if __name__ == '__main__':
    print(process(['neal', 's', 'stu', 'j', 'rich', 'bob']))


