matrix = [[1,2,3],[4,5,6],[7,8,9]]
data = [1,2,3,4,5,[6,7]]
# print(matrix)
# print(*matrix[::-1])
# a = zip(*data[::-1])

res, lo = [[3*3]], 3*3 
while lo > 1:

    lo, hi = lo - len(res), lo
    # print('res:', res)
    res = [[i for i in range(lo, hi)]] + [list(j) for j in zip(*res[::-1])]
    # print(res,*zip(*res[::-1]))
    print(res)
    print(res[::-1])


# print([*zip(*matrix)])