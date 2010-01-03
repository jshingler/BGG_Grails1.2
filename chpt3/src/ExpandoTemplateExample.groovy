/**
 * Script used to generate a template based email using an
 * Expando rather than a Groovy Bean.
 */
import groovy.text.SimpleTemplateEngine

def emailTemplate = this.class.getResource("nightlyReportsEmail.gtpl")
def binding = [
        "user": new Expando([ firstName: 'Christopher', lastName:'Judd']),
        "date": new Date()]
def engine = new SimpleTemplateEngine()
def template = engine.createTemplate(emailTemplate).make(binding)
def body = template.toString()

println body