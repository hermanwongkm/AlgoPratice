/* IMPORTANT: Multiple classes and nested static classes are supported */



//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        s.nextLine();
        for(int i = 0; i < num; i++){
            String hex = s.nextLine();
            isPalidrome(hex,hex);
        }
    }

    public static void isPalidrome(String hex, String originalHex){
        if(hex.length() % 2 == 0){
            StringBuilder tempHex = new StringBuilder();
            tempHex.append(hex);

            StringBuilder convertedHex = new StringBuilder();
            convertedHex.append(tempHex.substring(0,tempHex.length() / 2));
    
            convertedHex.append(tempHex.delete(tempHex.length()/2,tempHex.length()).reverse());
            int value = Integer.parseInt(convertedHex.toString(),16);
            int originalHexValue = Integer.parseInt(originalHex,16);
            if(value > originalHexValue){
                System.out.println(convertedHex);
            }
            else{
                //Get middle element, and it will always be 2 values
                String middleElements = convertedHex.substring(convertedHex.length()/2 -1, convertedHex.length()/2 + 1);
                if(Integer.parseInt(String.valueOf(middleElements),16) + 17 < 255){
                    int newValue = Integer.parseInt(String.valueOf(middleElements),16) + 17;
                    String newHexValue = Integer.toHexString(newValue);
                    convertedHex.replace(convertedHex.length()/2 - 1, convertedHex.length()/2 + 1, newHexValue);
                    System.out.println(convertedHex);
                }
                else{
                    String numberUntillMiddle = convertedHex.substring(0, convertedHex.length()/2 +1);
                    int newValue = Integer.parseInt(numberUntillMiddle,16) + 1;
                    String newHexValue = Integer.toHexString(newValue);
                    convertedHex.replace(0,convertedHex.length()/2 + 1, newHexValue);
                    isPalidrome(convertedHex.toString(), hex);
                }
            }

        }
        else{
            StringBuilder tempHex = new StringBuilder();
            tempHex.append(hex);

            StringBuilder convertedHex = new StringBuilder();
            convertedHex.append(tempHex.substring(0,tempHex.length() / 2 + 1));
    
            convertedHex.append(tempHex.delete(tempHex.length()/2,tempHex.length()).reverse());
            int value = Integer.parseInt(convertedHex.toString(),16);
            int originalHexValue = Integer.parseInt(hex,16);
            if(value > originalHexValue){
                System.out.println(convertedHex);
            }
            //If it is not larger i need to do some increments
            else{
                char middleElement = convertedHex.charAt(convertedHex.length()/2);
                if(Integer.parseInt(String.valueOf(middleElement),16) < 15){
                    int newValue = Integer.parseInt(String.valueOf(middleElement),16) + 1;
                    String newHexValue = Integer.toHexString(newValue);
                    convertedHex.replace(convertedHex.length()/2, convertedHex.length()/2 + 1, newHexValue);
                    System.out.println(convertedHex);
                }
                else{
                    String numberUntillMiddle = convertedHex.substring(0, convertedHex.length()/2 +1);
                    int newValue = Integer.parseInt(numberUntillMiddle,16) + 1;
                    String newHexValue = Integer.toHexString(newValue);
                    convertedHex.replace(0,convertedHex.length()/2 + 1, newHexValue);
                    isPalidrome(convertedHex.toString(),hex);
                }
            }
        }
    }

}
