package org.spongepowered.spunbric.mod.event.delegate;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.event.filter.data.Has;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static org.objectweb.asm.Opcodes.ACONST_NULL;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.IFEQ;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

public class HasDataFilterDelegate implements ParameterFilterDelegate {

	private final Has anno;

	public HasDataFilterDelegate(Has anno) {
		this.anno = anno;
	}

	@Override
	public void write(ClassWriter cw, MethodVisitor mv, Method method, Parameter param, int localParam) {
		if (!DataHolder.class.isAssignableFrom(param.getType())) {
			throw new IllegalStateException("Annotated type for data filter is not a DataHolder");
		}

		mv.visitVarInsn(ALOAD, localParam);
		mv.visitTypeInsn(CHECKCAST, Type.getInternalName(DataHolder.class));
		mv.visitLdcInsn(Type.getType(this.anno.value()));
		mv.visitMethodInsn(INVOKEINTERFACE, Type.getInternalName(DataHolder.class), "get", "(Ljava/lang/Class;)Ljava/util/Optional;", true);
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Optional", "isPresent", "()Z", false);
		Label success = new Label();
		if (this.anno.inverse()) {
			mv.visitJumpInsn(IFEQ, success);
		} else {
			mv.visitJumpInsn(IFNE, success);
		}
		mv.visitInsn(ACONST_NULL);
		mv.visitInsn(ARETURN);
		mv.visitLabel(success);
	}

}
