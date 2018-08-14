package com.prudential.core.common;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ThreadLocalVars {

	private static final ThreadLocal<String> currentUser = new ThreadLocal<>();

	private static final ThreadLocal<Map<String, Object>> auditStoredValues = new ThreadLocal<>();

	public static String getCurrentUser() {
		return currentUser.get();
	}

	public static void set(String user) {
		currentUser.set(user);
	}

	public static void remove() {
		currentUser.remove();
	}

	public static void initAuditStoredValues() {
		if (auditStoredValues.get() == null) {
			Map<String, Object> initialMap = new HashMap<String, Object>();
			initialMap.put("UNIQUEID", UUID.randomUUID().toString());
			auditStoredValues.set(initialMap);
		}
	}

	public static void putAuditStoredValues(String key, Object value) {
		initAuditStoredValues();

		auditStoredValues.get().put(key, value);
	}

	public static Object getAuditStoredValue(String key) {
		if (auditStoredValues.get() == null) {
			return null;
		}

		return auditStoredValues.get().get(key);
	}

	public static void setAuditStoredValues(Map<String, Object> values) {
		auditStoredValues.set(values);
	}

	public static void removeAuditStoredValues() {
		auditStoredValues.remove();
	}

}
