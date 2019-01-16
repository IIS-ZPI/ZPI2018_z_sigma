import java.io.IOException;
import java.util.List;

public class Sigma {
    public static void main(String[] args) throws IOException {


        CreateTableA createTableA = new CreateTableA();

        List<TableA> tableA = createTableA.getTableA();


        System.out.println("wybierz walute, podaj 3 literowy kod");

        showCodeAndCurency(tableA);
        


    }

    public static void showCodeAndCurency(List<TableA> tableA) {
        for (int i = 0; i < tableA.get(0).getRates().size(); i++) {
            System.out.println(tableA.get(0).getRates().get(i).getCode() +
                    " --> " +
                    tableA.get(0).getRates().get(i).getCurrency());
        }
    }
}
