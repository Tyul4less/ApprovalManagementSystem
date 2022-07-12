package com.approval.test.system.common.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectUtil {
	private ObjectUtil() {
	}

	// 동일한 이름의 필드에 대해서 값을 복사한다.
	public static void CopyValue(Object source, Object target) {
		BeanUtils.copyProperties(source, target);

	}

	public static Map<String, Object> toMap(Object obj) {
		ObjectMapper oMapper = new ObjectMapper();
		// object -> Map
		return oMapper.convertValue(obj, new TypeReference<Map<String, Object>>(){});
	}

	// 객체가 빈 값인지 검사
	public static Boolean isNullOrEmpty(Object obj) {
		if (obj instanceof String) return obj == null || "".equals(obj.toString().trim());
		else if (obj instanceof List) return obj == null || ((List<?>) obj).isEmpty();
		else if (obj instanceof Map) return obj == null || ((Map<?,?>) obj).isEmpty();
		else if (obj instanceof Object[]) return obj == null || Array.getLength(obj) == 0;
		else return obj == null;
	}
	
	// List 내의 Map을 SEQ를 Key로 한 Map으로 재구성
	public static Map<BigInteger, Map<String, Object>> listToMapFromSeq(List<Map<String, Object>> params, String seq) {
		return params.stream()
				.collect(Collectors.toMap(x -> (BigInteger) x.get(seq), x -> x));
	}

	// Map내의 특정 Key로 Map<List<Map>> 를 구성.
	public static Map<Object, List<Map<String, Object>>> listToMapList(List<Map<String, Object>> params, String key) {
		
		Map<Object, List<Map<String, Object>>> result = new HashMap<Object, List<Map<String, Object>>>();
		params.forEach((v) -> result.computeIfAbsent(v.get(key), k -> new ArrayList<Map<String, Object>>()).add(v));
		return result;
	}

	// trim 은사이 공백을 제거할 수 없으므로 replace 사용
	public static String replaceCharacterAndSpace(Object value, String character) {
		if (value == null || character.isEmpty()) {
			return "";
		}

		return String.valueOf(value).replace(character, "").replace(" ", "");
	}

	public static Integer parseIntFromObject(Object data) {
		String replacedData = replaceCharacterAndSpace(data, ",");

		if (replacedData.isEmpty()) {
			return 0;
		}

		return Integer.parseInt(replacedData);
	}
}
