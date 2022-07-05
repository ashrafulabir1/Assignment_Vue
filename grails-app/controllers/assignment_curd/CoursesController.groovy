package assignment_curd

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import grails.web.servlet.mvc.GrailsParameterMap

import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_USER'])
class CoursesController {

    CoursesService coursesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        def response = list(params)
        [coursesList: response.list, total:response.count]
    }

    def show(Long id) {
        respond coursesService.get(id)
    }

    def create() {
        respond new Courses(params)
    }

    def save(Courses courses) {
        if (courses == null) {
            notFound()
            return
        }

        try {
            coursesService.save(courses)
        } catch (ValidationException e) {
            respond courses.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'courses.label', default: 'Courses'), courses.id])
                redirect courses
            }
            '*' { respond courses, [status: CREATED] }
        }
    }

    def getById(Serializable id) {
        return Courses.get(id)
    }

    def list(GrailsParameterMap params) {
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<Courses> coursesList = Courses.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
        }
        return [list: coursesList, count: Courses.count()]
    }


    def edit(Long id) {
        respond coursesService.get(id)
    }

    def update(Courses courses) {
        if (courses == null) {
            notFound()
            return
        }

        try {
            coursesService.save(courses)
        } catch (ValidationException e) {
            respond courses.errors, view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'courses.label', default: 'Courses'), courses.id])
                redirect courses
            }
            '*' { respond courses, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        coursesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'courses.label', default: 'Courses'), id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'courses.label', default: 'Courses'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
