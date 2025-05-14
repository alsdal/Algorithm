import sys

input = sys.stdin.readline
INF = int(300000 * 10)

V, E = map(int, input().split())
graph = [[] for _ in range(V + 1)]
start = int(input())
for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

visited = [False] * (V + 1)
distance = [INF] * (V + 1)


def dijkstra(start):
    # 시작 노드 초기화
    distance[start] = 0
    visited[start] = True
    # 시작 노드와 연결 되어 있는 노드 사이의 거리 저장
    for i in graph[start]:
        distance[i[0]] = i[1]
    # 나머지 노드의 수만큼 반복
    for i in range(V - 1):
        min_value = INF
        index = 0
        # 거리가 가장 가까운 노드부터 방문하지 않은 노드에 대해서 최단 거리가 작은 노드의 인덱스 반환
        for i in range(1, V + 1):
            if distance[i] < min_value and not visited[i]:
                min_value = distance[i]
                index = i
        visited[index] = True
        # 현재 노드와 연결된 노드에 대한 거리 확인
        for j in graph[index]:
            cost = distance[index] + j[1]
            # 현재 노드를 거쳐 가는 거리가 짧을 경우 갱신
            if cost < distance[j[0]]:
                distance[j[0]] = cost


dijkstra(start)

for i in range(1, V + 1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
