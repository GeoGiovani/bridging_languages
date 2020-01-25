#!/usr/bin/python
import sys, re

args = sys.argv
case_name = args[args.index("-case")+1]

f = sys.stdin.readline().rstrip()
new = []

# PascalCase and camelCase
for char in f:
    if char.isupper():
        new.append(" ")
        new.append(char.lower())
    else:
        new.append(char)

f = ''.join(new).strip(" ")    

# kebab and snake case
if "_" in f:
    f = f.replace("_", " ").lower()
elif "-" in f:
    f = f.replace("-", " ").lower()
