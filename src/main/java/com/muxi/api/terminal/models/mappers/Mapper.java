package com.muxi.api.terminal.models.mappers;

import org.modelmapper.ModelMapper;

import com.muxi.api.terminal.models.dto.AbstractDto;
import com.muxi.api.terminal.models.dto.TerminalDto;
import com.muxi.api.terminal.models.entities.AbstractEntity;
import com.muxi.api.terminal.models.entities.Terminal;

public class Mapper {
	
	private ModelMapper modelMapper;
	
	public Mapper() {
		modelMapper = new ModelMapper();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T extends AbstractDto> T Map(AbstractEntity entity){
		Class returnType = MapperRegister.getClassTypeOfMapperResult(entity.getClass());
		
		AbstractDto dto = (AbstractDto) modelMapper.map(entity, returnType);	
		
		return (T) dto;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T extends AbstractEntity> T Map(AbstractDto dto){
		Class returnType = MapperRegister.getClassTypeOfMapperResult(dto.getClass());
		
		AbstractEntity entity = (AbstractEntity) modelMapper.map(dto, returnType);	
		
		return (T) entity;
	}
	
}
