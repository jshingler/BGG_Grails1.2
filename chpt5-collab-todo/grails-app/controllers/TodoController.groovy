class TodoController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def beforeInterceptor = [action:this.&beforeAudit,except:['list']]
	def afterInterceptor = [action:{model ->this.&afterAudit(model)
	},except:['list']]
	
	def beforeAudit = {
		log.trace("${session?.user?.userName} Start action ${controllerName}Controller.${actionName}() : parameters $params")
	}
	
	def afterAudit = { model ->
		log.trace("${session?.user?.userName} End action ${controllerName}Controller.${actionName}() : returns $model")
	}
	
	def index = {
		redirect(action: "list", params: params)
	}
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[todoInstanceList: Todo.list(params), todoInstanceTotal: Todo.count()]
	}
	
	def create = {
		def todoInstance = new Todo()
		todoInstance.properties = params
		return [todoInstance: todoInstance]
	}
	
	def save = {
		def todoInstance = new Todo(params)
		if (todoInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'todo.label', default: 'Todo'), todoInstance.id])}"
			redirect(action: "show", id: todoInstance.id)
		}
		else {
			render(view: "create", model: [todoInstance: todoInstance])
		}
	}
	
	def show = {
		def todoInstance = Todo.get(params.id)
		if (!todoInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'todo.label', default: 'Todo'), params.id])}"
			redirect(action: "list")
		}
		else {
			[todoInstance: todoInstance]
		}
	}
	
	def edit = {
		def todoInstance = Todo.get(params.id)
		if (!todoInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'todo.label', default: 'Todo'), params.id])}"
			redirect(action: "list")
		}
		else {
			return [todoInstance: todoInstance]
		}
	}
	
	def update = {
		def todoInstance = Todo.get(params.id)
		if (todoInstance) {
			if (params.version) {
				def version = params.version.toLong()
				if (todoInstance.version > version) {
					
					todoInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'todo.label', default: 'Todo')] as Object[], "Another user has updated this Todo while you were editing")
					render(view: "edit", model: [todoInstance: todoInstance])
					return
				}
			}
			todoInstance.properties = params
			if (!todoInstance.hasErrors() && todoInstance.save(flush: true)) {
				flash.message = "${message(code: 'default.updated.message', args: [message(code: 'todo.label', default: 'Todo'), todoInstance.id])}"
				redirect(action: "show", id: todoInstance.id)
			}
			else {
				render(view: "edit", model: [todoInstance: todoInstance])
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'todo.label', default: 'Todo'), params.id])}"
			redirect(action: "list")
		}
	}
	
	def delete = {
		def todoInstance = Todo.get(params.id)
		if (todoInstance) {
			try {
				todoInstance.delete(flush: true)
				flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'todo.label', default: 'Todo'), params.id])}"
				redirect(action: "list")
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'todo.label', default: 'Todo'), params.id])}"
				redirect(action: "show", id: params.id)
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'todo.label', default: 'Todo'), params.id])}"
			redirect(action: "list")
		}
	}
}
