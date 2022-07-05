package assignment_curd

class GlobalConfig {

    public static final def USER_TYPE = [
            ADMINISTRATOR: "ADMINISTRATOR",
            REGULAR_MEMBER: "REGULAR_MEMBER",
    ]

    static Integer itemsPerPage() {
        return 10
    }
}


