package com.jeeproject.ecommerce.services;

import com.jeeproject.ecommerce.Exception.CommandNotFoundException;
import com.jeeproject.ecommerce.model.Command;
import com.jeeproject.ecommerce.repository.CommandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CommandService {

    private final CommandRepo commandRepo;

    @Autowired
    public CommandService(CommandRepo commandRepo) {
        this.commandRepo = commandRepo;
    }

    public Command addCommand(Command command) {
        command.setCommandCode("pr-"+ UUID.randomUUID().toString());
        return commandRepo.save(command);
    }

    public List<Command> findAllCommand() {
        return commandRepo.findAll();
    }

    public Command updateCommand(Command command) {
        return commandRepo.save(command);
    }

    public Command findCommandByCommandCode(String commandCode) {
        return commandRepo.findCommandByCommandCode(commandCode)
                .orElseThrow(() -> new CommandNotFoundException("Command by code " + commandCode + " was not found"));
    }

    public void deleteCommand(String commandCode){
        commandRepo.deleteCommandByCommandCode(commandCode);
    }
}
