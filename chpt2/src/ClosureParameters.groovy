// Listing 2-20. Passing Parameters to Closures

def printClosure = {name -> println "Hello, ${name}" }
printClosure("Chris")
printClosure("Joseph")
printClosure "Jim"