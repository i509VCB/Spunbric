package org.spongepowered.spunbric.mod.event.delegate;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.lang.reflect.Method;

public interface FilterDelegate {

	int write(String name, ClassWriter cw, MethodVisitor mv, Method method, int locals);

}
