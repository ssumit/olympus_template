package olympus.template;

import olympus.common.OlympusService;
import olympus.message.json.JSONSerializer;
import olympus.message.processor.MessagingService;
import olympus.message.types.Message;
import olympus.message.types.ResponseTracker;
import olympus.message.util.AbstractClient;
import olympus.spartan.ImmutableMessage;
import olympus.spartan.ServiceInstance;
import olympus.template.api.controller.NotificationHandler;

public class TemplateClient extends AbstractClient {
    private final NotificationHandler notificationHandler;

    private static final String SERVICE_NOTIFICATION_HEADER = "template_notification_header";

    protected TemplateClient(MessagingService service, ServiceInstance hostService, NotificationHandler notificationHandler) {
        super(OlympusService.BLACK_HOLE, new JSONSerializer(), hostService);
        this.notificationHandler = notificationHandler;
        service.addClient(this);
    }

    public TemplateClient(MessagingService service, ServiceInstance hostService, ResponseTracker tracker, NotificationHandler notificationHandler) {
        super(OlympusService.BLACK_HOLE, new JSONSerializer(), hostService, tracker);
        this.notificationHandler = notificationHandler;
        service.addClient(this);
    }

    @Override
    protected boolean isMeantForClient(ImmutableMessage immutableMessage) {
        return immutableMessage.getHeader(SERVICE_NOTIFICATION_HEADER) != null;
    }

    @Override
    protected void onMessageFromService(Message message) {
        notificationHandler.handle(message);
    }
}