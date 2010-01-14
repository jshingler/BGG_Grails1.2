<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="Spinner" />
        </div>
        
        <div id="topbar">
	        <g:render template="/common/topbar" />
        </div>
		
		<div id="header">
           <h1>Collab-Todo</h1>
        </div>
		
		<div id="content">
				<g:layoutBody />
		</div>
        
      	<div id="sidebar">
			<g:render template="/common/buddies" />
		</div>

		<div id="footer">
			<g:render template="/common/footer" />
		</div>
        
        
        
        
    </body>
</html>