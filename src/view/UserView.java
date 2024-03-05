package view;

import Core.User;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserView {
    public void saveInfile(User user) throws IOException {
        try (FileWriter fw = new FileWriter("Users.txt")){
            StringBuilder sb = new StringBuilder();
            for (String name: user.getFullName()) {
                sb.append(name).append(" ");
            }
            sb.append("\n").append("Дата рождения - ").append(user.getBirthday()).append("\n")
                    .append("Пол - ").append(user.getSex()).append("\n")
                    .append("Номер телефона - ").append(user.getPhoneNumber());
            fw.write(String.valueOf(sb));
            fw.flush();
        }
    }
    public User createUser() throws IOException {
        try {
            String data = prompt("Введите данные пользователя через пробел (ФИО пол (f - женщина, m - мужчина) " +
                    "дата рождения (dd.mm.yyyy) номер телеофна (без 8)");

            String[] arrayData = data.split(" ");
            checkData(arrayData);
            checkSex(arrayData);

            List<String> fullName = new ArrayList<>(Arrays.asList(arrayData).subList(0, 3));

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date birthdate = dateFormat.parse(arrayData[4]);

            Long phoneNumber = Long.parseLong(arrayData[5]);

            return new User(fullName, arrayData[3], birthdate, phoneNumber);
        } catch (ParseException e) {
            System.out.println("Ошибка формата даты: " + e.getMessage());
            return new User();
        }
    }

    public void checkSex(String[] data) throws IOException{
        if (!data[3].equals("f") && !data[3].equals("m")){
            throw new IOException("Вы ввели пол в неверном формате");
        }
    }

    public void checkData(String[] data) throws IOException {
        if (data.length > 6) {
            throw new IOException("Неверно введены данные. Введено слишком много данных");
        } else if (data.length < 6) {
            throw new IOException("Неверно введены данные. Введено слишком мало данных");
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }
}
