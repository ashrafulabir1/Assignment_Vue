package assignment_curd

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import grails.web.servlet.mvc.GrailsParameterMap

import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_USER'])
class StudentController {

    StudentService studentService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

//    def index(Integer max) {
//            params.max = Math.min(max ?: 10, 100)
//            respond studentService.list(params), model:[studentCount: studentService.count()]
//    }

    def index() {
        def response = list(params)
        [studentList: response.list, total:response.count]
    }


    def show(Long id) {
            respond studentService.get(id)
    }


    def getById(Serializable id) {
        return Student.get(id)
    }

    def list(GrailsParameterMap params) {
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<Student> studentList = Student.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
        }
        return [list: studentList, count: Student.count()]
    }



    def create() {
            respond new Student(params)
        }

        def save(Student student) {
            if (student == null) {
                notFound()
                return
            }

            try {
                studentService.save(student)
            } catch (ValidationException e) {
                respond student.errors, view:'create'
                return
            }

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'student.label', default: 'Student'), student.id])
                    redirect student
                }
                '*' { respond student, [status: CREATED] }
            }
        }

        def edit(Long id) {
            respond studentService.get(id)
        }

        def update(Student student) {
            if (student == null) {
                notFound()
                return
            }

            try {
                studentService.save(student)
            } catch (ValidationException e) {
                respond student.errors, view:'edit'
                return
            }

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.updated.message', args: [message(code: 'student.label', default: 'Student'), student.id])
                    redirect student
                }
                '*'{ respond student, [status: OK] }
            }
        }

        def delete(Long id) {
            if (id == null) {
                notFound()
                return
            }

            studentService.delete(id)

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.deleted.message', args: [message(code: 'student.label', default: 'Student'), id])
                    redirect action:"index", method:"GET"
                }
                '*'{ render status: NO_CONTENT }
            }
        }

        protected void notFound() {
            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.not.found.message', args: [message(code: 'student.label', default: 'Student'), params.id])
                    redirect action: "index", method: "GET"
                }
                '*'{ render status: NOT_FOUND }
            }
        }
    }
