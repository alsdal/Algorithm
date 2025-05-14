import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
visited = [False] * (N+1)
cnt = 0

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start] = True
    while queue:
        x = queue.popleft()
        for i in graph[x]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

for i in range(1,N+1):
    if not visited[i]:
        bfs(i)
        cnt += 1

print(cnt)