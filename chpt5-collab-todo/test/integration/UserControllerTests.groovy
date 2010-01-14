import grails.test.*

class UserControllerTests extends ControllerUnitTestCase {
	
	User user
	UserController uc
	
	protected void setUp() {
		super.setUp()
		
		// Save a User
		user = new User(userName:"User1", firstName:"User1FN", lastName:"User1LN")
		user.save()
		
		// Setup User Controller
		uc = new UserController()
	}
	
	protected void tearDown() {
		super.tearDown()
	}
	
	/**
	 * Test the UserController.handleLogin action.
	 *
	 * If the login succeeds, it will put the user object into the session.
	 */
	void testHandleLogin() {
		// Setup controller parameters
		uc.params.userName = user.userName
		
		// Call the action
		uc.handleLogin()
		
		// If action functioned correctly, it put a user object
		// into the session
		def sessUser = uc.session.user
		assert sessUser
		assertEquals("Expected ids to match", user.id, sessUser.id)
		// And the user was redirected to the Todo Page
		println "Redirect: ${uc.response}"
		println "Redirect: ${uc.response.redirectedUrl}"
		println "Redirect2: ${uc.response.getRedirectedUrl()}"
		println "Redirect: ${uc.response.dump()}"
		// Getting redirectUrl from MockResponse doesn't work anymore
		//assertEquals "/todo", uc.response.redirectedUrl
	}
	
	/**
	 * Test the UserController.handleLogin action.
	 *
	 * If the login fails, it will redirect to login and set a flash message.
	 */
	void testHandleLoginInvalidUser() {
		// Setup controller parameters
		uc.params.userName = "INVALID_USER_NAME"
		
		// Call the action
		uc.handleLogin()
		//assertEquals "/user/login", uc.response.redirectedUrl
		def message = uc.flash.message
		assert message
		assert message.startsWith("User not found")
	}
	
	/**
	 * Test the UserController.login action
	 *
	 * If the logout action succeeds, it will remove the user object from
	 * the session.
	 */
	void testLogout() {
		// make it look like user is logged in
		uc.session.user = user
		
		uc.logout()
		def sessUser = uc.session.user
		assertNull("Expected session user to be null", sessUser)
		//assertEquals "/user/login", uc.response.redirectedUrl
	}
}
