import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextAnalyzer {
    public static void main(String[] args) {
       
        
        String fileName = args[0];
        
        
        long startTime = System.currentTimeMillis();
        
        System.out.println("Program start:\n");
        
        
        int totalCharCount = 0;
        int palindromeCount = 0;
        int tokenCount = 0;
        int emoticonCount = 0;
        int newLineCount = 0;
        String longestToken = "";
        int totalTokenLength = 0;
        
        // Define a set of emoticons to check against (using an array for simplicity)
        String[] emoticons = {":)", ":-)", ":(", ":-(", ";)", ";-)", ":D", ":-D", ":'(", ":'-(", ":P", ":-P"};
        
        // Open and read the file specified by the command-line argument
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Process the file line by line
            while ((line = reader.readLine()) != null) {
                newLineCount++;
                totalCharCount += line.length();
                
                // Split the line into tokens using whitespace as the delimiter
                String[] tokens = line.split("\\s+");
                for (String token : tokens) {
                    // Skip empty tokens (could occur if there are multiple spaces)
                    if (token.isEmpty()) {
                        continue;
                    }
                    
                    tokenCount++;
                    totalTokenLength += token.length();
                    
                    // Check if the token is a palindrome
                    if (isPalindrome(token)) {
                        palindromeCount++;
                    }
                    
                    // Check if the token is one of the defined emoticons
                    for (String emo : emoticons) {
                        if (token.equals(emo)) {
                            emoticonCount++;
                            break;
                        }
                    }
                    
                    // Update the longest token if this token is longer than the previous one
                    if (token.length() > longestToken.length()) {
                        longestToken = token;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        
        // Calculate the average token size
        double averageTokenSize = (tokenCount > 0) ? (double) totalTokenLength / tokenCount : 0;
        
        // Calculate total execution time in seconds
        long endTime = System.currentTimeMillis();
        double totalTime = (endTime - startTime) / 1000.0;
        
        // Output the results
        System.out.println("Total # Character count: " + totalCharCount);
        System.out.println("Total # Palindrome found: " + palindromeCount);
        System.out.println("Total Number of tokens: " + tokenCount);
        System.out.println("Total Number of emoticon: " + emoticonCount);
        System.out.println("Total # of new line: " + newLineCount);
        System.out.println("Longest token: " + longestToken);
        System.out.printf("Average token size: %.2f\n", averageTokenSize);
        System.out.println("Total time to execute this program: " + totalTime + " secs\n");
        
        System.out.println("Program terminated properly!");
    }
    
    /**
     * Checks if a given token is a palindrome.
     * Non-alphanumeric characters are removed and the check is case-insensitive.
     * Tokens of length 0 or 1 are not considered palindromes.
     */
    public static boolean isPalindrome(String token) {
        // Remove non-alphanumeric characters and convert to lower case
        String cleaned = token.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        if (cleaned.length() <= 1) {
            return false;
        }
        
        int left = 0;
        int right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}