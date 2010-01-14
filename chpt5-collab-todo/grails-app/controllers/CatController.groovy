class CatController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        def user = User.get(session.user.id)
		def catList = Category.findAllByUser(user, params)
		[catInstanceList: catList, catInstanceTotal: catList.size() ] 
        //[catInstanceList: Cat.list(params), catInstanceTotal: Cat.count()]
    }

    def create = {
        def catInstance = new Cat()
        catInstance.properties = params
        return [catInstance: catInstance]
    }

    def save = {
        def catInstance = new Cat(params)
		def user = User.get(session.user.id); 
		catInstance.user = user
        if (catInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'cat.label', default: 'Cat'), catInstance.id])}"
            redirect(action: "show", id: catInstance.id)
        }
        else {
            render(view: "create", model: [catInstance: catInstance])
        }
    }

    def show = {
        def catInstance = Cat.get(params.id)
        if (!catInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cat.label', default: 'Cat'), params.id])}"
            redirect(action: "list")
        }
        else {
            [catInstance: catInstance]
        }
    }

    def edit = {
        def catInstance = Cat.get(params.id)
        if (!catInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cat.label', default: 'Cat'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [catInstance: catInstance]
        }
    }

    def update = {
        def catInstance = Cat.get(params.id)
        if (catInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (catInstance.version > version) {
                    
                    catInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'cat.label', default: 'Cat')] as Object[], "Another user has updated this Cat while you were editing")
                    render(view: "edit", model: [catInstance: catInstance])
                    return
                }
            }
			
			def user = User.get(session.user.id)
            catInstance.properties = params
			catInstance.user = user
            if (!catInstance.hasErrors() && catInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'cat.label', default: 'Cat'), catInstance.id])}"
                redirect(action: "show", id: catInstance.id)
            }
            else {
                render(view: "edit", model: [catInstance: catInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cat.label', default: 'Cat'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def catInstance = Cat.get(params.id)
        if (catInstance) {
            try {
                catInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'cat.label', default: 'Cat'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'cat.label', default: 'Cat'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cat.label', default: 'Cat'), params.id])}"
            redirect(action: "list")
        }
    }
}
