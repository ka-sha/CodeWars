public class Car {

    public Layer body, chassis;

    public Car(int length, int doors) throws Exception{
        if (length < 7 || (length - 3) / 2 < doors || doors < 1) throw new Exception("Wrong data!");

        this.body = new Layer(length, doors);
        this.chassis = new Layer(length);
    }
}

class Layer {
    public String component;

    public Layer(int length, int doors) {
        StringBuilder up = new StringBuilder(" ");
        StringBuilder middle = new StringBuilder("|");

        for (int i = 1; i < length - 2; i++)
            up.append("_");
        up.append("\n");

        for (int i = 1; i < length - 2; i++)
            middle.append(" ");
        middle.append("\\\n");

        int frontDoors = ((doors & 1) == 1) ? doors / 2 + 1 : doors / 2;
        int backDoors = doors - frontDoors;
        int i = 1;

        while (backDoors-- != 0) {
            middle.setCharAt(i++, '[');
            middle.setCharAt(i++, ']');
        }

        i = middle.length() - 3;
        while (frontDoors-- != 0) {
            middle.setCharAt(i--, ']');
            middle.setCharAt(i--, '[');
        }

        component = up.append(middle).toString();
    }

    public Layer(int length) {
        StringBuilder down = new StringBuilder("-o");
        for (int i = 2; i < length - 1; i++)
            down.append('-');
        down.append('\'');
        down.setCharAt(length - 3, 'o');

        if (length < 12) component = down.toString();
        else {
            int moreAxle = (length - 12) / 2 + 1;
            int backAxles = ((moreAxle & 1) == 1) ? moreAxle / 2 + 1 : moreAxle / 2;
            int frontAxles = moreAxle - backAxles;

            int i = 3;
            while (backAxles-- != 0) {
                down.setCharAt(i, 'o');
                i += 2;
            }

            i = down.length() - 5;
            while (frontAxles-- != 0) {
                down.setCharAt(i, 'o');
                i -= 2;
            }

            component = down.toString();
        }
    }
}
