def parse(input, type):
    words = []
    word = ""
    if (type == "snake_case"):
        for c in input:
            if c == '_':
                words.insert(word)
                word = ""
            else:
                word += c

    elif (type == "camelCase"):
        for c in input:
            if c.isupper():
                word += c
                words.inser(word)
            else:
                word += c

    elif (type == "PascalCase"):
        

    elif (type == "kebab-case"):

    return words
    