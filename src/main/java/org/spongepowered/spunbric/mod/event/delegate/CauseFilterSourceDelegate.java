package org.spongepowered.spunbric.mod.event.delegate;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.util.Tuple;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;

public abstract class CauseFilterSourceDelegate implements ParameterFilterSourceDelegate {

	@Override
	public Tuple<Integer, Integer> write(ClassWriter cw, MethodVisitor mv, Method method, Parameter param, int local) {
		// Get the cause
		mv.visitVarInsn(ALOAD, 1);
		mv.visitMethodInsn(INVOKEINTERFACE, Type.getInternalName(Event.class), "getCause",
			"()" + Type.getDescriptor(Cause.class), true);

		Class<?> targetType = param.getType();

		insertCauseCall(mv, param, targetType);
		int paramLocal = local++;
		mv.visitVarInsn(ASTORE, paramLocal);

		insertTransform(mv, param, targetType, paramLocal);

		return new Tuple<>(local, paramLocal);
	}

	protected abstract void insertCauseCall(MethodVisitor mv, Parameter param, Class<?> targetType);

	protected abstract void insertTransform(MethodVisitor mv, Parameter param, Class<?> targetType, int local);
}
