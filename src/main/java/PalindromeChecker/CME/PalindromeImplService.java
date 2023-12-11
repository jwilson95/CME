package PalindromeChecker.CME;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Getter
@Setter
@Slf4j
@Service
public class PalindromeImplService {

        // TODO variables that will be used for file caching
        private String username;
        private String value;

        public static boolean palindromeChecker(@RequestParam String input){

                StringBuilder reverseValue = new StringBuilder();
                boolean result;

                // Go to the end of the string and get each char
                for (int i = input.length() - 1; i >=0; i--){
                        // Appends each char to the end of the string value reverseValue until loop finishes
                        reverseValue.append(input.charAt(i));
                }

                // Comparing both values to see if they are equal
                if(Objects.equals(input, reverseValue.toString())){
                        result = true;
                        log.info("This is a palindrome: " + input);
                }else {
                        result = false;
                        log.info("This is not a palindrome: " + input);
                }
                return result;
        }


}
