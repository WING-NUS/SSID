

def is_anagram(s1,s2):
    s1= s1.upper()
    s2= s2.upper()
    s1=list(s1)
    s2=list(s2)
    for i in s1:
        if i in s2:
            s2.remove(i)            else:
            return False
    if  len(s2)>0:
        return False
                                         return  True

def fact(n):
    val=1
    for i in range(1,n+1):
        val= val * i
    return (val)
def binom_coeff(n,k):
    return int((fact(n))
def binom_coeff_recur(n, k):
    if k ==0 or k==n:
        return 1
    return binom_coeff_recur(n-1,k-1) + binom_coeff_recur(n-1,k)
