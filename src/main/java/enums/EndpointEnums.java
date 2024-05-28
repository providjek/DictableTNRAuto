package enums;

public enum EndpointEnums {
    HOME("/"),
    CREATION_COMPTE("/auth/signup"),
    YOPMAIL("https://yopmail.com/fr/"),
    CONNEXION("/auth/signin"),
    ADD_PROFILE("/profiles/add"),
    SETTINGS("/settings"),
    PROFILES_MANAGEMENT("/profiles/management"),
    PROFILE("/auth/profile");

    String endpoint;

    EndpointEnums(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
