
class UserFilters {
	def filters = {
		userModificationCheck(controller: 'user', action: '(edit|update|delete)') {
			before = {
				String userId = session?.user?.id
				String paramsUserId = params?.id
				if (userId != paramsUserId) {
					flash.message = "You can only modify yourself"
					redirect(controller: 'user', action: 'list')
					return false
				}
			}
		}
	}
}