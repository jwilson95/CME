package Impl.Service;

import Impl.PalindromeImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
@Slf4j
@Service
public class PalindromeImplService implements PalindromeImpl {

        ArrayList<String> username;
        ArrayList<String> value;

        @Override
        public void palindromeChecker(@RequestParam String userName, @RequestParam String input) {
                StringBuilder reverseValue = new StringBuilder();

                // Go to the end of the string and get each char
                for (int i = input.length() - 1; i >=0; i--){
                        // Appends each char to the end of the string value reverseValue until loop finishes
                        reverseValue.append(input.charAt(i));
                }
                // Comparing both values to see if they are equal
                if(Objects.equals(input, reverseValue.toString())){
                        log.info(String.valueOf(true));
                        saveToCache(userName, input);
                }else {
                        log.info(String.valueOf(false));
                }
        }

        @Override
        public void saveToCache(String userName, String textValue) {
                username = new ArrayList<>();
                value = new ArrayList<>();
                username.add(userName);
                value.add(textValue);
        }

        @Override
        public void loadCache(String values) {
                // TODO load cache
        }


}
