Coding challenge
————————————
At Frontline’s Nairobi office, we hold daily standup meetings at 9:55. In order to prepare for and attend these meetings,
we expect dev team members to be in by 9:50am. In order to enforce this in a friendly/playful way, we have a “coffee checkin”: 
whenever a team member is late, they have to buy coffee for one of their colleagues who was on time.
This coffee checkin is currently tracked using a simple text list in a chat channel. 
Your task is to write a Java program that automates this process.
In the current process, whenever an employee is late, they must update the list in coffee checkin to indicate:
- who was late
- who gets coffee as a result
- who is next in queue to get coffee the next time someone is late
For example, this was the state on Monday:
Joe
Muthoni <- next
Grace
Otieno
Hashim
If on Tuesday morning Joe is late, he should update the list to show the new state as below:
Joe <- late
Muthoni <- gets coffee from Joe
Grace <- next
Otieno
Hashim
If on Wednesday, Grace is late, she forfeits her ‘next’ slot:
Joe
Muthoni
Grace <- late
Otieno <- gets coffee from Grace
Hashim <- next

As the examples above show:
- whenever someone gets a coffee, the next person down in the list becomes the new ‘next beneficiary’.
- If the ‘next beneficiary’ is late themselves, they are skipped and must buy the next person a coffee.
Implement a Java command-line program that simulates this process through one working week (Monday to Friday) 
in a single invocation of the program:
1. when launched, the user should be prompted to provide the list of employees. 
The first one can be assumed to be ‘next’ for Monday.
2. the user should then be prompted to enter the list of late employees for Monday.
The program should output the updated list, showing who should buy coffees, and who is next in line for Tuesday
3. the user should be prompted to repeat step 2 above for the rest of the week, Tuesday through Friday.
4. at the end of the week, print out the final state and exit
Note that the entire week should be simulated in one run of the program.
——
Your solution should be provided in Java, with no use of external libraries except for testing purposes.
Please submit your source code with your submission.