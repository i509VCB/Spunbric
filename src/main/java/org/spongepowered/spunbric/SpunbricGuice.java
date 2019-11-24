package org.spongepowered.spunbric;

import com.google.inject.Stage;

public class SpunbricGuice {
    public static Stage getInjectorStage(final Stage defaultStage) {
        return Stage.valueOf(System.getProperty("guice.stage", defaultStage.name()).toUpperCase());
    }

}
