import sys
from collections import deque
input = sys.stdin.readline

def dfs(R):
    visitedDFS[R] = True
    print(R, end=' ')
    graph[R].sort()
    for i in graph[R]:
        if not visitedDFS[i]:
            dfs(i)

def bfs(R):
    queue = deque([R])
    visitedBFS[R] = True
    while queue:
        v = queue.popleft()
        graph[v].sort()
        print(v, end=' ')
        for i in graph[v]:
            if not visitedBFS[i]:
                visitedBFS[i] = True
                queue.append(i)

N, M, V = map(int, input().split())
graph = [[] for _ in range(N + 1)]
visitedDFS = [False] * (N + 1)
visitedBFS = [False] * (N + 1)

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

dfs(V)
print('')
bfs(V)
