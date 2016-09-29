package olympus.template.model;

import olympus.message.types.Payload;
import olympus.proteus.models.ProteusParams;

public abstract class TemplatePayload implements Payload {
    private ProteusParams proteusParams;
    private String appDomain;
    private String guid;

    public void setProteusParams(ProteusParams proteusParams) {
        this.proteusParams = proteusParams;
    }

    public abstract void validate();

    public void appDomain(String appDomain) {
        this.appDomain = appDomain;
    }

    public void guid(String guid) {
        this.guid = guid;
    }

    public ProteusParams getProteusParams() {
        return proteusParams;
    }

    public String getAppDomain() {
        return appDomain;
    }

    public String getGuid() {
        return guid;
    }
}