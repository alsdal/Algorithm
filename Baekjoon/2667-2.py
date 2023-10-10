import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
graph = []
houseList = []
for i in range(N):
    graph.append(list(map(int, input().rstrip())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
    house = 1
    queue = deque()
    queue.append([x, y])
    while queue:
        x, y = queue.popleft()
        graph[x][y] = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append([nx, ny])
                house += 1
    return house


for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            houseList.append(bfs(i, j))

print(len(houseList))
houseList.sort()
for i in houseList:
    print(i)
