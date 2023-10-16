import sys
from collections import deque
input = sys.stdin.readline

dx = [1, 2, 2, 1, -1, -2, -2, -1]
dy = [-2, -1, 1, 2, 2, 1, -1, -2]


def bfs(ix, iy, tx, ty):
    queue = deque()
    queue.append((ix, iy))
    while queue:
        x, y = queue.popleft()
        if x == tx and y == ty:
            print(graph[x][y])
            break
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < L and 0 <= ny < L and not graph[nx][ny]:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))


T = int(input())
for i in range(T):
    L = int(input())
    graph = [[0 for _ in range(L)] for _ in range(L)]
    ix, iy = map(int, input().split())
    tx, ty = map(int, input().split())
    bfs(ix, iy, tx, ty)
