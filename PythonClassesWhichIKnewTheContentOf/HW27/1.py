def swap(L, i, j):
  tmp = L[i]
  L[i] = L[j]
  L[j] = tmp
  return L



def insert_sort(L):
  for i in range(1,len(L)):
    j = i
    while j>0 and L[j] < L[j-1]:
      swap(L,j,j-1)
      j -= 1
  return L

L = ["zigzag","fit","cat","a","outstanding","we"]

print(insert_sort(L))
# sorts alphabetically because you can compare which letter comes before another using < or >

def insert_sort_by_length(L):
  for i in range(1,len(L)):
    j = i
    while j>0 and len(L[j]) < len(L[j-1]):
      swap(L,j,j-1)
      j -= 1
  return L

print(insert_sort_by_length(L))