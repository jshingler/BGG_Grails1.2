/*
 * Script showing how to use Expandos to add properties and
 * methods at runtime.
 */
import groovy.text.SimpleTemplateEngine

def user = new Expando()
user.firstName = 'Christopher'
user.lastName = 'Judd'

user.greeting = { greeting ->
  "${greeting} ${firstName} ${lastName}"
}

assert user.greeting("Hello") == 'Hello Christopher Judd'