
class node:
    def __init__(self, freq, symbol, left=None, right=None):
       
        self.freq = freq
  
        
        self.symbol = symbol
  
        
        self.left = left
  
        
        self.right = right
  
        self.huff = ''
  
  
def output(node, val=''):
    Value = val + str(node.huff)
  
    if(node.left):
        output(node.left, Value)
    if(node.right):
        output(node.right, Value)
    if(not node.left and not node.right):
        print(node.symbol, {Value})
  
  

Alpha = ['a','b', 'c','d','e','f' ]


freq = [45,13,12,16,9,5 ]

nodes = []
  
for i in range(len(Alpha)):
    nodes.append(node(freq[i], Alpha[i]))
  
while (len(nodes) > 1):
    nodes = sorted(nodes, key=lambda x: x.freq)
  
    left = nodes[0]
    right = nodes[1]
  
    left.huff = 0
    right.huff = 1
  
    newNode = node(left.freq+right.freq, left.symbol+right.symbol, left, right)
  
    nodes.remove(left)
    nodes.remove(right)
    nodes.append(newNode)

output(nodes[0])    