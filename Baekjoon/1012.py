import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
def bfs(i,j):
    queue = deque()
    queue.append((i,j))
    while queue:
        x, y = queue.popleft()
        graph[x][y] = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= M or ny < 0 or ny >= N:
                continue
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1:
                queue.append((nx, ny))
                graph[nx][ny] = 0


T = int(input())
for _ in range(T):
    cnt = 0
    N, M, K = map(int, input().split())
    graph = [[0 for _ in range(N)] for _ in range(M)]
    for i in range(K):
        x, y = map(int, input().split())
        graph[y][x] = 1

    for i in range(M):
        for j in range(N):
            if graph[i][j] == 1:
                bfs(i,j)
                cnt += 1
    print(cnt)


