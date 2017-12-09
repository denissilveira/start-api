package tech.yotz.start.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SenderMessageEnum {
	
	STARTUP("STARTUP", "ROLE_STARTUP"), 
	PARTNER("PARTNER", "ROLE_PARTNER");

	private final String code;
	private final String role;
	private static final Map<String, SenderMessageEnum> CODE_MAP = new HashMap<String, SenderMessageEnum>();
	
	static {
    	for(SenderMessageEnum value : values()){
    		CODE_MAP.put(value.code, value);
    	}
    }
	
	public static SenderMessageEnum getByCode(String code){
        return CODE_MAP.get(code);
    }

	private SenderMessageEnum(final String code, final String role) {
		this.code = code;
		this.role = role;
	}

	public String getRole() {
		return role;
	}
	public String getCode() {
		return code;
	}

}