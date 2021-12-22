import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class User {

    @SerializedName("login")
    public String userLogin;

    @SerializedName("password")
    public String userPassword;

    public User() {

    }
    public User init(String userJSONFile) {
        String path = "src/test/resources/" + userJSONFile + ".json";
        User user = null;
        try {
            user = new Gson().fromJson(new FileReader(path), User.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}