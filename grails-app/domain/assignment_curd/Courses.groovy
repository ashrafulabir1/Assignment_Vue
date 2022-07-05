package assignment_curd

class Courses {

    String courses
    static belongsTo = [department: Department]


    static constraints = {

        courses size: 1..30
    }

    String toString() {
        courses
    }
}
