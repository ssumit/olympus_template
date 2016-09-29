package olympus.template.api.request;

import olympus.common.JID;
import olympus.template.model.TemplatePayload;

import static com.google.common.base.Preconditions.checkNotNull;

public class EchoRequest extends TemplatePayload {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void validate() {
        checkNotNull(message);
    }

    public static class Builder extends TemplateRequestBuilder<EchoRequest> {

        public Builder() {
            super(new EchoRequest());
        }

        public Builder message(String message) {
            payload.message = message;
            return this;
        }

        @Override
        protected JID getTo(EchoRequest payload) {
            return new JID(payload.getAppDomain(), "templateService", payload.getGuid());
        }
    }
}