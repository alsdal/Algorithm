import sys
import heapq
input = sys.stdin.readline

h = []
N = int(input())

for _ in range(N):
    x = int(input())
    if x != 0:
        heapq.heappush(h, x)
    elif x == 0:
        if h:
            print(heapq.heappop(h))
        if not h:
            print('0')
