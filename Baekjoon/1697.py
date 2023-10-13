import sys
from collections import deque
input = sys.stdin.readline


def bfs():
    queue = deque()
    queue.append(N)
    while queue:
        x = queue.popleft()
        if x == K:
            print(sec[x])
            break
        for nx in (x-1, x+1, x*2):
            if 0 <= nx <= MAX and not sec[nx]:
                sec[nx] = sec[x] + 1
                queue.append(nx)


N, K = map(int, input().split())
MAX = 10 ** 5
sec = [0] * (MAX+1)
bfs()