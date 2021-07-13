package MyUtil.Util.List;

public interface List<Object> {
    int size();
    void add(Object data);
    void add(Object data, int id);
    void delete(int id);
    Object get(int id);
}
