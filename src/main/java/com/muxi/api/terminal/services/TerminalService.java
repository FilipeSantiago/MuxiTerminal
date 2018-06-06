package com.muxi.api.terminal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muxi.api.terminal.exceptions.InvalidRequestException;
import com.muxi.api.terminal.models.entities.Terminal;
import com.muxi.api.terminal.repositories.TerminalRepository;

@Service
public class TerminalService {

	private TerminalRepository terminalRepository;
	
	@Autowired
    public void setTerminalRepository(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }
	
	public Terminal createTerminalByString(String terminalStr) {
		
		String incorrectEntryErrorMessage = "Incorrect entry, please follow the standart: \"[int:required];[string:required];[string:required]"
										 +  ";[int:required:>=0];[string];[int];[string:required];[int];[int];[string]\"";
		
		try {
			Terminal terminal = new Terminal(terminalStr);
			Terminal savedTerminal = terminalRepository.save(terminal);
			return savedTerminal;
		}catch(Exception e) {
			throw new InvalidRequestException(incorrectEntryErrorMessage);
		}	
	}
	
	public Terminal findById(int id) {
		return terminalRepository.findOne(id);
	}	
	
	public Terminal saveOrUpdate(Terminal terminal) {
		return terminalRepository.save(terminal);
	}	

}
