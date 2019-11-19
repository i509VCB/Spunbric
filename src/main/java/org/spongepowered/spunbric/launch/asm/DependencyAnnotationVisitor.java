package org.spongepowered.spunbric.launch.asm;

import org.spongepowered.plugin.meta.PluginDependency;
import org.spongepowered.plugin.meta.PluginMetadata;
import org.spongepowered.spunbric.launch.InvalidPluginException;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.objectweb.asm.Opcodes.ASM5;

final class DependencyAnnotationVisitor extends WarningAnnotationVisitor {

    private final PluginMetadata metadata;

    @Nullable private String id;
    @Nullable private String version;
    private boolean optional;

    DependencyAnnotationVisitor(String className, PluginMetadata metadata) {
        super(ASM5, className);
        this.metadata = metadata;
    }

    @Override
    String getAnnotation() {
        return "@Dependency";
    }

    @Override
    public void visit(String name, Object value) {
        checkNotNull(name, "name");
        switch (name) {
            case "id":
                if (!(value instanceof String)) {
                    throw new InvalidPluginException("Dependency annotation has invalid element 'id'");
                }
                this.id = (String) value;
                return;
            case "version":
                if (!(value instanceof String)) {
                    throw new InvalidPluginException("Dependency annotation has invalid element 'version'");
                }
                this.version = (String) value;
                return;
            case "optional":
                if (!(value instanceof Boolean)) {
                    throw new InvalidPluginException("Dependency annotation has invalid element 'optional'");
                }
                this.optional = (boolean) value;
                return;
            default:
                super.visit(name, value);
        }
    }

    @Override
    public void visitEnd() {
        if (this.id == null) {
            throw new IllegalArgumentException("Dependency plugin ID is required");
        }

        this.metadata.addDependency(new PluginDependency(PluginDependency.LoadOrder.BEFORE, this.id, this.version, this.optional));
    }

}
