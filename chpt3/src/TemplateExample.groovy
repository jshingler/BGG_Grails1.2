/**
 * Script used to generate a template based email.
 */
import groovy.text.SimpleTemplateEngine

/**
 * Simple User Groovy Bean.
 */
class User {
  String firstName;
  String lastName;
}

def emailTemplate = this.class.getResource("nightlyReportsEmail.gtpl")
def binding = ["user": new User(firstName: "Christopher", lastName: "Judd"), "date": new Date()]
def engine = new SimpleTemplateEngine()
def email = engine.createTemplate(emailTemplate).make(binding)
def body = email.toString()

println body


