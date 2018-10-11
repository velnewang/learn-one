package ck2.json;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ck2.bean.Inference;
import ck2.bean.character.Person;
import ck2.bean.military.Army;
import ck2.bean.military.Branch;
import ck2.bean.military.Troop;

class JsonIOTest {

    public static final String dateFormat = "y.M.d";

    private SimpleDateFormat simpleDateFormat;
    private ObjectMapper om;

    public void init() {
        simpleDateFormat = new SimpleDateFormat(dateFormat);
        om = new ObjectMapper();
        om.setDateFormat(simpleDateFormat);
        om.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    private Object initInference() {
        Inference i = new Inference();
//        i.persons = new HashSet<>();
        i.armies = new HashSet<>();

        i.persons.add(initPerson(1001, "The One"));
        i.persons.add(initPerson(9527, "The Commander"));
        i.armies.add(initArmy(4, 9527));
        return i;
    }

    private Person initPerson(int id, String name) {
        Person p = new Person();
        p.id = id;
        p.name = name;
        return p;
    }

    private Army initArmy(int id, int leader) {

        Map<String, Integer> squads = new HashMap<>();
        squads.put("LI", 300);
        squads.put("HI", 200);

        Troop t = new Troop();
        t.home = 404;
        try {
            t.date = simpleDateFormat.parse("769.1.1");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        t.squads = squads;

        Branch b = new Branch();
        b.id = 4002;
        b.type = "Heavy Light";
        b.troops = new Troop[] { t };
        b.leader = leader;

        Army a = new Army();
        a.id = id;
        a.name = "Fourth Army";
        a.branchs = new Branch[] { b };
        a.arrange = new int[] { 2 };
        a.location = 404;

        return a;
    }

    void toJson() {
        try {
            String savesJson = om.writeValueAsString(initInference());
            System.out.println(savesJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    void fromJson() {
        URL url = this.getClass().getClassLoader().getResource("saves.json");
        Inference i = null;

        try {
            i = om.readValue(url, Inference.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String savesJson = om.writeValueAsString(i);
            System.out.println(savesJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JsonIO().fromJson();
    }

}
