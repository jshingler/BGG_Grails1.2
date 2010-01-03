// Listing 2-23. Passing a Closure As a Parameter

def list = ["Chris", "Joseph", "Jim"]
def sayHello = { println it }
list.each(sayHello)