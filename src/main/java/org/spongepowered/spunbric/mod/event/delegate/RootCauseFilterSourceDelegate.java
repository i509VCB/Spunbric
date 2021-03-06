package org.spongepowered.spunbric.mod.event.delegate;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.filter.cause.Root;

import java.lang.reflect.Parameter;

import static org.objectweb.asm.Opcodes.ACONST_NULL;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.IFEQ;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.INSTANCEOF;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

public class RootCauseFilterSourceDelegate extends CauseFilterSourceDelegate {

	private final Root anno;

	public RootCauseFilterSourceDelegate(Root anno) {
		this.anno = anno;
	}

	@Override
	protected void insertCauseCall(MethodVisitor mv, Parameter param, Class<?> targetType) {
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.getInternalName(Cause.class), "root",
			"()Ljava/lang/Object;", false);
	}

	@Override
	protected void insertTransform(MethodVisitor mv, Parameter param, Class<?> targetType, int local) {
		Label failure = new Label();
		Label success = new Label();

		mv.visitVarInsn(ALOAD, local);
		mv.visitTypeInsn(INSTANCEOF, Type.getInternalName(targetType));

		if (this.anno.typeFilter().length != 0) {
			mv.visitJumpInsn(IFEQ, failure);
			mv.visitVarInsn(ALOAD, local);
			// For each type we do an instance check and jump to either failure or success if matched
			for (int i = 0; i < this.anno.typeFilter().length; i++) {
				Class<?> filter = this.anno.typeFilter()[i];
				if (i < this.anno.typeFilter().length - 1) {
					mv.visitInsn(DUP);
				}
				mv.visitTypeInsn(INSTANCEOF, Type.getInternalName(filter));
				if (this.anno.inverse()) {
					mv.visitJumpInsn(IFNE, failure);
				} else {
					mv.visitJumpInsn(IFNE, success);
				}
			}
			if (this.anno.inverse()) {
				mv.visitJumpInsn(GOTO, success);
			}
			// If the annotation was not reversed then we fall into failure as no types were matched
		} else {
			mv.visitJumpInsn(IFNE, success);
		}
		mv.visitLabel(failure);
		mv.visitInsn(ACONST_NULL);
		mv.visitInsn(ARETURN);

		mv.visitLabel(success);
	}
}
