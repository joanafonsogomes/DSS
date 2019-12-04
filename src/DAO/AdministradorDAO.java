package DAO;

import BLogic.Administrador;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class AdministradorDAO implements Map<String, Administrador> {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object o) {
        return false;
    }

    @Override
    public boolean containsValue(Object o) {
        return false;
    }

    @Override
    public Administrador get(Object o) {
        return null;
    }

    @Override
    public Administrador put(String s, Administrador administrador) {
        return null;
    }

    @Override
    public Administrador remove(Object o) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Administrador> map) {

    }

    @Override
    public void clear() {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Set<String> keySet() {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Collection<Administrador> values() {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Set<Entry<String, Administrador>> entrySet() {
        throw new NullPointerException("Not implemented!");
    }
}
