package Services;

import Exceptions.GuestAlreadyExistsException;
import Exceptions.GuestNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EventManager {

    ArrayList<String> guests = new ArrayList<>();

    public void addGuest(String guest) throws Exception {
        if (guest.length() < 2) {
            throw new Exception("O nome do participante deve ter ao menos 2 caracteres!");
        }

        if (this.hasGuest(guest)) {
            throw new GuestAlreadyExistsException("Esse participante já está cadastrado na lista!");
        }

        this.guests.add(guest);
    }

    public void removeGuestById(Integer id) throws Exception {
        if (id < 0 || id > this.guests.size()) {
            throw new ArrayIndexOutOfBoundsException("O índice informado parece não ser válido!");
        }

        this.guests.remove((int) id);
    }

    public void removeGuestByName(String name) throws Exception {
        if (!this.hasGuest(name)) {
            throw new GuestNotFoundException("Não foi encontrado nenhum participante com o nome informado!");
        }

        this.guests.remove(name);
    }

    public ArrayList<String> getAll() {
        return this.guests;
    }

    public boolean hasGuest(String name) {
        return this.guests.contains(name);
    }

    public void sort() {
        Collections.sort(this.guests);
    }

    public void clear() {
        this.guests = new ArrayList<>();
    }

}
