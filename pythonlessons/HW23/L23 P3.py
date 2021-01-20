og_list = [12, 337, -7, 66, 237.3, 124, 71]

def has_digit_7(n):
  return "7" in str(n)

print(list(filter(has_digit_7,og_list)))