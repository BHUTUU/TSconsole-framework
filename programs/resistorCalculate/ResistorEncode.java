package io.github.bhutuu.resistor;
import java.util.Scanner;

public class ResistorEncode {
  public static void main(String[] args) {
    int a, back=0, brown=1, red=2, orange=3, yellow=4, green=5, blue=6, violet=7, grey=8, white=9;
    String firstColor, secondColor, thirdColor, fourthColor,  stValue, value, colorName;
    String validColors="black brown red orange yellow green blue violet grey white";
    Scanner bhu = new Scanner(System.in);
    Scanner st= new Scanner(System.in);
    System.out.print("\033[3;4;37mTSc\033[0;0;00m \033[1;37mEnter(\033[1;31mResistor/Value\033[1;37m)\033[1;32m~\033[1;37(\033[1;31mspecify\033[1;37m(\033[34mM\033[1;37m/\033[1;34mk\033[1;37m/\033[1;34mo\033[1;37m)\033[1;31m:\033[1;37m)> \033[00m");
    value=st.nextLine();
    int n=value.length();
    char ex=value.charAt(n-1);
    long numericalValue=Long.valueOf(value.substring(0, n-1));
    if (ex == 'M') {
      Long two=(numericalValue*1000000);
      stValue=Long.toString(two);
      evaluatColor(stValue);
    } else if (ex == 'k' || ex == 'K') {
      Long two=(numericalValue*1000);
      stValue=Long.toString(two);
      evaluatColor(stValue);
    } else if (ex == 'o' || ex == 'O') {
      stValue=Long.toString(numericalValue);
      evaluatColor(stValue);
    } else {
      System.out.println("Enter with a valid unit! either o or k");
    }
  }
  public static String evaluatColor(String stValue) {
    int a, back=0, brown=1, red=2, orange=3, yellow=4, green=5, blue=6, violet=7, grey=8, white=9;
    String firstColor, secondColor, thirdColor, fourthColor;
    if (stValue.length() == 1) {
      a=Integer.valueOf(stValue);
      firstColor="black";
      secondColor=colorDigit(a);
      thirdColor="black";
      //fourthColor="null";
      graphicalViewFourColorBand(firstColor, secondColor, thirdColor);
    } else if (stValue.length() == 2) {
      a=Integer.valueOf(stValue.substring(0, 1));
      firstColor=colorDigit(a); //never black
      a=Integer.valueOf(stValue.substring(1));
      secondColor=colorDigit(a);
      thirdColor="black";
      fourthColor="null";
      graphicalViewFourColorBand(firstColor, secondColor, thirdColor);
    } else if (stValue.length() == 3) {
      a=Integer.valueOf(stValue.substring(0, 1));
      firstColor=colorDigit(a); //never black
      a=Integer.valueOf(stValue.substring(1, 2));
      secondColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(2, 3));
      if (a == 0) {
        thirdColor="brown";
        //fourthColor="null";
        graphicalViewFourColorBand(firstColor, secondColor, thirdColor);
      } else {
        thirdColor=colorDigit(a);
        fourthColor="black";
        graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
      }
    } else if (stValue.length() == 4) {
      a=Integer.valueOf(stValue.substring(0, 1));
      firstColor=colorDigit(a); //never black
      a=Integer.valueOf(stValue.substring(1, 2));
      secondColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(3, 4));
      if (a > 0) {
        firstColor="Error";
        secondColor="Error";
        thirdColor="Error";
        fourthColor="Error";
      } else {
        a=Integer.valueOf(stValue.substring(2, 3));
        if (a == 0) {
          //for fourBand resistors! fourth band is of tolerance (not consideres in this program)
          thirdColor="red";
          //fourthColor="null";
          graphicalViewFourColorBand(firstColor, secondColor, thirdColor);
          //for fiveBand resistors! fifth band is of tolerance (not considered in this program)
          thirdColor=colorDigit(a);
          fourthColor="brown";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        } else {
          thirdColor=colorDigit(a);
          fourthColor="brown";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        }
      }
    } else if (stValue.length() == 5) {
      a=Integer.valueOf(stValue.substring(0, 1));
      firstColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(1, 2));
      secondColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(3, 5));
      if (a > 0) {
        firstColor="Error";
        secondColor="Error";
        thirdColor="Error";
        fourthColor="Error";
      } else {
        a=Integer.valueOf(stValue.substring(2, 3));
        if (a == 0) {
          thirdColor="orange";
          //fourthColor="null";
          graphicalViewFourColorBand(firstColor, secondColor, thirdColor);
          //for fiveBand resistors! fifth band is of tolerance (not considered in this program)
          thirdColor=colorDigit(a);
          fourthColor="red";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        } else {
          thirdColor=colorDigit(a);
          fourthColor="red";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        }
      }
    } else if (stValue.length() == 6) {
      a=Integer.valueOf(stValue.substring(0, 1));
      firstColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(1, 2));
      secondColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(3, 6));
      if (a > 0) {
        firstColor="Error";
        secondColor="Error";
        thirdColor="Error";
        fourthColor="Error";
      } else {
        a=Integer.valueOf(stValue.substring(2, 3));
        if (a == 0) {
          thirdColor="yellow";
          //fourthColor="null";
          graphicalViewFourColorBand(firstColor, secondColor, thirdColor);
          //for fiveBand resistors! fifth band is of tolerance (not considered in this program)
          thirdColor=colorDigit(a);
          fourthColor="orange";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        } else {
          thirdColor=colorDigit(a);
          fourthColor="orange";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        }
      }
    } else if (stValue.length() == 7) {
      a=Integer.valueOf(stValue.substring(0, 1));
      firstColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(1, 2));
      secondColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(3, 7));
      if (a > 0) {
        firstColor="Error";
        secondColor="Error";
        thirdColor="Error";
        fourthColor="Error";
      } else {
        a=Integer.valueOf(stValue.substring(2, 3));
        if (a == 0) {
          thirdColor="green";
          //fourthColor="null";
          graphicalViewFourColorBand(firstColor, secondColor, thirdColor);
          //for fiveBand resistors! fifth band is of tolerance (not considered in this program)
          thirdColor=colorDigit(a);
          fourthColor="yellow";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        } else {
          thirdColor=colorDigit(a);
          fourthColor="yellow";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        }
      }
    } else if (stValue.length() == 8) {
      a=Integer.valueOf(stValue.substring(0, 1));
      firstColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(1, 2));
      secondColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(3, 8));
      if (a > 0) {
        firstColor="Error";
        secondColor="Error";
        thirdColor="Error";
        fourthColor="Error";
      } else {
        a=Integer.valueOf(stValue.substring(2, 3));
        if (a == 0) {
          thirdColor="blue";
          //fourthColor="null";
          graphicalViewFourColorBand(firstColor, secondColor, thirdColor);
          //for fiveBand resistors! fifth band is of tolerance (not considered in this program)
          thirdColor=colorDigit(a);
          fourthColor="green";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        } else {
          thirdColor=colorDigit(a);
          fourthColor="green";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        }
      }
    } else if (stValue.length() == 9) {
      a=Integer.valueOf(stValue.substring(0, 1));
      firstColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(1, 2));
      secondColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(3, 9));
      if (a > 0) {
        firstColor="Error";
        secondColor="Error";
        thirdColor="Error";
        fourthColor="Error";
      } else {
        a=Integer.valueOf(stValue.substring(2, 3));
        if (a == 0) {
          thirdColor="violet";
          //fourthColor="null";
          graphicalViewFourColorBand(firstColor, secondColor, thirdColor);
          //for fiveBand resistors! fifth band is of tolerance (not considered in this program)
          thirdColor=colorDigit(a);
          fourthColor="blue";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        } else {
          thirdColor=colorDigit(a);
          fourthColor="blue";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        }
      }
    } else if (stValue.length() == 10) {
      a=Integer.valueOf(stValue.substring(0, 1));
      firstColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(1, 2));
      secondColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(3, 10));
      if (a > 0) {
        firstColor="Error";
        secondColor="Error";
        thirdColor="Error";
        fourthColor="Error";
      } else {
        a=Integer.valueOf(stValue.substring(2, 3));
        if (a == 0) {
          thirdColor="grey";
          //fourthColor="null";
          graphicalViewFourColorBand(firstColor, secondColor, thirdColor);
          //for fiveBand resistors! fifth band is of tolerance (not considered in this program)
          thirdColor=colorDigit(a);
          fourthColor="violet";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        } else {
          thirdColor=colorDigit(a);
          fourthColor="violet";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        }
      }
    } else if (stValue.length() == 11) {
      a=Integer.valueOf(stValue.substring(0, 1));
      firstColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(1, 2));
      secondColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(3, 11));
      if (a > 0) {
        firstColor="Error";
        secondColor="Error";
        thirdColor="Error";
        fourthColor="Error";
      } else {
        a=Integer.valueOf(stValue.substring(2, 3));
        if (a == 0) {
          thirdColor="white";
          //fourthColor="null";
          graphicalViewFourColorBand(firstColor, secondColor, thirdColor);
          //for fiveBand resistors! fifth band is of tolerance (not considered in this program)
          thirdColor=colorDigit(a);
          fourthColor="grey";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        } else {
          thirdColor=colorDigit(a);
          fourthColor="grey";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        }
      }
    } else if (stValue.length() == 12) {
      a=Integer.valueOf(stValue.substring(0, 1));
      firstColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(1, 2));
      secondColor=colorDigit(a);
      a=Integer.valueOf(stValue.substring(3, 12));
      if (a > 0) {
        firstColor="Error";
        secondColor="Error";
        thirdColor="Error";
        fourthColor="Error";
      } else {
        a=Integer.valueOf(stValue.substring(2, 3));
        if (a == 0) {
          //thirdColor="null";
          //fourthColor="null";
          //for fiveBand resistors! fifth band is of tolerance (not considered in this program)
          thirdColor=colorDigit(a);
          fourthColor="white";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        } else {
          thirdColor=colorDigit(a);
          fourthColor="white";
          graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        }
      }
    } else {
      System.out.println("Out of range........!!");
    }
    return stValue;
  }
  public static String colorDigit(int a) {
    String colorDigit="a"; //i put here "a" just to initialise the variable colorDigit.
    if (a == 0) {
      colorDigit="black";
    } else if (a == 1) {
      colorDigit="brown";
    } else if (a == 2) {
      colorDigit="red";
    } else if (a == 3) {
      colorDigit="orange";
    } else if (a == 4) {
      colorDigit="yellow";
    } else if (a == 5) {
      colorDigit="green";
    } else if (a == 6) {
      colorDigit="blue";
    } else if (a == 7) {
      colorDigit="violet";
    } else if (a == 8) {
      colorDigit="grey";
    } else if (a == 9) {
      colorDigit="white";
    } else {
      System.out.println("This situation doesn't exists lol!!");
    }
    return colorDigit;
  }
  public static String graphicalColor(String colorName) {
    String colorCode="a"; // i put here "a" just to initialise the variable colorCode.
    if (colorName == "black") {
      colorCode="\033[48;5;16m";
    } else if (colorName == "brown") {
      colorCode="\033[48;5;95m";
    } else if (colorName == "red") {
      colorCode="\033[48;5;88m";
    } else if (colorName == "orange") {
      colorCode="\033[48;5;202m";
    }else if (colorName == "yellow") {
      colorCode="\033[48;5;220m";
    } else if (colorName == "green") {
      colorCode="\033[48;5;84m";
    } else if (colorName == "blue") {
      colorCode="\033[48;5;21m";
    } else if (colorName == "violet") {
      colorCode="\033[48;5;54m";
    } else if (colorName == "grey") {
      colorCode="\033[48;5;240m";
    } else if (colorName == "white") {
      colorCode="\033[48;5;15m";
    } else if (colorName == "silver") {
      colorCode="\033[48;5;250m";
    } else if (colorName == "gold") {
      colorCode="\033[48;5;228m";
    } else {
      colorCode="\033[48;5;223m";
    }
    return colorCode;
  }
