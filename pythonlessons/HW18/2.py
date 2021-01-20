def double_it(string):
    new = ''
    for letter in string:
        new += letter*2
    return new
print(double_it('Hi'))
print(double_it('Python'))