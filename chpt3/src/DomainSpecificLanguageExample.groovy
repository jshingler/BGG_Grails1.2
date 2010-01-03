/*
 * Example of creating a DSL for working with files.
 */

String.metaClass.contents = {
  this.class.getResourceAsStream(delegate).getText()
}

def write = { file ->
  println file               
}

// DSL for working with files.

write 'readme.txt'.contents()

// apposed to

println this.class.getResourceAsStream('readme.txt').getText()