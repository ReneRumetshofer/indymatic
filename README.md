# indymatic
Automatic Indy enrolment system with random activity choosing. Forked from [https://github.com/stnwtr/indymatic](https://github.com/stnwtr/indymatic)

## Clone and set up
Clone the repository by typing `git clone https://github.com/ReneRumetshofer/indymatic.git` in the terminal.

## The `priorities` file
Create a file which contains all the priorities for hour and day.
* `#` only at line beginning are for comments
* `t` takes an entry by teacher
* `r` takes an entry by room

### Construction
The priority file contains lines of priority ordered entries.
Each line has a few fields which are separated by colons (`:`).
The case of the entries does not matter.

A line is structured as follows:
```
day : hour : priority : type : id
```
* `day` is the day of the event (`Mo`, `Mi`, `Fr`)
* `hour` is the hour the indy lesson is in (`3`, `4`)
* `priority` determines the entry priority. `1` means highest priority, `2` is a lower priority and `3` is even lower (range from `1` to `n`)
* `type` Can either be `T` for teacher or `T` for room.
* `id` The id of the teacher or the room (`Ham`, `Er`, `L01`, `NTL2`)

### Examples
Here are a few example lines for the priority file. Note: subject and activity strings have to be present, but won't be used. The activity (and subject) will be chosen 
from the activity pool file.
```
Mo : 3 : 1 : r : l01
Mo : 3 : 2 : t : ham
```
[This](https://github.com/ReneRumetshofer/indymatic/blob/master/src/main/resources/priorities.cfg) is a sample file you could use as it is.

## The `activity_pool` file
This tool picks a random activity (subject + description) for a day.
Create a file which contains different activities for Indy lessions.
* `#` at line beginning -> comment

### Construction
The activity pool file contains lines of Indy activities. It is case-insensitive.
Each line contains two fields separated by one colon (`:`).

An activity is structured as follows:
```
subject : activity
```
* `subject` is the school subject in a indy lesson
* `activity` is the activity a student is planning to do in a lesson

### Examples
```
am : Binomialverteilungsübungen
am : Übungen für Maturabereich Algebra und Geometrie
```
One of the two activity lines will be chosen for one indy day.
[This](https://github.com/ReneRumetshofer/indymatic/blob/master/src/main/resources/pool.cfg) is a sample file you can use.

## Launching
The tool needs to be built manually for launching. Alternatively a pre-built .JAR can be used (found in releases).

### Building
The tool can be built by using the command line.
With `./gradlew fatJar` or `./gradlew.bat fatJar` you can build the jar file including all dependencies.
Once you got the jar file you can run the tool using the command line.
Type `java -jar indymatic.jar <username> <number> <priorities> <activity_pool>` to run the program.
* `username` is the indy username
* `number` is the number of upcoming events (Indy days) to enrol in
* `priorities` is the priority file (that has been created above)
* `activity_pool` is the activity pool file (created above), containing Indy activities that get randomly chosen for a day
