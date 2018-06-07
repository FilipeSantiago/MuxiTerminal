package com.muxi.api.terminal.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.muxi.api.terminal.exceptions.InvalidRequestException;
import com.muxi.api.terminal.models.dto.TerminalDto;
import com.muxi.api.terminal.models.entities.Terminal;
import com.muxi.api.terminal.models.feedback.ErrorFeedback;
import com.muxi.api.terminal.services.TerminalService;


@RestController
@RequestMapping("terminals")
public class TerminalController {

	private TerminalService terminalService;
	
	@Autowired
    public void setTerminalService(TerminalService terminalService) {
        this.terminalService = terminalService;
    }
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<TerminalDto> createTerminal(@RequestBody String terminalStr) {
		TerminalDto terminal = terminalService.createTerminalByString(terminalStr);
		ResponseEntity<TerminalDto> response = ResponseEntity.status(HttpStatus.ACCEPTED).body(terminal);
		
		return response;
	}
	
	@RequestMapping(value = "/{logic}", method = RequestMethod.PUT)
	public ResponseEntity<TerminalDto> updateTerminal(@PathVariable("logic") int logic, @RequestBody TerminalDto terminal){
		TerminalDto savedTerminal = this.terminalService.saveOrUpdate(terminal);
		ResponseEntity<TerminalDto> response = ResponseEntity.status(HttpStatus.ACCEPTED).body(savedTerminal);

		return response;
	}
	
	@RequestMapping(value = "/{logic}", method = RequestMethod.GET)
	public ResponseEntity<TerminalDto> findTerminal(@PathVariable("logic") int logic){
		TerminalDto terminal = this.terminalService.findById(logic);
		ResponseEntity<TerminalDto> response = ResponseEntity.status(HttpStatus.ACCEPTED).body(terminal);

		return response;
	}
	
	@RequestMapping(value = "/{logic}", method = RequestMethod.DELETE)
	public ResponseEntity<TerminalDto> deleteTerminal(@PathVariable("logic") int logic){		
		ResponseEntity<TerminalDto> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		
		return response;
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.POST)
	public ResponseEntity<ErrorFeedback> createTerminal(@RequestBody TerminalDto terminal){
		ErrorFeedback errorMessage = new ErrorFeedback("/terminals/json/", "Inserts by json are unavailable in this version");
		ResponseEntity<ErrorFeedback> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);

		return response;
	}
	
	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<ErrorFeedback> handleInvalidRequestException(HttpServletRequest req, Exception ex){
		
		ErrorFeedback feedback = new ErrorFeedback(req.getRequestURI(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(feedback);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorFeedback> handleException(HttpServletRequest req, Exception ex){
		
		ErrorFeedback feedback = new ErrorFeedback(req.getRequestURI(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(feedback);
	}
	
}
