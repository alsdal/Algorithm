import sys
from collections import deque
input = sys.stdin.readline

M, N  = map(int, input().split())

# 3차원 리스트 distance를 이용해 이동 거리와 벽 파괴 가능 여부 저장
graph = [list(map(int,input().rstrip())) for _ in range(M)]
distance = [[[0] * 2 for _ in range(N)] for _ in range(M)]

# 상하좌우 이동벡터
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs():
    queue = deque()
    queue.append([0,0,0])
    while queue:
        y, x, wall = queue.popleft()
        # 도착점에 도달한 경우 이동 거리 출력
        if y == M-1 and x == N-1:
            print(distance[y][x][wall]+1)
            exit(0)
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < M and 0 <= nx < N:
                # 이동할 칸이 벽이고, 아직 벽을 부순 적이 없는 경우
                if graph[ny][nx] == 1 and wall == 0:
                    distance[ny][nx][1] = distance[y][x][0] + 1
                    queue.append([ny, nx, 1])
                # 이동할 칸이 벽이 아닌 경우
                if graph[ny][nx] == 0 and distance[ny][nx][wall] == 0:
                    distance[ny][nx][wall] = distance[y][x][wall] + 1
                    queue.append([ny, nx, wall])

    # 도착점에 도달하지 못한 경우 -1 출력
    print(-1)
bfs()