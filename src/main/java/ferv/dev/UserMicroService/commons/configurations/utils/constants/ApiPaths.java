package ferv.dev.UserMicroService.commons.configurations.utils.constants;

public final class ApiPaths {
    private ApiPaths() {
        throw new IllegalStateException("Utility class");
    }

    public static class User {
        public static final String BASE = "/user";
        public static final String GET_BY_ID = "/{id}";
        public static final String GET = "/";
        public static final String GET_CONTACT = "/contact/{id}";
        public static final String ALL = "/all";
    }

    public static class Auth {
        public static final String BASE = "auth";
        public static final String OWNER = "/owner";
        public static final String EMPLOYEE = "/employee";
        public static final String CLIENT = "/client";
        public static final String ADMIN = "/admin";
        public static final String AUTHENTICATE = "authenticate";

    }

}
