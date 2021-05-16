package com.thebestlab6.server.commands;

import com.thebestlab6.common.data.HumanBeing;
import com.thebestlab6.common.exceptions.*;
import com.thebestlab6.server.utils.CollectionManager;
import com.thebestlab6.server.utils.ResponseBuilder;

import javax.xml.stream.XMLStreamException;

public class Update implements Executable{
    private CollectionManager collectionManager;

    public Update(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public boolean execute(String str, Object obj) {
        try {
            if (str.length() == 0) throw new WrongAmountOfElementsException("Неправильное количество аргументов для команды");
            int id = Integer.parseInt(str);
            HumanBeing human = collectionManager.getById(id);
            if (human != null) {
                human = (HumanBeing) obj;
                collectionManager.setNewHuman(id, human);
                ResponseBuilder.append("Данные были успешно обновлены!");
            }
            else throw new WrongIdException("Не найден человек с таким id");
            return true;
        } catch (WrongAmountOfElementsException | WrongIdException e) {
            ResponseBuilder.appendError(e.getMessage());
            return false;
        } catch (NumberFormatException e) {
            ResponseBuilder.appendError("Некорректно введен id");
            return false;
        }
    }
}
