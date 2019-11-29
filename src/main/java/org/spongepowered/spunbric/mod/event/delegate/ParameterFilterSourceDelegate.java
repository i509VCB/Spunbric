package org.spongepowered.spunbric.mod.event.delegate;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.spongepowered.api.util.Tuple;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public interface ParameterFilterSourceDelegate {

	Tuple<Integer, Integer> write(ClassWriter cw, MethodVisitor mv, Method method, Parameter param, int local);
}