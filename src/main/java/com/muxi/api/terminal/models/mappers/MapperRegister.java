package com.muxi.api.terminal.models.mappers;

import java.util.HashMap;
import java.util.Map;

import com.muxi.api.terminal.models.dto.TerminalDto;
import com.muxi.api.terminal.models.entities.Terminal; 
  


public class MapperRegister {

	@SuppressWarnings("rawtypes")
	static Map<Class, Class> mappersRules = new HashMap<>();
	
	private static void registerDtoToEntityMappers() {
		
		if(mappersRules.isEmpty()) {
			mappersRules.put(TerminalDto.class, Terminal.class);
			mappersRules.put(Terminal.class, TerminalDto.class);
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public static Class getClassTypeOfMapperResult(Class inputClassType) {
		registerDtoToEntityMappers();		
		return mappersRules.get(inputClassType);
	}
	
}
