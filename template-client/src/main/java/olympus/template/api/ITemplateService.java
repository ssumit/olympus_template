package olympus.template.api;

import com.google.common.util.concurrent.ListenableFuture;
import olympus.template.api.response.EchoResponse;

public interface ITemplateService {
    ListenableFuture<EchoResponse> echo();
}