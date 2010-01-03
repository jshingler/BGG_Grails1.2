/*
 * Meta Object Programming example that shows alternative ways
 * to load a files.
 */

println this.class.getResourceAsStream("nightlyReportsEmail.gtpl").getText()

String.metaClass.fileAsString = {
  this.class.getResourceAsStream(delegate).getText()
}

println 'nightlyReportsEmail.gtpl'.fileAsString()

println '------------------------'

Class.metaClass.getResourceAsText = { resource ->
  this.class.getResourceAsStream(resource).getText()
}

println this.class.getResourceAsText('nightlyReportsEmail.gtpl')

