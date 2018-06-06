package com.muxi.api.terminal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.muxi.api.terminal.models.entities.Terminal;

public interface TerminalRepository extends CrudRepository<Terminal, Integer> { }
