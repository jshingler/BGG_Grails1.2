// Listing 2-36. Using the Elvis Operator

def firstName = user.firstName == null ? "unknown" : user.firstName // Java ternary
def firstName2 = user.firstName ?: "unknown" // Groovy Elvis