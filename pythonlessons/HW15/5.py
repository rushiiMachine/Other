def valid_triangle(s1,s2,s3):
    if s1+s2>s3 and s1+s3>s2 and s2+s3>s1:
        return True
    else:
        return False

print(valid_triangle(3,4,5))
print(valid_triangle(6,1,3))