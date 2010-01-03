// Listing 2-21. Passing Multiple Parameters to a Closure

def printClosure = {name1, name2, name3 -> println "Hello, ${name1}, ${name2}, ${name3}" }

printClosure "Chris", "Joseph", "and Jim"