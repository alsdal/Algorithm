import sys
from collections import deque
input = sys.stdin.readline


def bfs(start):
    queue = deque()
    queue.append(start)
    # visited 리스트의 첫 노드값을 1로 설정
    visited[start] = 1
    while queue:
        x = queue.popleft()
        for i in graph[x]:
            # 인접한 노드는 처음 방문할 때 이전 노드와 달라지도록 -1을 곱함
            if visited[i] == 0:
                queue.append(i)
                visited[i] = -1 * visited[x]
            # 인접한 노드의 값이 같다면 False 리턴
            if visited[i] == visited[x]:
                return False
    # 모든 노드의 인접한 값이 다르다면 True 리턴
    return True


K = int(input())
for _ in range(K):
    V, E = map(int, input().split())
    graph = [[] for _ in range(V + 1)]
    visited = [0 for _ in range(V + 1)]
    # 그래프 리스트에 각 정점과 간선 연결
    for _ in range(E):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
        # 모든 정점이 이어져 있지 않은 경우 고려해서 각 노드마다 BFS 실행
    for i in range(1, V + 1):
        if not visited[i]:
            result = bfs(i)
            if not result:
                break
    print("YES" if result else "NO")
