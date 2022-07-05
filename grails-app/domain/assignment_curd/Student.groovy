package assignment_curd

class Student {

    static belongsTo = [department: Department]
    String name
    Integer age
    String address

    static constraints = {
        name size: 1..40
        age min: 18
        address size: 1..40
    }

    String toString() {
        name
    }
}