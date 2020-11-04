def get_initials(name):
    parts = name.split(" ")
    initials = ""
    for part in parts:
        initials += part[0]
    return initials.upper()

print(get_initials("Sue anabelle Black"))
print(get_initials("Joe White"))

names = ["Sue anabelle Black", "Joe White", "Anny", "Samuel Joe Fisher"]
print(list(map(get_initials, names)))