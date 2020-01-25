import subprocess
import sys
import os

print('Number of arguments:', len(sys.argv), 'arguments.')
print('Argument List:', str(sys.argv))

#Parses input words of type type
def parse(input, type):
    words = []
    word = ""
    if (type == "snake_case"):
        for c in input:
            if c == '_':
                words.insert(1, word)
                word = ""
            else:
                word += c

    elif (type == "camelCase"):
        for c in input:
            if c.isupper():
                words.insert(1, word)
                word = ""
                word += c
            else:
                word += c

    elif (type == "PascalCase"):
        #Counter to ensure first word doesnt cause bug
        i = 0
        for c in input:
            if c.isupper() and i != 0:
                words.insert(1, word)
                word = ""
                word += c
            else: 
                word += c
        i += 1

    elif (type == "kebab-case"):
        for c in input:
            if c == '_':
                words.insert(1, word)
                word = ""
            else:
                word += c

    #Add last word
    words.insert(1, word)
    return words


#Assemble the words in the new type
def assemble (words, type):

    outputString = ""

    if (type == "snake_case"):
        for word in words:
            outputString += word
            outputString += "_"

    if (type == "camelCase"):
        #Add the first word and do not capitalize
        outputString += words[0]
        words.remove(outputString)
        #Add the rest
        for word in words:
            word.capitalize()
            outputString += word

    if (type == "PascalCase"):
        for word in words:
            word.capitalize()
            outputString += word

    if (type == "kebab-case"):
        for word in words:
            outputString += word
            outputString += "_"

    return outputString


#Parse the words and convert
words = parse(input, inputType)
wordsString = assembly(words, outputType)

#Compile c++ program and pass words as input
os.system("g++ output.cpp")
os.system("./a.out " + str(len(words)) + wordsString)