//Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//В итоге должно получится select * from students where name=Ivanov, country=Russia, city=Moscow, age=null
import java.util.HashMap;
import java.util.Map;
public class Main {


    public static void main(String[] args) {

        Map<String, String> filter = new HashMap<String,String>();
        filter.put("name","Ivanov");
        filter.put("country","Russia");
        filter.put("city","Moscow");
        filter.put("age",null);
        System.out.println(notNull(filter));
    }
    public static String notNull(Map<String, String> parametr)
    {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String,String> pair : parametr.entrySet())
        {
            if (pair.getValue() != null)
            {
                str.append(pair.getKey() +" = '" + pair.getValue()+"' and ");
            }
        }
        str.delete(str.toString().length()-5,str.toString().length());
        return str.toString();


    }
}