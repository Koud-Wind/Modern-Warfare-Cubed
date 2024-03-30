package com.paneedah.mwc.asm;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Field;

public class ForgeTransform implements IClassTransformer {

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (!transformedName.equals("net.minecraftforge.fml.common.ObfuscationReflectionHelper")) {
            return basicClass;
        }
        ClassReader reader = new ClassReader(basicClass);
        ClassWriter writer = new ClassWriter(reader, 1);
        reader.accept(new ForgeTransform1(writer), ClassReader.EXPAND_FRAMES);
        return writer.toByteArray();
    }

    public static class ForgeTransform1 extends ClassVisitor {

        String classname;

        boolean hasGetPrivateValue = false;

        public ForgeTransform1(ClassWriter classWriter) {
            super(Opcodes.ASM4, classWriter);
        }

        @Override
        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
            this.classname = name;
            super.visit(version, access, name, signature, superName, interfaces);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            if (name.equals("getPrivateValue")) {
                hasGetPrivateValue = true;
            }
            return super.visitMethod(access, name, desc, signature, exceptions);
        }

        @Override
        public void visitEnd() {
            if (hasGetPrivateValue) {
                super.visitEnd();
                return;
            }
            MethodVisitor methodVisitor = cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "getPrivateValue", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "<T:Ljava/lang/Object;E:Ljava/lang/Object;>(Ljava/lang/Class<-TE;>;TE;Ljava/lang/String;)TT;", null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(106, label0);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 1);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 2);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "net/minecraftforge/fml/common/ObfuscationReflectionHelper", "remapFieldName", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;", false);
            methodVisitor.visitInsn(Opcodes.ACONST_NULL);
            // net/minecraftforge/fml/relauncher/ReflectionHelper
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "net/minecraftforge/fml/common/ObfuscationReflectionHelper", "getPrivateValue", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", false);
            methodVisitor.visitInsn(Opcodes.ARETURN);
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLocalVariable("classToAccess", "Ljava/lang/Class;", "Ljava/lang/Class<-TE;>;", label0, label1, 0);
            methodVisitor.visitLocalVariable("instance", "Ljava/lang/Object;", "TE;", label0, label1, 1);
            methodVisitor.visitLocalVariable("srgName", "Ljava/lang/String;", null, label0, label1, 2);
            methodVisitor.visitMaxs(4, 3);
            methodVisitor.visitEnd();

            methodVisitor = cv.visitMethod(Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC, "remapFieldName", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;", "(Ljava/lang/Class<*>;Ljava/lang/String;)Ljava/lang/String;", null);
            methodVisitor.visitCode();
            label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(72, label0);
            methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "net/minecraftforge/fml/common/asm/transformers/deobf/FMLDeobfuscatingRemapper", "INSTANCE", "Lnet/minecraftforge/fml/common/asm/transformers/deobf/FMLDeobfuscatingRemapper;");
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "org/objectweb/asm/Type", "getInternalName", "(Ljava/lang/Class;)Ljava/lang/String;", false);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraftforge/fml/common/asm/transformers/deobf/FMLDeobfuscatingRemapper", "unmap", "(Ljava/lang/String;)Ljava/lang/String;", false);
            methodVisitor.visitVarInsn(Opcodes.ASTORE, 2);
            label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLineNumber(73, label1);
            methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "net/minecraftforge/fml/common/asm/transformers/deobf/FMLDeobfuscatingRemapper", "INSTANCE", "Lnet/minecraftforge/fml/common/asm/transformers/deobf/FMLDeobfuscatingRemapper;");
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 2);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 1);
            methodVisitor.visitInsn(Opcodes.ACONST_NULL);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraftforge/fml/common/asm/transformers/deobf/FMLDeobfuscatingRemapper", "mapFieldName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false);
            methodVisitor.visitInsn(Opcodes.ARETURN);
            Label label2 = new Label();
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLocalVariable("clazz", "Ljava/lang/Class;", "Ljava/lang/Class<*>;", label0, label2, 0);
            methodVisitor.visitLocalVariable("fieldName", "Ljava/lang/String;", null, label0, label2, 1);
            methodVisitor.visitLocalVariable("internalClassName", "Ljava/lang/String;", null, label1, label2, 2);
            methodVisitor.visitMaxs(4, 3);
            methodVisitor.visitEnd();


            methodVisitor = cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "getPrivateValue", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "<T:Ljava/lang/Object;E:Ljava/lang/Object;>(Ljava/lang/Class<-TE;>;TE;Ljava/lang/String;Ljava/lang/String;)TT;", null);
            methodVisitor.visitCode();
            label0 = new Label();
            label1 = new Label();
            label2 = new Label();
            methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/Exception");
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(206, label0);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 2);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 3);
            // net/minecraftforge/fml/relauncher/ReflectionHelper
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "net/minecraftforge/fml/common/ObfuscationReflectionHelper", "findField", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/reflect/Field;", false);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 1);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/reflect/Field", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", false);
            methodVisitor.visitLabel(label1);
            methodVisitor.visitInsn(Opcodes.ARETURN);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLineNumber(208, label2);
            methodVisitor.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"java/lang/Exception"});
            methodVisitor.visitVarInsn(Opcodes.ASTORE, 4);
            Label label3 = new Label();
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLineNumber(210, label3);
            methodVisitor.visitTypeInsn(Opcodes.NEW, "net/minecraftforge/fml/relauncher/ReflectionHelper$UnableToAccessFieldException");
            methodVisitor.visitInsn(Opcodes.DUP);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 4);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "net/minecraftforge/fml/relauncher/ReflectionHelper$UnableToAccessFieldException", "<init>", "(Ljava/lang/Exception;)V", false);
            methodVisitor.visitInsn(Opcodes.ATHROW);
            Label label4 = new Label();
            methodVisitor.visitLabel(label4);
            methodVisitor.visitLocalVariable("e", "Ljava/lang/Exception;", null, label3, label4, 4);
            methodVisitor.visitLocalVariable("classToAccess", "Ljava/lang/Class;", "Ljava/lang/Class<-TE;>;", label0, label4, 0);
            methodVisitor.visitLocalVariable("instance", "Ljava/lang/Object;", "TE;", label0, label4, 1);
            methodVisitor.visitLocalVariable("fieldName", "Ljava/lang/String;", null, label0, label4, 2);
            methodVisitor.visitLocalVariable("fieldObfName", "Ljava/lang/String;", null, label0, label4, 3);
            methodVisitor.visitMaxs(3, 5);
            methodVisitor.visitEnd();

            methodVisitor = cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "findField", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/reflect/Field;", "(Ljava/lang/Class<*>;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/reflect/Field;", null);
            methodVisitor.visitCode();
            label0 = new Label();
            label1 = new Label();
            label2 = new Label();
            methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/Exception");
            label3 = new Label();
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLineNumber(153, label3);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "com/google/common/base/Preconditions", "checkNotNull", "(Ljava/lang/Object;)Ljava/lang/Object;", false);
            methodVisitor.visitInsn(Opcodes.POP);
            label4 = new Label();
            methodVisitor.visitLabel(label4);
            methodVisitor.visitLineNumber(154, label4);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 1);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "org/apache/commons/lang3/StringUtils", "isNotEmpty", "(Ljava/lang/CharSequence;)Z", false);
            methodVisitor.visitLdcInsn("Field name cannot be empty");
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "com/google/common/base/Preconditions", "checkArgument", "(ZLjava/lang/Object;)V", false);
            Label label5 = new Label();
            methodVisitor.visitLabel(label5);
            methodVisitor.visitLineNumber(156, label5);
            // net/minecraftforge/fml/relauncher/FMLLaunchHandler
            methodVisitor.visitInsn(Opcodes.ICONST_1);
            Label label6 = new Label();
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label6);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 1);
            Label label7 = new Label();
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label7);
            methodVisitor.visitLabel(label6);
            methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 2);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 1);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "com/google/common/base/MoreObjects", "firstNonNull", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", false);
            methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/lang/String");
            methodVisitor.visitLabel(label7);
            methodVisitor.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"java/lang/String"});
            methodVisitor.visitVarInsn(Opcodes.ASTORE, 3);
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(160, label0);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 3);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Class", "getDeclaredField", "(Ljava/lang/String;)Ljava/lang/reflect/Field;", false);
            methodVisitor.visitVarInsn(Opcodes.ASTORE, 4);
            Label label8 = new Label();
            methodVisitor.visitLabel(label8);
            methodVisitor.visitLineNumber(161, label8);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 4);
            methodVisitor.visitInsn(Opcodes.ICONST_1);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/reflect/Field", "setAccessible", "(Z)V", false);
            Label label9 = new Label();
            methodVisitor.visitLabel(label9);
            methodVisitor.visitLineNumber(162, label9);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 4);
            methodVisitor.visitLabel(label1);
            methodVisitor.visitInsn(Opcodes.ARETURN);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLineNumber(164, label2);
            methodVisitor.visitFrame(Opcodes.F_FULL, 4, new Object[]{"java/lang/Class", "java/lang/String", "java/lang/String", "java/lang/String"}, 1, new Object[]{"java/lang/Exception"});
            methodVisitor.visitVarInsn(Opcodes.ASTORE, 4);
            Label label10 = new Label();
            methodVisitor.visitLabel(label10);
            methodVisitor.visitLineNumber(166, label10);
            methodVisitor.visitTypeInsn(Opcodes.NEW, "net/minecraftforge/fml/relauncher/ReflectionHelper$UnableToFindFieldException");
            methodVisitor.visitInsn(Opcodes.DUP);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 4);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "net/minecraftforge/fml/relauncher/ReflectionHelper$UnableToFindFieldException", "<init>", "(Ljava/lang/Exception;)V", false);
            methodVisitor.visitInsn(Opcodes.ATHROW);
            Label label11 = new Label();
            methodVisitor.visitLabel(label11);
            methodVisitor.visitLocalVariable("f", "Ljava/lang/reflect/Field;", null, label8, label2, 4);
            methodVisitor.visitLocalVariable("e", "Ljava/lang/Exception;", null, label10, label11, 4);
            methodVisitor.visitLocalVariable("clazz", "Ljava/lang/Class;", "Ljava/lang/Class<*>;", label3, label11, 0);
            methodVisitor.visitLocalVariable("fieldName", "Ljava/lang/String;", null, label3, label11, 1);
            methodVisitor.visitLocalVariable("fieldObfName", "Ljava/lang/String;", null, label3, label11, 2);
            methodVisitor.visitLocalVariable("nameToFind", "Ljava/lang/String;", null, label0, label11, 3);
            methodVisitor.visitMaxs(3, 5);
            methodVisitor.visitEnd();

            methodVisitor = cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "isDeobfuscatedEnvironment", "()Z", null, null);
            methodVisitor.visitCode();
            label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(140, label0);
            methodVisitor.visitInsn(Opcodes.ICONST_1);
            methodVisitor.visitInsn(Opcodes.IRETURN);
            methodVisitor.visitMaxs(1, 0);
            methodVisitor.visitEnd();

            super.visitEnd();
        }

    }

    public static Field findField(@Nonnull Class<?> clazz, @Nonnull String fieldName, @Nullable String fieldObfName) {
        Preconditions.checkNotNull(clazz);
        Preconditions.checkArgument(StringUtils.isNotEmpty(fieldName), "Field name cannot be empty");
        String nameToFind = false ? fieldName : MoreObjects.<String>firstNonNull(fieldObfName, fieldName);
        try {
            Field f = clazz.getDeclaredField(nameToFind);
            f.setAccessible(true);
            return f;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T, E> T getPrivateValue(Class<? super E> classToAccess, @Nullable E instance, String srgName) {
        String internalClassName = FMLDeobfuscatingRemapper.INSTANCE.unmap(Type.getInternalName(classToAccess));
        String s = FMLDeobfuscatingRemapper.INSTANCE.mapFieldName(internalClassName, srgName, null);

        try {
            return (T) findField(classToAccess, s, null).get(instance);
        } catch (Exception ignored) {
            System.out.println("From ForgeTransform");
            return null;
        }
    }

}
