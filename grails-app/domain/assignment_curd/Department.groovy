package assignment_curd

class Department {

    static  hasMany = [students: Student, courses: Courses]
     String name

     static constraints = {
        name size: 1..40

    }

    String toString() {
        name
    }
}
