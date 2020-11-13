def find_primes(amount: int):
  current_checking = 2
  while amount > 0:
    not_prime = False
    for i in range(2, current_checking-1):
      if (current_checking % i == 0):
        not_prime = True
    if (not not_prime):
      amount -= 1
      print(current_checking)
    current_checking += 1

find_primes(100000)