public static int graphicalViewFourColorBand(String firstColor, String secondColor, String thirdColor) {
    String colorName=firstColor;
    String S1=graphicalColor(colorName);
    colorName=secondColor;
    String S2=graphicalColor(colorName);
    colorName=thirdColor;
    String S3=graphicalColor(colorName);
    colorName="gold";
    String S4=graphicalColor(colorName);
    colorName="silver";
    String SC=graphicalColor(colorName);
    colorName="body";
    String SB=graphicalColor(colorName);
    String R0="\033[00;00;000m";
    System.out.println("\nFOUR BAND RESISTOR:\n");
    System.out.println("           "+SB+"                             "+R0);
    System.out.println("          "+SB+"  "+S1+"     "+SB+"  "+S2+"     "+SB+"  "+S3+"     "+SB+"   "+S4+"     "+SB+"  "+R0);
    System.out.println("          "+SB+"  "+S1+"     "+SB+"  "+S2+"     "+SB+"  "+S3+"     "+SB+"   "+S4+"     "+SB+"  "+R0);
    System.out.println(SC+"          "+SB+"  "+S1+"     "+SB+"  "+S2+"     "+SB+"  "+S3+"     "+SB+"   "+S4+"     "+SB+"  "+SC+"          "+R0);
    System.out.println("          "+SB+"  "+S1+"     "+SB+"  "+S2+"     "+SB+"  "+S3+"     "+SB+"   "+S4+"     "+SB+"  "+R0);
    System.out.println("          "+SB+"  "+S1+"     "+SB+"  "+S2+"     "+SB+"  "+S3+"     "+SB+"   "+S4+"     "+SB+"  "+R0);
    System.out.println("           "+SB+"                             "+R0);
    System.out.println("             ||     ||      ||      ||");
    System.out.println("             ||     ||      ||      []=>"+S4+"   "+R0+"GOLD");
    System.out.println("             ||     ||      ||");
    System.out.println("             ||     ||      []=>"+S3+"   "+R0+thirdColor.toUpperCase());
    System.out.println("             ||     ||");
    System.out.println("             ||     []=>"+S2+"   "+R0+secondColor.toUpperCase());
    System.out.println("             ||");
    System.out.println("             []=>"+S1+"   "+R0+firstColor.toUpperCase()+"\n");
    /* ART WORK
              ___________________________________
              | |    |  |    |  |    |   |    |  |
    __________| |    |  |    |  |    |   |    |  |_____________
    __________  |  1 |  | 2  |  | 3  |   | 4  |   _____________
              | |    |  |    |  |    |   |    |  |
              | |    |  |    |  |    |   |    |  |
              -----------------------------------
                  ||      ||      ||       ||
                  ||      ||      ||       []=> GOLD always hahahahaha ;)
                  ||      ||      []=>thirdColor.toUpperCase()
                  ||      []=>secondColor.toUpperCase()
                  []=>firstColor.toUpperCase()*/
    return 0;
  }
  public static int graphicalViewFiveColorBand(String firstColor, String secondColor, String thirdColor, String fourthColor) {
    String colorName=firstColor;
    String S1=graphicalColor(colorName);
    colorName=secondColor;
    String S2=graphicalColor(colorName);
    colorName=thirdColor;
    String S3=graphicalColor(colorName);
    colorName=fourthColor;
    String S4=graphicalColor(colorName);
    colorName="gold";
    String S5=graphicalColor(colorName);
    colorName="silver";
    String SC=graphicalColor(colorName);
    colorName="body";
    String SB=graphicalColor(colorName);
    String R0="\033[00;00;000m";
    System.out.println("\nFIVE BAND RESISTOR:\n");
    System.out.println("       "+SB+"                                   "+R0);
    System.out.println("      "+SB+"  "+S1+"     "+SB+"  "+S2+"     "+SB+"  "+S3+"     "+SB+"  "+S4+"     "+SB+"  "+S5+"     "+SB+"  "+R0);
    System.out.println("      "+SB+"  "+S1+"     "+SB+"  "+S2+"     "+SB+"  "+S3+"     "+SB+"  "+S4+"     "+SB+"  "+S5+"     "+SB+"  "+R0);
    System.out.println(SC+"      "+SB+"  "+S1+"     "+SB+"  "+S2+"     "+SB+"  "+S3+"     "+SB+"  "+S4+"     "+SB+"  "+S5+"     "+SB+"  "+SC+"      "+R0);
    System.out.println("      "+SB+"  "+S1+"     "+SB+"  "+S2+"     "+SB+"  "+S3+"     "+SB+"  "+S4+"     "+SB+"  "+S5+"     "+SB+"  "+R0);
    System.out.println("      "+SB+"  "+S1+"     "+SB+"  "+S2+"     "+SB+"  "+S3+"     "+SB+"  "+S4+"     "+SB+"  "+S5+"     "+SB+"  "+R0);
    System.out.println("       "+SB+"                                   "+R0);
    System.out.println("         ||     ||     ||     ||     ||");
    System.out.println("         ||     ||     ||     ||     []=>"+S5+"   "+R0+"GOLD");
    System.out.println("         ||     ||     ||     ||");
    System.out.println("         ||     ||     ||     []=>"+S4+"   "+R0+fourthColor.toUpperCase());
    System.out.println("         ||     ||     ||");
    System.out.println("         ||     ||     []=>"+S3+"   "+R0+thirdColor.toUpperCase());
    System.out.println("         ||     ||");
    System.out.println("         ||     []=>"+S2+"   "+R0+secondColor.toUpperCase());
    System.out.println("         ||");
    System.out.println("         []=>"+S1+"   "+R0+firstColor.toUpperCase()+"\n");
    /*ART WORK
          "                                        "
           _________________________________________
          | |    |  |    |  |    |  |    |  |    | |
    ______| |    |  |    |  |    |  |    |  |    | |_______
    ______  |  1 |  | 2  |  | 3  |  | 4  |  | 5  |  _______
          | |    |  |    |  |    |  |    |  |    | |
          | |    |  |    |  |    |  |    |  |    | |
           -----------------------------------------
              ||      ||      ||      ||      ||
              ||      ||      ||      ||      []=> GOLD always hahahahaha ;)
              ||      ||      ||      ||   
              ||      ||      ||      []=>thirdColor.toUpperCase()
              ||      ||      ||
              ||      ||      []=>secondColor.toUpperCase()
              ||      ||
              ||      []=>firstColor.toUpperCase()
              ||
              []=>firstColor.toUpperCase*/
    return 0;
  }
}
