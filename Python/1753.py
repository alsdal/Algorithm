import heapq
import sys
input = sys.stdin.readline
INF = int(300000 * 10)

V, E = map(int, input().split())
graph = [[] for _ in range(V + 1)]
start = int(input())
for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((w, v))

visited = [False] * (V + 1)
distance = [INF] * (V + 1)

def dijkstra(start):
    # 시작 노드 초기화
    q = []
    # 우선순위 큐에 튜플로 (거리, 노드번호)를 삽입
    heapq.heappush(q, (0,start))
    distance[start] = 0
    # 시작 노드와 연결 되어 있는 노드 사이의 거리 저장
    while q:
        # 최소 힙을 사용하여 거리가 작은 순서로 꺼냄
        dist, index = heapq.heappop(q)
        # dist의 값이 저장되어 있는 최단거리 보다 크다면 무시
        if distance[index] < dist:
            continue
        # 현재 노드와 연결된 노드에 대한 거리 확인
        for i in graph[index]:
            cost = dist + i[0]
            # 현재 노드를 거쳐 가는 거리가 짧을 경우 갱신, 우선순위 큐에 삽입
            if cost < distance[i[1]]:
                distance[i[1]] = cost
                heapq.heappush(q, (cost, i[1]))


dijkstra(start)

for i in range(1, V + 1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
