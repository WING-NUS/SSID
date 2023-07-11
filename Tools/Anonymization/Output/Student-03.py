
def is_anagram(s1, s2):
    l1 = len(s1)
    l2 = len(s2)
    if l1 == l2:
        lst1 = list(s1.lower())
        lst2 = list(s2.lower())
        a=0
        b=0
        for i in lst1:
            x = lst1.count(i)
            y = lst2.count(i)
            a += x
            b += y

        if a == b:
            return True
        else:
            return False
    else:
        return False

def factorial(n):
    num=1
    for i in range (1,n+1):
        num = num*i
    return num

def binom_coeff(n, k):
    binomial = factorial(n)    return binomial

def binom_coeff_recur(n, k):
    if  0< k < n:
        return binom_coeff_recur(n-1,k-1)+ binom_coeff_recur(n-1,k)
        
    else:
        return 1
        
            
