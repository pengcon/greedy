
class node:
    def __init__(self, freq, symbol, left=None, right=None):
        #빈도
        self.freq = freq
  
        #알파벳 이름
        self.symbol = symbol
  
        #좌측노드
        self.left = left
  
        #우측노드
        self.right = right
        #허프만 코드 
        self.huff = ''
  
  
def output(node, val=''):
    Value = val + str(node.huff)
  
  #엣지 노드가 아닐때까지 재귀
    if(node.left):
        output(node.left, Value)
    if(node.right):
        output(node.right, Value)
    #엣지 노드에 도착하면 허프만 코드를 출력.
    if(not node.left and not node.right):
        print(node.symbol, {Value})
  
  
# 알파벳들
Alpha = ['a','b', 'c','d','e','f' ]

#빈도수
freq = [7,9, 13,15,19,45 ]

#노드를 담을 리스트
nodes = []
  
#알파벳 개수만큼 노드에 빈도수와 알파벳을 담음
for i in range(len(Alpha)):
    nodes.append(node(freq[i], Alpha[i]))
  
#빈도수가 적은 순서대로 정렬
while (len(nodes) > 1):
    nodes = sorted(nodes, key=lambda x: x.freq)
  
#빈도수가 작은 두개의 노드를 고름.
    left = nodes[0]
    right = nodes[1]
#각자의 노드에 허프만 코드를 작성 
    left.huff = 0
    right.huff = 1
#두개의 노드를 합쳐서 새로운 노드로 만듬
    newNode = node(left.freq+right.freq, left.symbol+right.symbol, left, right)

#합친 두개의 노드를 제거하고 새로운 노드를 리스트에 추가
    nodes.remove(left)
    nodes.remove(right)
    nodes.append(newNode)
#허프만 코드 출력
output(nodes[0])    