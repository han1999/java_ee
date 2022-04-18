import beans.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/18
 **/

public class JsonTest {

    @Test
    public void testObjectToJson() {
        User user = new User("zhangsan", "123456");
        System.out.println("user = " + user);
        String jsonStr = "{\"username\":" + "\"" + user.getUsername() + "\"" + ",\"password\":\"" + user.getPassword() + "\"}";
        System.out.println("jsonStr = " + jsonStr);
    }

    @Test
    public void testObjectToJson2() {
        User user = new User("zhangsan", "123456");
        Gson gson = new Gson();
        String s = gson.toJson(user);
        System.out.println("s = " + s);

        User user2 = new User("lisi", "7894564");
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        String s1 = gson.toJson(users);
        System.out.println("s1 = " + s1);
    }

    @Test
    public void testJsonToObject() {
        String jsonStr = "{\"username\":\"zhangsan\",\"password\":\"123456\"}";
        Gson gson = new Gson();
        User user = gson.fromJson(jsonStr, User.class);
        System.out.println("user = " + user);
    }

    @Test
    public void testJsonToObject2() {
        String jsonStr = "[{\"username\":\"zhangsan\",\"password\":\"123456\"},{\"username\":\"lisi\",\"password\":\"7894564\"}]";
        JsonElement jsonElement = JsonParser.parseString(jsonStr);
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        Gson gson = new Gson();
        for (JsonElement element : asJsonArray) {
            User user = gson.fromJson(element, User.class);
            System.out.println("user = " + user);
        }
    }
}
