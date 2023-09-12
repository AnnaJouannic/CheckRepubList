package checkrepublist.group.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class VoyageurNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

}
