import sys
input = sys.stdin.readline
sys.setrecursionlimit(200000)

def dfs(R):
    global cnt
    visited[R] += cnt
    graph[R].sort(reverse=True)
    for x in graph[R]:
        if visited[x] == 0:
            cnt += 1
            dfs(x)

N, M, R = map(int, input().split())
graph = [[] for _ in range(N + 1)]
visited = [0] * (N + 1)
cnt = 1

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

dfs(R)
for i in range(1, N + 1):
    print(visited[i])
