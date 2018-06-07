package com.muxi.api.terminal.models.mappers.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.muxi.api.terminal.models.entities.Terminal;
import com.muxi.api.terminal.models.dto.TerminalDto;
import com.muxi.api.terminal.models.mappers.Mapper;

public class MapperTest {

	Mapper mapper;
	
	public MapperTest() {
		mapper = new Mapper();
	}
	
	@Test
	public void ConvertEntityToDtoShouldNotLoseData() {
		Terminal terminal = new Terminal();
		
		terminal.setLogic(564165);
		terminal.setModel("dasas");
		terminal.setMxf(3333);
		terminal.setMxr(23432);
		terminal.setPlat(32432432);
		terminal.setPtId("dffsffs");
		terminal.setSam(323);
		terminal.setSerial("werewrew");
		terminal.setVerFm("fsdffsd");
		terminal.setVersion("fsdfsfsd");
		
		TerminalDto terminalDto = mapper.Map(terminal);
		
		assertEquals(terminal.getLogic(), terminalDto.getLogic());
		assertEquals(terminal.getSerial(), terminalDto.getSerial());
		assertEquals(terminal.getModel(), terminalDto.getModel());
		assertEquals(terminal.getSam(), terminalDto.getSam());
		assertEquals(terminal.getPlat(), terminalDto.getPlat());
		assertEquals(terminal.getVersion(), terminalDto.getVersion());
		assertEquals(terminal.getMxr(), terminalDto.getMxr());
		assertEquals(terminal.getMxf(), terminalDto.getMxf());
		assertEquals(terminal.getVerFm(), terminalDto.getVerFm());
	}
	
	
	@Test
	public void ConvertDtoToEntityShouldNotLoseData() {
		TerminalDto terminalDto = new TerminalDto();
		
		terminalDto.setLogic(564165);
		terminalDto.setModel("dasas");
		terminalDto.setMxf(3333);
		terminalDto.setMxr(23432);
		terminalDto.setPlat(32432432);
		terminalDto.setPtId("dffsffs");
		terminalDto.setSam(323);
		terminalDto.setSerial("werewrew");
		terminalDto.setVerFm("fsdffsd");
		terminalDto.setVersion("fsdfsfsd");
		
		Terminal terminalEntity = mapper.Map(terminalDto);
		
		assertEquals(terminalEntity.getLogic(), terminalDto.getLogic());
		assertEquals(terminalEntity.getSerial(), terminalDto.getSerial());
		assertEquals(terminalEntity.getModel(), terminalDto.getModel());
		assertEquals(terminalEntity.getSam(), terminalDto.getSam());
		assertEquals(terminalEntity.getPlat(), terminalDto.getPlat());
		assertEquals(terminalEntity.getVersion(), terminalDto.getVersion());
		assertEquals(terminalEntity.getMxr(), terminalDto.getMxr());
		assertEquals(terminalEntity.getMxf(), terminalDto.getMxf());
		assertEquals(terminalEntity.getVerFm(), terminalDto.getVerFm());
	}
	
	
}
