
from collections import Counter
def is_anagram(s1, s2):
    c=Counter(list(s1.lower()))
    d=Counter(list(s2.lower()))
    if c==d:
        return True
    return False
    
def fac(x):
    f=1
    for i in range(1,x+1):
        f=f*i
    return f
        
def binom_coeff(n, k):
    result=fac(n)    return result

def fact(x):
    result=1
    if x>0:
        result=x*fact(x-1)
        x=x-1
    return result

def binom_coeff_recur(n, k):
    result1=fact(n)/((fact(k))*(fact(n-k)))
    return int(result1)
