import sys

input = sys.stdin.readline

N = int(input())
graph = []
houseList = []
house = 0

for i in range(N):
    graph.append(list(map(int, input().rstrip())))


def dfs(x, y):
    global house
    if x <= -1 or x >= N or y <= -1 or y >= N:
        return False
    if graph[x][y] == 1:
        graph[x][y] = 0
        dfs(x, y - 1)
        dfs(x - 1, y)
        dfs(x, y + 1)
        dfs(x + 1, y)
        house += 1
        return True
    return False


for i in range(N):
    for j in range(N):
        if dfs(i, j) == True:
            houseList.append(house)
            house = 0

print(len(houseList))
houseList.sort()
for i in houseList:
    print(i)