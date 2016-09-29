package olympus.template.api.response;

import olympus.message.types.Payload;

public class EchoResponse implements Payload {
    private final String response;

    public EchoResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}