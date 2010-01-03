// Listing 2-32. Creating and Using a Pattern

def saying = """Now is the time for all good men (and women) to come to the aid
of their country"""
def pattern = ~/(\w+en)/
def matcher = pattern.matcher(saying)
def count = matcher.getCount()
println "Matches = ${count}"
for(i in 0..<count) {
  println matcher[i]
}