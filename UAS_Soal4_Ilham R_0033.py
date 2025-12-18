def maximum (listNum):
    return max(listNum)

def minimum (listNum):
    return min(listNum)

def average (listNum):
    return (sum(listNum)/ len(listNum))

def odd (listNum):
    return list(filter(lambda x: x%2 != 0, listNum))

def even (listNum):
    return list(filter(lambda x: x%2 == 0, listNum))

def uniqueNum (listNum):
    unique = []

    for i in listNum:
        if listNum.count(i) == 1:
            unique.append(i)

    return unique

angka = [12, 7, 45, 7, 20, 33, 12, 50, 9, 20]
print(maximum(angka))
print(minimum(angka))
print(average(angka))
print(odd(angka))
print(even(angka))
print(uniqueNum(angka))

