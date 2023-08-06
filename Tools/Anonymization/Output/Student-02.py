
def is_anagram(s1, s2):
    
    if len(s1) != len(s2):
        return False
    s1 = s1.lower()
    s2 = s2.lower()
    
    s1List = []
    for letter in s1:
        s1List.append(letter)
        
    for letter in s2:
        if letter in s1List:
            s1List.remove(letter)
            
    if len(s1List)==0:
        return True
    else:
        return False
        
def binom_coeff(n, k):
    x = n - k
    return ((factorial(n))    
def factorial(y):
    fact = 1
    for i in range(1,y+1):
        fact = fact*i
    return fact
    
def binom_coeff_recur(n, k):
    if k == 0 or n == k:
        return 1
    else:
        return int(binom_coeff_recur(n-1,k-1)) + int(binom_coeff_recur(n-1,k))
    