// Listing 2-31. Using the Find Operator

def winpath=/C:\windows\system32\somedir/
def matcher = winpath =~ /(\w{1}):\\(\w+)\\(\w+)\\(\w+)/
println matcher
println matcher[0] // ["C:\windows\system32\somedir", "C", "windows",
                   // "system32", "somedir"]
println matcher[0][1] // C
def newPath = matcher.replaceFirst('/etc/bin/')
println newPath // /etc/bin