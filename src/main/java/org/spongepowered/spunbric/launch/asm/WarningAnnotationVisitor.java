package org.spongepowered.spunbric.launch.asm;

import org.apache.logging.log4j.Logger;
import org.objectweb.asm.AnnotationVisitor;
import org.spongepowered.spunbric.launch.FabricLaunch;

import javax.annotation.Nullable;

abstract class WarningAnnotationVisitor extends AnnotationVisitor {

    private static final Logger logger = FabricLaunch.getLogger();

    final String className;

    WarningAnnotationVisitor(int api, String className) {
        super(api);
        this.className = className;
    }

    abstract String getAnnotation();

    @Override
    public void visit(String name, Object value) {
        logger.warn("Found unknown {} annotation element in {}: {} = {}", getAnnotation(), this.className, name, value);
    }

    @Override
    public void visitEnum(String name, String desc, String value) {
        logger.warn("Found unknown {} annotation element in {}: {} ({}) = {}", getAnnotation(), this.className, name, desc, value);
    }

    @Override
    @Nullable
    public AnnotationVisitor visitAnnotation(String name, String desc) {
        logger.warn("Found unknown {} annotation element in {}: {} ({})", getAnnotation(), this.className, name, desc);
        return null;
    }

    @Override
    @Nullable
    public AnnotationVisitor visitArray(String name) {
        logger.warn("Found unknown {} annotation element in {}: {}", getAnnotation(), this.className, name);
        return null;
    }

}
