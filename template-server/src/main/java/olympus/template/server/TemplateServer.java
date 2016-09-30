package olympus.template.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;
import org.apache.commons.lang.time.StopWatch;

public class TemplateServer {
    public static void main(final String[] args) throws Exception {
        try {
            start(new ApplicationModule());
        } catch (Exception e) {
            if (e.getCause() != null && e.getCause().getMessage() != null) {
                System.out.println(e.getCause().getMessage());
                for (StackTraceElement element : e.getStackTrace()) {
                    System.out.println(element.getFileName() + " " + element.getClassName() + " " + element
                            .getMethodName());
                }
            }
            e.printStackTrace();
        }
    }

    public static void start(Module module) {
/*
        StopWatch stopWatch = StopWatch.createAndStart();
        log.warn("Starting Atropos ...");
        java.security.Security.setProperty("networkaddress.cache.ttl", TTL_SECONDS);
        Injector injector = Guice.createInjector(Stage.PRODUCTION, module);
        injector.getInstance(BootStrapper.class);
        log.warn("Atropos started in " + stopWatch.stop() + " seconds");
*/
    }
}