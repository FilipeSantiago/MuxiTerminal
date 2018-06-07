package com.muxi.api.terminal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muxi.api.terminal.exceptions.InvalidRequestException;
import com.muxi.api.terminal.models.dto.TerminalDto;
import com.muxi.api.terminal.models.entities.Terminal;
import com.muxi.api.terminal.models.mappers.Mapper;
import com.muxi.api.terminal.repositories.TerminalRepository;

@Service
public class TerminalService {

	private TerminalRepository terminalRepository;
	private Mapper mapper;
	
	@Autowired
    public void setTerminalRepository(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }
	
	public TerminalService(){
		mapper = new Mapper();
	}
		
	public TerminalDto createTerminalByString(String terminalStr) {
		
		String incorrectEntryErrorMessage = "Incorrect entry, please follow the standart: \"[int:required];[string:required];[string:required]"
										 +  ";[int:required:>=0];[string];[int];[string:required];[int];[int];[string]\"";
		
		try {
			TerminalDto terminal = new TerminalDto(terminalStr);
			Terminal toSaveEntity = mapper.Map(terminal);
			Terminal savedTerminal = terminalRepository.save(toSaveEntity);
			
			return mapper.Map(savedTerminal);
		}catch(Exception e) {
			throw new InvalidRequestException(incorrectEntryErrorMessage);
		}	
	}
	
	public TerminalDto findById(int id) {
		Terminal terminal = terminalRepository.findOne(id);
		return mapper.Map(terminal);
	}	
	
	public TerminalDto saveOrUpdate(TerminalDto terminalDto) {
		Terminal toSaveEntity = mapper.Map(terminalDto);
		Terminal savedTerminal = terminalRepository.save(toSaveEntity);
		return mapper.Map(savedTerminal);
	}	

}
