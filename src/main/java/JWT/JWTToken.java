package JWT;


import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@javax.ws.rs.NameBinding
@Retention(RUNTIME)
public @interface JWTToken {
}
