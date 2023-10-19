import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
ladder = [list(map(int,input().split())) for _ in range(N)]
snake = [list(map(int,input().split())) for _ in range(M)]
graph = [0] * 101
def bfs():
    queue = deque()
    queue.append(1)
    while queue:
        x = queue.popleft()
        if x == 100:
            break
        for i in range(1,7):
            nx = x + i
            for i in range(N):
                if nx == ladder[i][0]:
                    nx = ladder[i][1]
            for i in range(M):
                if nx == snake[i][0]:
                    nx = snake[i][1]
            if nx <= 100 and not graph[nx]:
                queue.append(nx)
                graph[nx] = graph[x] + 1
bfs()
print(graph[100])
