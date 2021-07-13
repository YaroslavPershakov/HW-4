package MyUtil.IO;

public class Out<Object> {

    private void out(Object line) {
        System.out.print(line);
    }

    private void outLn(Object line) {
        System.out.println(line);
    }

    public void write(Object line) {
        out(line);
    }

    public void writeln(Object line) {
        outLn(line);
    }

    /*
    public void writeList(Object list) {
        for (int i = 0; i < size(); i++) {
            System.out.println((get(i)));
        }
    }
    */
}
