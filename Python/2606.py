import sys
input = sys.stdin.readline

C = int(input())
V = int(input())
graph = [[] for _ in range(C + 1)]
visited = [0] * (C + 1)

for i in range(V):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def dfs(v):
    visited[v] = 1
    for i in graph[v]:
        if visited[i] == 0:
            dfs(i)
    return sum(visited) - 1


print(dfs(1))
