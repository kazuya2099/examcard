package com.examcard.util;

import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsTest {
	@Test
	public void test() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("class.classLoader.string", "fuge");
		try (TekitoClassLoader cl = new TekitoClassLoader((URLClassLoader) Thread.currentThread().getContextClassLoader())) {
			Object obj = cl.loadClass("HogeBean").getDeclaredConstructor().newInstance();
			BeanUtils.populate(obj, params);
		} catch (Exception e) {
			throw e;
		}
	}

	public static class TekitoClassLoader extends URLClassLoader {
		public TekitoClassLoader(URLClassLoader parent) {
			super(parent.getURLs());
		}

		// 親より先にロードする。すなわちTomcatのWebAppClassLoaderと同じ
		@Override
		protected Class<?> loadClass(String className, boolean resolve)
				throws ClassNotFoundException {
			synchronized (getClassLoadingLock(className)) {
				if (className.startsWith("java.")) {
					return super.loadClass(className, resolve);
				}

				Class<?> clazz = findClass(className);
				if (clazz == null) {
					clazz = findLoadedClass(className);
					try {
						if (clazz == null)
							clazz = getParent().loadClass(className);
					} catch (ClassNotFoundException ex) {
					}
				}
				if (resolve) {
					resolveClass(clazz);
				}
				return clazz;
			}
		}

		public void setString(String s) {
			System.out.println("セットされてしまった！");
		}

		public String getString() {
			return "ゲットされてしまった!";
		}
	}
}
