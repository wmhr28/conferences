# CONFERENCE TRACK MANAGEMENT
You are planning a big programming conference and have received many proposals which have passed the initial screen process but you're having trouble fitting them into the time constraints of the day -- there are so many possibilities! So you write a program to do it for you.

* The conference has multiple tracks each of which has a morning and afternoon session.
* Each session contains multiple talks.
* Morning sessions begin at 9am and must finish by 12 noon, for lunch.
* Afternoon sessions begin at 1pm and must finish in time for the networking event.
* The networking event can start no earlier than 4:00 and no later than 5:00.
* No talk title has numbers in it.
* All talk lengths are either in minutes (not hours) or lightning (5 minutes).
* Presenters will be very punctual; there needs to be no gap between sessions.

**Note that depending on how you choose to complete this problem, your solution may give a different ordering or combination of talks into tracks. This is acceptable; you don’t need to exactly duplicate the sample output given here.**

### Installation

Unzip the contents of the file conferences.zip, enter the folder "target" there you will find the file conferences-1.0.0-jar-with-dependencies.jar is the executable file that starts the Conferences system, need a txt file with the events.

### Usage
```bash
java -jar conferences-1.0.0-jar-with-dependencies.jar
Enter a file path:
```
 ### Example on Windows
```bash
java -jar conferences-1.0.0-jar-with-dependencies.jar
Enter a file path:  C:\Users\wm_herrera\Documents\NetBeansProjects\conferences\src\main\resources\conference1.txt
```
### Test files
I have created a set of files to do tests, they are in the following path
```bash
src\main\resources
and 
target\classes
```

### Sample File (input)

```bash
Writing Fast Tests Against Enterprise Rails 60min
Overdoing it in Python 45min
Lua for the Masses 30min
Ruby Errors from Mismatched Gem Versions 45min
Common Ruby Errors 45min
Rails for Python Developers lightning
Communicating Over Distance 60min
Accounting-Driven Development 45min
Woah 30min
Sit Down and Write 30min
Pair Programming vs Noise 45min
Rails Magic 60min
Ruby on Rails: Why We Should Move On 60min
Clojure Ate Scala (on my project) 45min
Programming in the Boondocks of Seattle 30min
Ruby vs. Clojure for Back-End Development 30min
Ruby on Rails Legacy App Maintenance 60min
A World Without HackerNews 30min
User Interface CSS in Rails Apps 30min
```

### Output

```bash
Track1
09:00AM Writing Fast Tests Against Enterprise Rails 60min
10:00AM Communicating Over Distance 60min
11:00AM Rails Magic 60min
12:00PM Lunch
01:00PM Ruby on Rails: Why We Should Move On 60min
02:00PM Ruby on Rails Legacy App Maintenance 60min
03:00PM Overdoing it in Python 45min
03:45PM Ruby Errors from Mismatched Gem Versions 45min
04:30PM Lua for the Masses 30min
05:00PM Networking Event
Track2
09:00AM Common Ruby Errors 45min
09:45AM Accounting-Driven Development 45min
10:30AM Pair Programming vs Noise 45min
11:15AM Clojure Ate Scala (on my project) 45min
12:00PM Lunch
01:00PM Woah 30min
01:30PM Sit Down and Write 30min
02:00PM Programming in the Boondocks of Seattle 30min
02:30PM Ruby vs. Clojure for Back-End Development 30min
03:00PM A World Without HackerNews 30min
03:30PM User Interface CSS in Rails Apps 30min
04:00PM Rails for Python Developers lightning
05:00PM Networking Event

```
