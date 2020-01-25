import sys

def heapStructure(array, n, i): 
    last = i
    left = 2 * i + 1
    right = 2 * i + 2
  
    if left < n and array[i] < array[left]: 
        last = left 

    if right < n and array[last] < array[right]: 
        last = right 
  
    if last != i: 
        array[i], array[last] = array[last], array[i]
  
        heapStructure(array, n, last)
  
def heapSort(array):
    n = len(array) 
  
    for i in range(n, -1, -1):
        heapStructure(array, n, i)
  
    for i in range(n-1, 0, -1):
        array[i], array[0] = array[0], array[i]
        heapStructure(array, i, 0)

length = int(sys.stdin.readline())
values = [int(s) for s in sys.stdin.readline().split(" ")]

heapSort(values)
for i in range(length):
    print(values[i], end=" ")