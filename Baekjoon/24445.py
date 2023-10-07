import sys
from collections import deque
input = sys.stdin.readline
sys.setrecursionlimit(200000)

def bfs(R):
    global cnt
    queue = deque([R])
    visited[R] = 1
    while queue:
        v = queue.popleft()
        graph[v].sort(reverse=True)
        for i in graph[v]:
            if visited[i] == 0:
                cnt += 1
                visited[i] = cnt
                queue.append(i)

N, M, R = map(int, input().split())
graph = [[] for _ in range(N + 1)]
visited = [0] * (N + 1)
cnt = 1

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
bfs(R)
for i in visited[1:]:
    print(i)
