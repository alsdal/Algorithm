import sys
from collections import deque

input = sys.stdin.readline

M, N, H = map(int, input().split())
graph = [[(list(map(int, input().split()))) for _ in range(N)] for _ in range(H)]

dx = [-1, 0, 1, 0, 0, 0]
dy = [0, -1, 0, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

maxZ = 0
res = 0
queue = deque()
for height in range(H):
    for row in range(N):
        for col in range(M):
            if graph[height][row][col] == 1:
                queue.append([height, row, col])

def bfs():
    while queue:
        z, y, x = queue.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if 0 <= nx < M and 0 <= ny < N and 0 <= nz < H and graph[nz][ny][nx] == 0:
                graph[nz][ny][nx] = graph[z][y][x] + 1
                queue.append([nz, ny, nx])

bfs()
for height in graph:
    for row in height:
        for col in row:
            if col == 0:
                print(-1)
                exit(0)
        maxZ = max(maxZ, max(row))
    res = max(res, maxZ)
print(res-1)