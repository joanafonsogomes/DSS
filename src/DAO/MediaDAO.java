package DAO;

import BLogic.Media;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MediaDAO implements Map<String, Media> {

    private static MediaDAO inst = null;

    private MediaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public static MediaDAO getInstance(){
        if(inst == null) {
            inst = new MediaDAO();
        }
        return inst;
    }

    @Override
    public int size() {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public boolean isEmpty() {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public boolean containsKey(Object o) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public boolean containsValue(Object o) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Media get(Object o) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Media put(String s, Media media) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Media remove(Object o) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public void putAll(Map<? extends String, ? extends Media> map) {
        throw new NullPointerException("Not implemented!");
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
    public Collection<Media> values() {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Set<Entry<String, Media>> entrySet(){
        throw new NullPointerException("Not implemented!");
    }
}
