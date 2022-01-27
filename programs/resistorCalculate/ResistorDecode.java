package io.github.bhutuu.resistor;
import java.util.Scanner;

public class ResistorDecode {
  public static void main(String[] args) {
    int a, back=0, brown=1, red=2, orange=3, yellow=4, green=5, blue=6, violet=7, grey=8, white=9;
    String firstColor, secondColor, thirdColor, fourthColor,  stValue, value, colorName;
    String validColors="black brown red orange yellow green blue violet grey white";
    Scanner bhu = new Scanner(System.in);
    Scanner st= new Scanner(System.in);
    System.out.print("\033[3;4;37mTSc\033[0;0;00m \033[1;37mEnter(\033[1;31mNumber/of/bands\033[32m(\033[1;36m4\033[1;31m or \033[1;36m5\033[1;32m)\033[1;37m)> \033[0;00m");
    int band=bhu.nextInt();
    if (band==4) {
      System.out.println("((Index.)color): (0.)black, (1.)brown, (2.)red, (3.)orange, (4.)yellow,\n                 (5.)green, (6.)blue, (7.)violet, (8)grey, (9.)white\n\n");
      System.out.print("\033[3;4;37mTSc \033[0;0;00m\033[1;37mEnter(\033[1;31mIndex/of/first/band\033[1;37m)> \033[0;00m");
      a=bhu.nextInt();
      firstColor=colorDigit(a);
      System.out.print("\033[3;4;37mTSc \033[0;0;00m\033[1;37mEnter(\033[1;31mIndex/of/second/band\033[1;37m)> \033[0;00m");
      a=bhu.nextInt();
      secondColor=colorDigit(a);
      System.out.print("\033[3;4;37mTSc \033[0;0;00m\033[1;37mEnter(\033[1;31mIndex/of/third/band\033[1;37m)> \033[0;00m");
      a=bhu.nextInt();
      thirdColor=colorDigit(a);
      fourthColor="null";
      if (validColors.contains(firstColor) && validColors.contains(secondColor) && validColors.contains(thirdColor)) {
        decodeMain(band, firstColor, secondColor, thirdColor, fourthColor);
      } else {
        System.out.println("Enter valid colors only! list:\n"+validColors);
      }
    } else if (band==5) {
      System.out.println("((Index.)color): (0.)black, (1.)brown, (2.)red, (3.)orange, (4.)yellow,\n                 (5.)green, (6.)blue, (7.)violet, (8)grey, (9.)white\n\n");
      System.out.print("\033[3;4;37mTSc \033[0;0;00m\033[1;37mEnter(\033[1;31mIndex/of/first/band\033[1;37m)> \033[0;00m");
      a=bhu.nextInt();
      firstColor=colorDigit(a);
      System.out.print("\033[3;4;37mTSc \033[0;0;00m\033[1;37mEnter(\033[1;31mIndex/of/second/band\033[1;37m)> \033[0;00m");
      a=bhu.nextInt();
      secondColor=colorDigit(a);
      System.out.print("\033[3;4;37mTSc \033[0;0;00m\033[1;37mEnter(\033[1;31mIndex/of/third/band\033[1;37m)> \033[0;00m");
      a=bhu.nextInt();
      thirdColor=colorDigit(a);
      System.out.print("\033[3;4;37mTSc \033[0;0;00m\033[1;37mEnter(\033[1;31mIndex/of/fourth/band\033[1;37m)> \033[0;00m");
      a=bhu.nextInt();
      fourthColor=colorDigit(a);
      if (validColors.contains(firstColor) && validColors.contains(secondColor) && validColors.contains(thirdColor) && validColors.contains(fourthColor)) {
        decodeMain(band, firstColor, secondColor, thirdColor, fourthColor);
      } else {
        System.out.println("\033[1;32m[\033[1;31m!\033[1;37m] \033[1;34mEnter valid colors only! list:\n\033[0;00m"+validColors);
      }
    } else {
      System.out.println("\033[1;32m[\033[1;31m!\033[1;32m] \033[1;34mChoose whether 4 or 5 and nothing else!\033[0;00m");
    }
  }
  public static int decodeMain(int band, String firstColor, String secondColor, String thirdColor, String fourthColor) {
    String colorName="null"; //here i have given value "null" just to initialise the variables
    int firstDigit, secondDigit;
    if (band == 4) {
      colorName=firstColor;
      firstDigit=significantDigit(colorName);
      colorName=secondColor;
      secondDigit=significantDigit(colorName);
      colorName=thirdColor;
      String thirdDigit=multiplierDigit(colorName);
      //calculations------->
      String var1=Integer.toString(firstDigit);
      String var2=Integer.toString(secondDigit);
      String var3=var1+var2;
      long significantDigit=Long.valueOf(var3);
      if (thirdDigit == "p" || thirdDigit == "pp") {
        System.out.println("\033[1;32m[\033[1;31m!\033[1;32m] \033[1;34mSorry but this program is under developement!\033[0;00m");
      } else {
        long multiplierDigit=Long.valueOf(thirdDigit);
        String resistorValue=resistorValue(significantDigit, multiplierDigit);
        graphicalViewFourColorBand(firstColor, secondColor, thirdColor);
        System.out.println("RESISTOR VALUE: "+resistorValue);
      }
    } else if (band == 5) {
      colorName=firstColor;
      firstDigit=significantDigit(colorName);
      colorName=secondColor;
      secondDigit=significantDigit(colorName);
      colorName=thirdColor;
      int thirdDigit=significantDigit(colorName);
      colorName=fourthColor;
      String fourthDigit=multiplierDigit(colorName);
      //calculation------->
      String var1=Integer.toString(firstDigit);
      String var2=Integer.toString(secondDigit);
      String var3=Integer.toString(thirdDigit);
      String var4=var1+var2+var3;
      long significantDigit=Long.valueOf(var4);
      if (fourthDigit == "p" || fourthDigit == "pp") {
        System.out.println("\033[1;32m[\033[1;31m!\033[1;32m] \033[1;34mSorry but this program is under developement!\033[0;00m");
      } else {
        long multiplierDigit=Long.valueOf(fourthDigit);
        String resistorValue=resistorValue(significantDigit, multiplierDigit);
        graphicalViewFiveColorBand(firstColor, secondColor, thirdColor, fourthColor);
        System.out.println("RESISTOR VALUE: "+resistorValue);
      }
    }
    return 0;
  }
  public static int significantDigit(String colorName) {
    int digitValue=0; // here i have given value 0 just to initialise the variable digitValue.
    if (colorName == "black") {
      digitValue=0;
    } else if (colorName == "brown") {
      digitValue=1;
    } else if (colorName == "red") {
      digitValue=2;
    } else if (colorName == "orange") {
      digitValue=3;
    } else if (colorName == "yellow") {
      digitValue=4;
    } else if (colorName == "green") {
      digitValue=5;
    } else if (colorName == "blue") {
      digitValue=6;
    } else if (colorName == "violet") {
      digitValue=7;
    } else if (colorName == "grey") {
      digitValue=8;
    } else if (colorName == "white") {
      digitValue=9;
    }
    return digitValue;
  }
  public static String multiplierDigit(String colorName) {
    String digitValue="0"; //here i have given value 0 just to initialise the variable digitvalue.
    if (colorName == "black") {
      digitValue="1";
    } else if (colorName == "brown") {
      digitValue="10";
    } else if (colorName == "red") {
      digitValue="100";
    } else if (colorName == "orange") {
      digitValue="1000";
    } else if (colorName == "yellow") {
      digitValue="10000";
    } else if (colorName == "green") {
      digitValue="100000";
    } else if (colorName == "blue") {
      digitValue="1000000";
    } else if (colorName == "violet") {
      digitValue="10000000";
    } else if (colorName == "silver") {
      digitValue="pp";
    } else if (colorName == "gold") {
      digitValue="p";
    }
    return digitValue;
  }
  public static String resistorValue(long significantDigit, long multiplierDigit) {
    String resistorValue="a"; //i have given here the value "a" just to initialise the variable
    long var1;//similaraly here :)
    if (multiplierDigit == 1) {
      var1=significantDigit*multiplierDigit;
      resistorValue=Long.toString(var1)+" Ohm";
    } else if (multiplierDigit == 10) {
      var1=significantDigit*multiplierDigit;
      resistorValue=Long.toString(var1)+" Ohm";
    } else if (multiplierDigit == 100) {
      var1=significantDigit*multiplierDigit;
      resistorValue=Long.toString(var1)+" Ohm";
    } else if (multiplierDigit == 1000) {
      var1=significantDigit;
      resistorValue=Long.toString(var1)+" KiloOhm";
    } else if (multiplierDigit == 10000) {
      var1=significantDigit*10;
      resistorValue=Long.toString(var1)+" KiloOhm";
    } else if (multiplierDigit == 100000) {
      var1=significantDigit*100;
      resistorValue=Long.toString(var1)+" KiloOhm";
    } else if (multiplierDigit == 1000000) {
      var1=significantDigit;
      resistorValue=Long.toString(var1)+" MegaOhm";
    } else if (multiplierDigit == 10000000) {
      var1=significantDigit*10;
      resistorValue=Long.toString(var1)+" MegaOhm";
    } else {
      System.out.println("\033[1;32m[\033[1;31m!\033[1;32m] \033[1;34mOut of range!\033[0;00m");
    }
    return resistorValue;
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
