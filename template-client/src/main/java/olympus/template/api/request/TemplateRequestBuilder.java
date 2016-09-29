package olympus.template.api.request;

import olympus.common.JID;
import olympus.message.types.Request;
import olympus.message.types.RequestBuilder;
import olympus.proteus.models.ProteusParams;
import olympus.template.model.TemplatePayload;

public abstract class TemplateRequestBuilder<T extends TemplatePayload> extends RequestBuilder<T, TemplateRequestBuilder> {
    private String guid;
    private String appDomain;
    protected final T payload;

    protected TemplateRequestBuilder(T payload) {
        this.payload = payload;
    }

    public TemplateRequestBuilder<T> appDomain(String appDomain) {
        this.appDomain = appDomain;
        return this;
    }

    public TemplateRequestBuilder<T> guid(String guid) {
        this.guid = guid;
        return this;
    }

    public TemplateRequestBuilder<T> proteusParams(ProteusParams proteusParams) {
        this.payload.setProteusParams(proteusParams);
        return this;
    }

    @Override
    public final Request<T> build() {
        payload.appDomain(appDomain);
        payload.guid(guid);
        payload.validate();
        to(getTo(payload));
        payload(payload);
        return super.build();
    }

    protected abstract JID getTo(T payload);
}