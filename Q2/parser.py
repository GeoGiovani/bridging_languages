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
                words.insert(word)
                word = ""
                word += c
            else:
                word += c

    elif (type == "PascalCase"):
        #Counter to ensure first word doesnt cause bug
        i = 0
        for c in input:
            if c.isupper() and i != 0:
                words.insert(word)
                word = ""
                word += c
            else: 
                word += c
        i += 1

    elif (type == "kebab-case"):
        for c in input:
            if c == '_':
                words.insert(word)
                word = ""
            else:
                word += c

    #Add last word
    words.insert(word)
    return words