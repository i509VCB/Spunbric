package org.spongepowered.spunbric.launch.asm;

import static org.objectweb.asm.Opcodes.ASM5;

import org.objectweb.asm.AnnotationVisitor;
import org.spongepowered.plugin.meta.PluginMetadata;
import org.spongepowered.spunbric.launch.InvalidPluginException;

final class PluginAnnotationVisitor extends WarningAnnotationVisitor {

    private enum State {
        DEFAULT, AUTHORS, DEPENDENCIES
    }

    private final PluginMetadata metadata;

    private State state = State.DEFAULT;
    private boolean hasId;

    PluginAnnotationVisitor(String className) {
        super(ASM5, className);
        this.metadata = new PluginMetadata("unknown");
    }

    PluginMetadata getMetadata() {
        return this.metadata;
    }

    @Override
    String getAnnotation() {
        return "@Plugin";
    }

    @Override
    public void visit(String name, Object value) {
        if (this.state == State.AUTHORS) {
            if (!(value instanceof String)) {
                throw new InvalidPluginException("Plugin annotation has invalid element 'author'");
            }
            this.metadata.addAuthor((String) value);
            return;
        }

        if (name == null) {
            throw new InvalidPluginException("Plugin annotation attribute name is null");
        }

        if (this.state == State.DEPENDENCIES) {
            throw new InvalidPluginException("Plugin annotation has invalid element 'dependencies'");
        }

        switch (name) {
            case "id":
                if (!(value instanceof String)) {
                    throw new InvalidPluginException("Plugin annotation has invalid element 'id'");
                }
                this.hasId = true;
                this.metadata.setId((String) value);
                return;
            case "name":
                if (!(value instanceof String)) {
                    throw new InvalidPluginException("Plugin annotation has invalid element 'name'");
                }
                this.metadata.setName((String) value);
                return;
            case "version":
                if (!(value instanceof String)) {
                    throw new InvalidPluginException("Plugin annotation has invalid element 'version'");
                }
                this.metadata.setVersion((String) value);
                return;
            case "description":
                if (!(value instanceof String)) {
                    throw new InvalidPluginException("Plugin annotation has invalid element 'description'");
                }
                this.metadata.setDescription((String) value);
                return;
            case "url":
                if (!(value instanceof String)) {
                    throw new InvalidPluginException("Plugin annotation has invalid element 'url'");
                }
                this.metadata.setUrl((String) value);
                return;
            default:
                super.visit(name, value);
        }
    }

    @Override
    public AnnotationVisitor visitAnnotation(String name, String desc) {
        if (this.state == State.DEPENDENCIES) {
            return new DependencyAnnotationVisitor(this.className, this.metadata);
        }
        return super.visitAnnotation(name, desc);
    }

    @Override
    public AnnotationVisitor visitArray(String name) {
        if (name == null) {
            throw new InvalidPluginException("Plugin annotation has null element");
        }
        switch (name) {
            case "authors":
                this.state = State.AUTHORS;
                return this;
            case "dependencies":
                this.state = State.DEPENDENCIES;
                return this;
            default:
                return super.visitArray(name);
        }
    }

    @Override
    public void visitEnd() {
        if (this.state != State.DEFAULT) {
            this.state = State.DEFAULT;
            return;
        }

        if (!this.hasId) {
            throw new InvalidPluginException("Plugin annotation is missing required element 'id'");
        }
    }

}
