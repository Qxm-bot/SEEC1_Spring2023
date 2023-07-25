def flight_calculation():
    string1 = input()
    string2 = input()

    def calculate(string):
        ln = int(len(string))
        if ln == 17:
            t1, t2 = string.split()
            h1, m1, s1 = t1.split(":")
            h2, m2, s2 = t2.split(":")
            h1 = int(h1)
            m1 = int(m1)
            s1 = int(s1)
            h2 = int(h2)
            m2 = int(m2)
            s2 = int(s2)
            time_point1 = h1 * 3600 + m1 * 60 + s1
            time_point2 = h2 * 3600 + m2 * 60 + s2
            time = time_point2 - time_point1
        else:
            t1, t2, sign = string.split()
            h1, m1, s1 = t1.split(":")
            h2, m2, s2 = t2.split(":")
            h1 = int(h1)
            m1 = int(m1)
            s1 = int(s1)
            h2 = int(h2)
            m2 = int(m2)
            s2 = int(s2)
            time_point1 = h1 * 3600 + m1 * 60 + s1
            if sign == "(+1)":
                time_point2 = h2 * 3600 + m2 * 60 + s2 + 3600 * 24
                time = time_point2 - time_point1
            else:
                time_point2 = h2 * 3600 + m2 * 60 + s2 + 3600 * 48
                time = time_point2 - time_point1
        return time

    time1 = calculate(string1)
    time2 = calculate(string2)
    '''
    the time gap is n seconds
    realtime + n = time1
    realtime - n = time2
    realtime = (time1 + time2) // 2
    '''
    realtime = (time1 + time2) // 2
    hh = realtime // 3600
    mm = (realtime - hh * 3600) // 60
    ss = (realtime - hh * 3600 - mm * 60)
    print("%02d:%02d:%02d" % (hh, mm, ss))


flight_calculation()

