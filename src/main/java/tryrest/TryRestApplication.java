package tryrest;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * アプリケーション。
 */
public class TryRestApplication extends ResourceConfig {

    /**
     * コンストラクタ。
     */
    public TryRestApplication() {
        packages(TryRestApplication.class.getPackage().getName());
    }

}
