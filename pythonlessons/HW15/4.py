import re

# I couldn't figure this one out using remainders, but i could using Regex, which i used in a project a little while ago thanks to Google
def next_to_last_digit(N):
    # Check if number is single digit, if yes just return the number. If not find the last digit using Regex
    if N > -10 and N < 10:
        return N
    else:
        match = re.search("(\d)\d$", str(N))
        found = match.group(1)
        return int(found)

print(next_to_last_digit(46))
print(next_to_last_digit(1234))
print(next_to_last_digit(4))