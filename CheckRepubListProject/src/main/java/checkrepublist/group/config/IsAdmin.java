package checkrepublist.group.config;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import org.springframework.security.access.prepost.PreAuthorize;

@Retention(RUNTIME)
@PreAuthorize("hasRole('Admin')")
public @interface IsAdmin {

}
