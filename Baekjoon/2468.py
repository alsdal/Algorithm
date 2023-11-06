import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
graph = []
cntMax = 0

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

for _ in range(N):
    graph.append(list(map(int, input().split())))


def bfs(y, x, h):
    queue = deque()
    queue.append([y, x])
    visited[y][x] = 1
    while queue:
        y, x = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= ny < N and 0 <= nx < N:
                # 높이(h)보다 크고 방문하지 않았다면
                if graph[ny][nx] > h and visited[ny][nx] == 0:
                    queue.append([ny, nx])
                    visited[ny][nx] = 1


# 2차원 배열의 최댓값(지역의 최대 높이) 구해서 반복
for h in range(max(map(max, graph))):
    cnt = 0  # 안전 영역 개수
    visited = [[0] * N for _ in range(N)]
    # 높이(h)를 1씩 증가시키며 각각 BFS 그래프 탐색
    for i in range(N):
        for j in range(N):
            # 높이(h)보다 크고 방문하지 않았다면 BFS 수행, 카운트 횟수 증가
            if graph[i][j] > h and visited[i][j] == 0:
                bfs(i, j, h)
                cnt += 1
    # 안전 영역 개수의 최대값 갱신해서 저장
    cntMax = max(cntMax, cnt)
print(cntMax)
