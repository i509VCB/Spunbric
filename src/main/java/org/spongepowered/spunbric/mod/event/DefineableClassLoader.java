package org.spongepowered.spunbric.mod.event;

public class DefineableClassLoader extends ClassLoader {

	public DefineableClassLoader(ClassLoader parent) {
		super(parent);
	}

	@SuppressWarnings("unchecked")
	public <T> Class<T> defineClass(String name, byte[] b) {
		return (Class<T>) defineClass(name, b, 0, b.length);
	}

}