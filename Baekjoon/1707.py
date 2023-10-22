import sys
from collections import deque
input = sys.stdin.readline


def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start] = 1
    while queue:
        x = queue.popleft()
        for i in graph[x]:
            if visited[i] == 0:
                queue.append(i)
                visited[i] = -1 * visited[x]
            if visited[i] == visited[x]:
                return False
    return True


K = int(input())
for _ in range(K):
    V, E = map(int, input().split())
    graph = [[] for _ in range(V + 1)]
    visited = [0 for _ in range(V + 1)]
    for _ in range(E):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    for i in range(1, V + 1):
        if not visited[i]:
            result = bfs(i)
            if not result:
                break
    print("YES" if result else "NO")
