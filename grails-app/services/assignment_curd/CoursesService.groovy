package assignment_curd

import grails.gorm.services.Service

@Service(Courses)
interface CoursesService {

    Courses get(Serializable id)

    List<Courses> list(Map args)

    Long count()

    void delete(Serializable id)

    Courses save(Courses courses)

}