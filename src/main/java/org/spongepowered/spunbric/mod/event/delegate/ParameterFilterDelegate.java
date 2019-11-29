package org.spongepowered.spunbric.mod.event.delegate;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public interface ParameterFilterDelegate {

	void write(ClassWriter cw, MethodVisitor mv, Method method, Parameter param, int localParam);

}
