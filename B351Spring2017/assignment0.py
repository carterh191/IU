sumMultiples = 0
for i in range(1000):
       if (i % 3 == 0 or i % 5 == 0):
           sumMultiples = sumMultiples + i
print (sumMultiples)  



def fib(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fib(n-1) + fib(n-2)
    
def fib_iterative(n):
    a, b = 0, 1
    while n > 0:
        a, b = b, a + b
        n -= 1
    return a
