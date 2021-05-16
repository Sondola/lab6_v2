package com.thebestlab6.server.commands;

import com.thebestlab6.common.exceptions.WrongAmountOfElementsException;
import com.thebestlab6.server.utils.ResponseBuilder;

/**
 * Command for script executing from the certain file
 * @author Julia Polezhaeva
 * @version 1.1
 */

public class ExecuteScript implements Executable{
    /**
     * Constructor for the command
     */
    public ExecuteScript(){

    }

    /**
     * Command execution
     * @param str command argument
     * @return command result
     */
    @Override
    public boolean execute(String str, Object humanObj) {
        try{
            String [] commandArr = str.trim().split(" ");
            if(str.length() == 0 || commandArr.length != 1){
                throw new WrongAmountOfElementsException("Неправильное количество аргументов для команды");
            }
            return true;
        }
        catch (WrongAmountOfElementsException e){
            ResponseBuilder.appendError(e.getMessage());
            return false;
        }
    }

}