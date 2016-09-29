package olympus.template.api;

import com.google.common.util.concurrent.ListenableFuture;
import olympus.template.api.response.EchoResponse;

public class TemplateService implements ITemplateService {

    public ListenableFuture<EchoResponse> echo() {
        return null;
    }
}
