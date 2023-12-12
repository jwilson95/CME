Introduction
write a Java program based on provided requirements.
Please state all assumptions when implementing a solution.
Please do not use Chat GPT or similar AI tool to complete this task.
It is important to deliver elegant object-oriented code, apply design patterns and consider
performance of the implementation.
Your delivered program should compile (provide all required files) and run, and you should also
include appropriate usage documentation.
Palindrome Checker

Develop a REST API to accept a username and text value and return an indicator whether that value
is a palindrome - A palindrome is a word, number, phrase, or other sequence of characters which
reads the same backward as forward, such as madam or kayak.

The solution should include the ability to:
• Validate the input – for the first release values with spaces or numbers should be rejected.
The solution should support the ability to easily add further validations over time though.
• To improve performance a cache should be kept of previously processed values.
• Each processed value should also be written to a permanent storage solution (for the
purposes of this POC a file system can be used however this should be easily substituted for
a Database solution for example).
• Upon start up the cache should be populated with the contents from the permanent
storage.
• This solution should include appropriate tests.
• Assist in diagnosing any support enquires.
• For this POC no API authorization is required.

TODO:
- Create an application that checks if an input is a palindrome or not.
- Caching will be implemented via ArrayList
- create a controller for rest API functionality
- write user tests