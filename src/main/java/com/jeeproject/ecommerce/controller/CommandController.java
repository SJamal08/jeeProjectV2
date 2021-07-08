package com.jeeproject.ecommerce.controller;

import com.jeeproject.ecommerce.model.Command;
import com.jeeproject.ecommerce.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/command")
public class CommandController {

    private final CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Command>> getAllCommands () {
        List<Command> commands = commandService.findAllCommand();
        return new ResponseEntity<>(commands, HttpStatus.OK);
    }

    @GetMapping("/find/{commandCode}")
    public ResponseEntity<Command> getCommandByCommandCode (@PathVariable("commandCode") String commandCode) {
        Command command = commandService.findCommandByCommandCode(commandCode);
        return new ResponseEntity<>(command, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Command> addCommand(@RequestBody Command command) {
        Command newCommand = commandService.addCommand(command);
        return new ResponseEntity<>(newCommand, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Command> updateCommand(@RequestBody Command command) {
        Command updateCommand = commandService.updateCommand(command);
        return new ResponseEntity<>(updateCommand, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{commandCode}")
    public ResponseEntity<?> deleteCommand(@PathVariable("commandCode") String commandCode) {
        commandService.deleteCommand(commandCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
