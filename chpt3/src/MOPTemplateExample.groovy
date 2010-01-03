/*
 * Script used to generate a template based email using an
 * meta object programming to load the template file.
 */
import groovy.text.SimpleTemplateEngine

Class.metaClass.getResourceAsText = { resource ->
  this.class.getResourceAsStream(resource).getText()
}

def emailTemplate = this.class.getResourceAsText('nightlyReportsEmail.gtpl')
def binding = [
        "user": new Expando([ firstName: 'Christopher', lastName:'Judd']),
        "date": new Date()]
def engine = new SimpleTemplateEngine()
def template = engine.createTemplate(emailTemplate).make(binding)
def body = template.toString()

println body