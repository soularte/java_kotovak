package kkotova.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args){
    String[] langs ={"java", "c4", "Python", "PHP"};

    List<String> languarges = Arrays.asList("java", "c4", "Python", "PHP");

for (String l : languarges ) {
  System.out.println("Я хочу выучить " + l);
}

for (int i = 0; i < languarges.size(); i++ ) {
  System.out.println("Я хочу выучить " + languarges.get(i));
}

  }
}
