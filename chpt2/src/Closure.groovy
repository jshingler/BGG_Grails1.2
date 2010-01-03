// Listing 2-19. Using a Closure

def name = "Chris"
def printClosure = { println "Hello, ${name}" }
printClosure()
name = "Joseph"
printClosure()