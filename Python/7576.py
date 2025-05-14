import sys
from collections import deque

input = sys.stdin.readline

M, N = map(int, input().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))

dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]
res = 0
queue = deque()

for row in range(N):
    for col in range(M):
        if graph[row][col] == 1:
            queue.append([row, col])

def bfs():
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                queue.append([nx, ny])

bfs()
for row in graph:
    for j in row:
        if j == 0:
            print(-1)
            exit(0)
    res = max(res, max(row))

print(res-1)