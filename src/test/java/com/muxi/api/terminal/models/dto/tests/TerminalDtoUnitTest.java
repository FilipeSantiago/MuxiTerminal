package com.muxi.api.terminal.models.dto.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.muxi.api.terminal.models.dto.TerminalDto;

public class TerminalDtoUnitTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void RequestsWithoutLogicShouldRaiseInvalidRequestException() throws Exception {
		
		String requestWithoutLogic = ";123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";
		new TerminalDto(requestWithoutLogic);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void RequestsWithoutSerialShouldRaiseInvalidRequestException() throws Exception {
		
		String requestWithoutSerial = "44332211;;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";
		new TerminalDto(requestWithoutSerial);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void RequestsWithoutModelShouldRaiseInvalidRequestException() throws Exception {
		String requestWithoutModel = "44332211;123;;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";
		new TerminalDto(requestWithoutModel);	
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void RequestsWithoutVersionShouldRaiseInvalidRequestException() throws Exception {
		String requestWithoutVersion = "44332211;123;PWWIN;0;F04A2E4088B;4;;0;16777216;PWWIN";
		new TerminalDto(requestWithoutVersion);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void RequestsWithSamLessThanZeroShouldRaiseInvalidRequestException() throws Exception {
		String requestWithSamLessThanZero = "44332211;123;PWWIN;-1;F04A2E4088B;4;;0;16777216;PWWIN";
		new TerminalDto(requestWithSamLessThanZero);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void RequestsWithInvalidTypesShouldRaiseInvalidRequestException() throws Exception {
		String requestWithInvalidTypes = "4433221a1;123;PWWIN;0a;F04A2E4088B;4a;8.00b3;0a;a16777216;PWWIN";
		new TerminalDto(requestWithInvalidTypes);	
	}
	
	@Test
	public void GoodRequestsShouldBeInterpretedCorrectly() throws Exception {
		String goodRequest = "44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";
		TerminalDto response = new TerminalDto(goodRequest);
		
		assertEquals(44332211, response.getLogic());
		assertEquals("123", response.getSerial());
		assertEquals("PWWIN", response.getModel());
		assertEquals(0, response.getSam());
		assertEquals(4, response.getPlat());
		assertEquals("8.00b3", response.getVersion());
		assertEquals(0, response.getMxr());
		assertEquals(16777216, response.getMxf());
		assertEquals("PWWIN", response.getVerFm());
	}
}
